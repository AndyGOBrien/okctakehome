package com.llamalabb.com.comllamalabbokcupidtakehome.models.match

import android.database.Cursor
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by andyg on 1/7/2018.
 */
data class Paging(
        @SerializedName("cursors")
        @Expose
        val cursors: Cursors
)