package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.photo.MatchedPhotoInfo
import java.io.Serializable


/**
 * Created by andyg on 1/7/2018.
 */
@Entity(tableName = "LikedUsers")
data class MatchedUser(
        @PrimaryKey
        @ColumnInfo(name="userId")
        @SerializedName("userid")
        @Expose
        var userId: String = "",

        @ColumnInfo(name = "liked")
        @SerializedName("liked")
        @Expose
        var liked: Boolean = false,

        @Ignore
        @SerializedName("enemy")
        @Expose
        var enemy: Int = 0,

        @Ignore
        @SerializedName("relative")
        @Expose
        var relative: Long = 0,

        @Ignore
        @SerializedName("last_login")
        @Expose
        var lastLogin: Long = 0,

        @Ignore
        @SerializedName("gender")
        @Expose
        var gender: Int = 0,

        @Ignore
        @SerializedName("location")
        @Expose
        var location: UserLocation = UserLocation(),

        @Ignore
        @SerializedName("match")
        @Expose
        var match: Int = 0,

        @Ignore
        @SerializedName("gender_tags")
        @Expose
        var genderTags: List<String> = emptyList(),

        @Ignore
        @SerializedName("state_code")
        @Expose
        var stateCode: String = "",

        @Ignore
        @SerializedName("orientation")
        @Expose
        var orientation: Int = 0,

        @Ignore
        @SerializedName("country_name")
        @Expose
        var countryName: String = "",

        @Ignore
        @SerializedName("photo")
        @Expose
        var photo: MatchedPhotoInfo = MatchedPhotoInfo(),

        @Ignore
        @SerializedName("state_name")
        @Expose
        var stateName: String = "",

        @Ignore
        @SerializedName("age")
        @Expose
        var age: Int = 0,

        @Ignore
        @SerializedName("country_code")
        @Expose
        var countryCode: String = "",

        @Ignore
        @SerializedName("friend")
        @Expose
        var friend: Int = 0,

        @Ignore
        @SerializedName("is_online")
        @Expose
        var isOnline: Int = 0,

        @Ignore
        @SerializedName("username")
        @Expose
        var username: String = "",

        @Ignore
        @SerializedName("city_name")
        @Expose
        var cityName: String = "",

        @Ignore
        @SerializedName("stoplight_color")
        @Expose
        var stopLightColor: String = "",

        @Ignore
        @SerializedName("last_contact_time")
        @Expose
        var lastContactTime: List<Long> = emptyList(),

        @Ignore
        @SerializedName("orientation_tags")
        @Expose
        var orientationTags: List<String> = emptyList()
) : Serializable