package com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by andyg on 1/7/2018.
 */
data class MatchedPhotoInfo(
        @SerializedName("full_paths")
        @Expose
        val fullPaths: FullPaths = FullPaths(),

        @SerializedName("base_path")
        @Expose
        val basePath: String = "",

        @SerializedName("original_size")
        @Expose
        val originalSize: OriginalSize = OriginalSize(),

        @SerializedName("ordinal")
        @Expose
        val ordinal: Int = 0,

        @SerializedName("id")
        @Expose
        val id: String = "",

        @SerializedName("crop_rect")
        @Expose
        val cropRect: CropRect = CropRect(),

        @SerializedName("caption")
        @Expose
        val caption: String = "",

        @SerializedName("thumb_paths")
        @Expose
        val thumbPaths: ThumbPaths = ThumbPaths()
)