package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.photo

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose



/**
 * Created by andyg on 1/7/2018.
 */
data class FullPaths(
    @SerializedName("large")
    @Expose
    val large: String = "",

    @SerializedName("small")
    @Expose
    val small: String = "",

    @SerializedName("medium")
    @Expose
    val medium: String = "",

    @SerializedName("original")
    @Expose
    val original: String = ""
)
