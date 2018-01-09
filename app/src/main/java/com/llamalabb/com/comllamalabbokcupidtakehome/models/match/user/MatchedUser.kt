package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.photo.MatchedPhotoInfo


/**
 * Created by andyg on 1/7/2018.
 */
@Entity(tableName = "LikedUsers")
data class MatchedUser(
        @PrimaryKey
        @ColumnInfo(name="id")
        @SerializedName("userid")
        @Expose
        val userId: String,

        @ColumnInfo(name = "liked")
        @SerializedName("liked")
        @Expose
        var liked: Boolean,

        @SerializedName("enemy")
        @Expose
        val enemy: Int,

        @SerializedName("relative")
        @Expose
        val relative: Long,

        @SerializedName("last_login")
        @Expose
        val lastLogin: Long,

        @SerializedName("gender")
        @Expose
        val gender: Int,

        @SerializedName("location")
        @Expose
        val location: UserLocation,

        @SerializedName("match")
        @Expose
        val match: Int,

        @SerializedName("gender_tags")
        @Expose
        val genderTags: List<String>,

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
)