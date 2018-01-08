package com.llamalabb.com.comllamalabbokcupidtakehome

import android.widget.ImageView

/**
 * Created by andyg on 1/7/2018.
 */
fun ImageView.loadImage(url : String) {
    GlideApp.with(context)
            .load(url)
            .fitCenter()
            .into(this)
}

fun Int.formatMatchPercent() = "%.0f".format(this.toDouble()*.01)