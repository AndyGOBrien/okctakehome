package com.llamalabb.com.comllamalabbokcupidtakehome.models.match

import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser
import com.llamalabb.com.comllamalabbokcupidtakehome.retrofit.RetroClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by andyg on 1/7/2018.
 */
object FetchMatchData {
    private val matchedUsersService = RetroClient.getMatchedUsersApiService()
    private val matchedObservable: Observable<MatchData> = matchedUsersService.getMatchedUsers()

    fun getMatchedUsers() = matchedObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())


}