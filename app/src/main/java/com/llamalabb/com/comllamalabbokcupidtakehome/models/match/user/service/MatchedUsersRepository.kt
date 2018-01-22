package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service

import com.llamalabb.com.comllamalabbokcupidtakehome.MyApp
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service.MatchedUsersRepository.likedUsersCache


/**
 * Created by andyg on 1/7/2018.
 */
object MatchedUsersRepository {

    var usersCache = ArrayList<MatchedUser>()
    var likedUsersCache = HashSet<String>()
    private val userDao = MyApp.database.userDao()

    init{
        updateLikedUserCache()
    }

    private val MATCHED_USERS_EXAMPLE_URL = "https://www.okcupid.com"

    private fun getMatchedUsersRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
                .baseUrl(MATCHED_USERS_EXAMPLE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    private fun getMatchedUsersApiService() = getMatchedUsersRetrofitInstance()
            .create(MatchedUserApiService::class.java)

    fun getUsersFromApi() = getMatchedUsersApiService().getMatchedUsers()

    fun storeLikedUsersInDb(users: List<MatchedUser>){
        Observable.fromCallable { userDao.insertAll(users) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe()
    }

    fun deleteLikedUser(user: MatchedUser){
        likedUsersCache.remove(user.userId)
        Observable.fromCallable{ userDao.deleteUser(user) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe()
    }

    fun isUserLiked(userId: String): Boolean = likedUsersCache.contains(userId)


    fun getLikedUsersFromDb() = userDao.getUsers().filter{ it.isNotEmpty() }
            .toObservable()

    fun saveLikedUser(user: MatchedUser){
        likedUsersCache.add(user.userId)
        Observable.fromCallable { userDao.insert(user) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe()
    }

    private fun updateLikedUserCache(){
        getLikedUsersFromDb()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe{ it.forEach { likedUsersCache.add(it.userId) } }
    }
}