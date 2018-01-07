package com.llamalabb.com.comllamalabbokcupidtakehome.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by andyg on 1/7/2018.
 */

object RetroClient{
    private val MATCHED_USERS_EXAMPLE_URL = "https://www.okcupid.com"

    private fun getMatchedUsersRetrofitInstance() : Retrofit{
        return Retrofit.Builder()
                .baseUrl(MATCHED_USERS_EXAMPLE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getMatchedUsersApiService() : ApiService = getMatchedUsersRetrofitInstance().create(ApiService::class.java)
}