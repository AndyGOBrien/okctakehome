package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by andyg on 1/7/2018.
 */
data class UserLocation(
    @SerializedName("country_code")
    @Expose
    val countryCode: String,

    @SerializedName("city_name")
    @Expose
    val cityName: String,

    @SerializedName("country_name")
    @Expose
    val countryName: String,

    @SerializedName("state_name")
    @Expose
    val stateName: String,

    @SerializedName("state_code")
    @Expose
    val stateCode: String

)