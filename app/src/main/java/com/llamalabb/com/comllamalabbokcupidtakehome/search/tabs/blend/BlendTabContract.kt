package com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.blend

import com.llamalabb.com.comllamalabbokcupidtakehome.BasePresenter
import com.llamalabb.com.comllamalabbokcupidtakehome.BaseView
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser


/**
 * Created by andyg on 1/7/2018.
 */
class BlendTabContract {
    interface SearchTabView: BaseView<TabPresenter>{
        fun showSearchList()
        fun refreshList()
    }

    interface TabPresenter: BasePresenter, TabAdapterPresenter {

    }

    interface TabAdapterPresenter{
        fun onBindMatchItemAtPosition(position: Int, searchItem: SearchItem)
        fun handleSearchItemClick(index: Int)
        fun getSearchItemCount(): Int
    }

    interface SearchItem{
        fun displayQuickInfo(info: String)
        fun displayUsername(username: String)
        fun displayPhoto(url: String, x: Int, y: Int)
        fun displayMatchPercentage(match: String)
        fun displayLiked(isLiked: Boolean)
    }
}