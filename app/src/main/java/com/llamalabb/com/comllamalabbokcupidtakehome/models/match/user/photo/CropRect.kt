package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by andyg on 1/7/2018.
 */
data class CropRect(
        @SerializedName("height")
        @Expose
        val height: Int = 0,

        @SerializedName("y")
        @Expose
        val y: Int = 0,

        @SerializedName("width")
        @Expose
        val width: Int = 0,

        @SerializedName("x")
        @Expose
        val x: Int = 0
) : Serializable