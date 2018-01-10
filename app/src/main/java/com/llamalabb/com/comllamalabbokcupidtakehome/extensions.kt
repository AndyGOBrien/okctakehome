package com.llamalabb.com.comllamalabbokcupidtakehome

import android.widget.ImageView

/**
 * Created by andyg on 1/7/2018.
 */
fun ImageView.loadSquareImage(url : String, x: Int,y: Int) {
    GlideApp.with(context)
            .load(url)
            //transformation only works on first draw. landscape gets cropped incorrectly.
            //most likely need to cache original image first then crop on landscape change
            //.transform(CropBitmapDimensions(x, y))
            .into(this)
}

fun Int.formatMatchPercent() = "%.0f".format(this.toDouble()*.01)