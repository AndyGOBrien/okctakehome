package com.llamalabb.com.comllamalabbokcupidtakehome

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.security.MessageDigest
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.PAINT_FLAGS
import com.bumptech.glide.load.resource.bitmap.TransformationUtils


/**
 * Created by andyg on 1/9/2018.
 */
class CropBitmapDimensions(private val x: Int, private val y: Int) : BitmapTransformation() {
    override fun updateDiskCacheKey(messageDigest: MessageDigest?) {

    }

    override fun transform(pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap {
        val transformed = crop(toTransform, outWidth, outHeight)
        return transformed
    }

    private fun crop(toTransform: Bitmap, outWidth: Int, outHeight: Int) : Bitmap{
        if (toTransform.width == outWidth && toTransform.height == outHeight) return toTransform
        val m = Matrix()
        val dx = if(x == outWidth) x.toFloat() else if(x==0) 0f else x.toFloat()/outWidth.toFloat()
        val dy = if(y == outHeight) y.toFloat() else if(y==0) 0f else y.toFloat()/outHeight.toFloat()
        m.postTranslate(dx, dy)
        val result = Bitmap.createBitmap(outWidth, outHeight, getSafeConfig(toTransform))
        TransformationUtils.setAlpha(toTransform, result)
        val canvas = Canvas(result)
        val paint = Paint(PAINT_FLAGS)
        canvas.drawBitmap(toTransform, m, paint)
        return result
    }

    private fun getSafeConfig(bitmap: Bitmap): Bitmap.Config {
        return if (bitmap.config != null) bitmap.config else Bitmap.Config.ARGB_8888
    }
}