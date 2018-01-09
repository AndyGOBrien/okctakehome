package com.llamalabb.com.comllamalabbokcupidtakehome

import android.content.Context
import android.util.Log
import android.widget.ImageView

/**
 * Created by andy on 1/9/18.
 */
class SquareImageView(context: Context) : ImageView(context){
    var squareDim = 1000000000
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val h = this.measuredHeight
        val w = this.measuredWidth

        val curSquareDim = if (Math.min(w,h) == 0) Math.max(w,h) else Math.min(w,h)

        if(curSquareDim < squareDim) squareDim = curSquareDim

        Log.d("SquareImageView", "h: $h / w: $w / SquareDim: $curSquareDim")

        setMeasuredDimension(squareDim, squareDim)
    }
}