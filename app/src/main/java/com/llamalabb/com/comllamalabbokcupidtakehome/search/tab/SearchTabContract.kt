package com.llamalabb.com.comllamalabbokcupidtakehome.search.tab

import com.llamalabb.com.comllamalabbokcupidtakehome.BasePresenter
import com.llamalabb.com.comllamalabbokcupidtakehome.BaseView
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser


/**
 * Created by andyg on 1/7/2018.
 */
class SearchTabContract {
    interface SearchTabView: BaseView<SearchTabContract.TabPresenter>{
        fun showSearchList(matchedUsers: List<MatchedUser>)
        fun refreshList()
    }

    interface TabPresenter: BasePresenter, TabAdapterPresenter{

    }

    interface TabAdapterPresenter{
        fun onBindMatchItemAtPosition(position: Int, searchItem: SearchItem)
        fun handleSearchItemClick(index: Int)
        fun getSearchItemCount(): Int
    }

    interface SearchItem{
        fun displayQuickInfo(info: String)
        fun displayUsername(username: String)
        fun displayPhoto(url: String)
        fun displayMatchPercentage(match: String)
        fun displayLiked(isLiked: Boolean)
    }
}