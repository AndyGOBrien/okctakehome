package com.llamalabb.com.comllamalabbokcupidtakehome.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by andyg on 1/7/2018.
 */
data class MatchedUser(
        @SerializedName("enemy")
        @Expose
        val enemy: Int,

        @SerializedName("relative")
        @Expose
        val relative: Int,

        @SerializedName("last_login")
        @Expose
        val lastLogin: Long,

        @SerializedName("gender")
        @Expose
        val gender: Int,

        @SerializedName("location")
        @Expose
        val location: Map<String, String>,

        @SerializedName("user_id")
        @Expose
        val userId: String,

        @SerializedName("match")
        @Expose
        val match: Int,

        @SerializedName("gender_tags")
        @Expose
        val genderTags: List<String>,

        @SerializedName("liked")
        @Expose
        val liked: Boolean,

        @SerializedName("state_code")
        @Expose
        val stateCode: String,

        @SerializedName("orientation")
        @Expose
        val orientation: Int,

        @SerializedName("country_name")
        @Expose
        val countryName: String,

        @SerializedName("photo")
        @Expose
        val photo: MatchedPhotoInfo,

        @SerializedName("state_name")
        @Expose
        val stateName: String,

        @SerializedName("age")
        @Expose
        val age: Int,

        @SerializedName("country_code")
        @Expose
        val countryCode: String,

        @SerializedName("friend")
        @Expose
        val friend: Int,

        @SerializedName("is_online")
        @Expose
        val isOnline: Int,

        @SerializedName("username")
        @Expose
        val username: String,

        @SerializedName("city_name")
        @Expose
        val cityName: String,

        @SerializedName("stoplight_color")
        @Expose
        val stopLightColor: String,

        @SerializedName("last_contact_time")
        @Expose
        val lastContactTime: List<Long>,

        @SerializedName("orientation_tags")
        @Expose
        val orientationTags: List<String>


){
}