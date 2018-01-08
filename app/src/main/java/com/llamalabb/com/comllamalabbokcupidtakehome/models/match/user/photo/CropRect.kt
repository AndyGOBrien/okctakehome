package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by andyg on 1/7/2018.
 */
data class CropRect(
        @SerializedName("height")
        @Expose
        val height: Int,

        @SerializedName("y")
        @Expose
        val y: Int,

        @SerializedName("width")
        @Expose
        val width: Int,

        @SerializedName("x")
        @Expose
        val x: Int
)