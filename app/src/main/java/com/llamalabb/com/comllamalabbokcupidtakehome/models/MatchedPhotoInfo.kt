package com.llamalabb.com.comllamalabbokcupidtakehome.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by andyg on 1/7/2018.
 */
data class MatchedPhotoInfo(
        @SerializedName("full_paths")
        @Expose
        val fullPaths: Map<String, String>,

        @SerializedName("base_path")
        @Expose
        val basePath: String,

        @SerializedName("original_size")
        @Expose
        val originalSize: Map<String, Int>,

        @SerializedName("ordinal")
        @Expose
        val ordinal: Int,

        @SerializedName("id")
        @Expose
        val id: String,

        @SerializedName("crop_rect")
        @Expose
        val cropRect: Map<String, Int>,

        @SerializedName("caption")
        @Expose
        val caption: String,

        @SerializedName("thumb_paths")
        @Expose
        val thumbPaths: Map<String, String>
)