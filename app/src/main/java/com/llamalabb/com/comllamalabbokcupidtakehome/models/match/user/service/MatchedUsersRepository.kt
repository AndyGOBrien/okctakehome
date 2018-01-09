package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service

import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by andyg on 1/7/2018.
 */
object MatchedUsersRepository {

    lateinit var users: List<MatchedUser>
    val likedUsers = ArrayList<String>()


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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun storeLikedUsersInDb(users: List<MatchedUser>){
        Observable.fromCallable {  }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe()
    }



//    fun getLikedUsersFromDb(): Observable<List<MatchedUser>> {
//
//    }
}