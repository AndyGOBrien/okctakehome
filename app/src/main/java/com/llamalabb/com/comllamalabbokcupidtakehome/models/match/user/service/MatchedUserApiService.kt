package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service

import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.MatchData
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by andyg on 1/7/2018.
 */
interface MatchedUserApiService {
    @GET("/matchSample.json")
    fun getMatchedUsers(): Observable<MatchData>
}