package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * Created by andyg on 1/7/2018.
 */
data class ThumbPaths(
        @SerializedName("large")
        @Expose
        val large: String = "",
        @SerializedName("desktop_match")
        @Expose
        val desktopMatch: String = "",
        @SerializedName("small")
        @Expose
        val small: String = "",
        @SerializedName("medium")
        @Expose
        val medium: String = ""
): Serializable