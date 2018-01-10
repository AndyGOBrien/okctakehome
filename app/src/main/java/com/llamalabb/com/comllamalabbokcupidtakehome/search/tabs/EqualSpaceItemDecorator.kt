package com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.llamalabb.com.comllamalabbokcupidtakehome.R





/**
 * Created by andyg on 1/7/2018.
 */
class EqualSpaceItemDecorator(context: Context, dimenId: Int) : RecyclerView.ItemDecoration() {

    private val padding = context.resources.getDimensionPixelSize(dimenId)
    private val spanSize = context.resources.getInteger(R.integer.gallery_columns)


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanSize
        outRect.left = padding - column * padding / spanSize
        outRect.right = (column + 1) * padding / spanSize
        if (position < spanSize) outRect.top = padding
        outRect.bottom = padding

    }
}