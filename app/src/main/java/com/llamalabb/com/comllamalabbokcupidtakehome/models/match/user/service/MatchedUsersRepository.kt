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



/**
 * Created by andyg on 1/7/2018.
 */
object MatchedUsersRepository {

    var usersCache = ArrayList<MatchedUser>()
    var likedUsersCache = HashMap<String, Boolean>()
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

    fun getLikedUsersFromDb() = userDao.getUsers().filter{ it.isNotEmpty() }
            .toObservable()

    fun saveLikedUser(user: MatchedUser){
        likedUsersCache.put(user.userId, user.liked)
        Observable.fromCallable { userDao.insert(user) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe()
    }

    private fun updateLikedUserCache(){
        getLikedUsersFromDb()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe{ it.forEach { likedUsersCache.put(it.userId, it.liked) } }
    }
}