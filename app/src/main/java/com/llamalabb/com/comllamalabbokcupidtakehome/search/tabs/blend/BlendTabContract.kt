package com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.blend

import com.llamalabb.com.comllamalabbokcupidtakehome.base.BasePresenter
import com.llamalabb.com.comllamalabbokcupidtakehome.base.BaseView


/**
 * Created by andyg on 1/7/2018.
 */
class BlendTabContract {
    interface SearchTabView: BaseView<TabPresenter> {
        fun showSearchList()
        fun refreshList()
    }

    interface TabPresenter: BasePresenter, TabAdapterPresenter {

    }

    interface TabAdapterPresenter{
        fun onBindMatchItemAtPosition(position: Int, searchItem: SearchItemView)
        fun handleSearchItemClick(index: Int)
        fun getSearchItemCount(): Int
    }

    interface SearchItemView {
        fun displayQuickInfo(info: String)
        fun displayUsername(username: String)
        fun displayPhoto(url: String, x: Int, y: Int)
        fun displayMatchPercentage(match: String)
        fun displayLiked(isLiked: Boolean)
    }
}