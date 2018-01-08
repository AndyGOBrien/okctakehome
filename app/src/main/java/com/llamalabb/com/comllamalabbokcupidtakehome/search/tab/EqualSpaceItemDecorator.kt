package com.llamalabb.com.comllamalabbokcupidtakehome.search.tab

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by andyg on 1/7/2018.
 */
class EqualSpaceItemDecorator(context: Context, dimenId: Int) : RecyclerView.ItemDecoration() {

    private val spaceHeight = context.resources.getDimensionPixelSize(dimenId)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(spaceHeight, spaceHeight, spaceHeight, spaceHeight)
    }
}