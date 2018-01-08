package com.llamalabb.com.comllamalabbokcupidtakehome.models.match

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by andyg on 1/7/2018.
 */
data class Cursors(
        @SerializedName("before")
        @Expose
        val before: String,

        @SerializedName("current")
        @Expose
        val current: String,

        @SerializedName("after")
        @Expose
        val after: String
)