package com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.liked

import com.llamalabb.com.comllamalabbokcupidtakehome.base.BasePresenter
import com.llamalabb.com.comllamalabbokcupidtakehome.base.BaseView
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser


/**
 * Created by andyg on 1/7/2018.
 */
class LikedTabContract {
    interface LikedTabView : BaseView<TabPresenter> {
        fun showSearchList()
        fun refreshList()
        fun showProfile(user: MatchedUser)
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
    }
}