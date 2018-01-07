package com.llamalabb.com.comllamalabbokcupidtakehome.retrofit

import com.llamalabb.com.comllamalabbokcupidtakehome.models.MatchedUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by andyg on 1/7/2018.
 */
interface ApiService {
    @GET("/matchSample.json")
    fun getMatchedUsers(): Call<List<MatchedUser>>
}