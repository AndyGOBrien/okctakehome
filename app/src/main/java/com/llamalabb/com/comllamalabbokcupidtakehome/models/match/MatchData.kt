package com.llamalabb.com.comllamalabbokcupidtakehome.models.match

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser

/**
 * Created by andyg on 1/7/2018.
 */
data class MatchData(
        @SerializedName("total_matches")
        @Expose
        val totalMatches: Int,

        @SerializedName("data")
        @Expose
        val data: List<MatchedUser>,

        @SerializedName("paging")
        @Expose
        val paging: Paging
)