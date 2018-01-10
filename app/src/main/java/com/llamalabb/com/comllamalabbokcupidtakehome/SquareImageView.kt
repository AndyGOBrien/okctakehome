package com.llamalabb.com.comllamalabbokcupidtakehome

import android.content.Context

import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by andy on 1/9/18.
 */
class SquareImageView(context: Context, attrs: AttributeSet) : ImageView(context, attrs){
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, widthMeasureSpec)
    }


}