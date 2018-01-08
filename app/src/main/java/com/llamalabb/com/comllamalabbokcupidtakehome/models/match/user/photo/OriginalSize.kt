package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by andyg on 1/7/2018.
 */
data class OriginalSize(
        @SerializedName("width")
        @Expose
        val width: Int,

        @SerializedName("height")
        @Expose
        val height: Int
)