package com.llamalabb.com.comllamalabbokcupidtakehome.search.tab

import com.llamalabb.com.comllamalabbokcupidtakehome.formatMatchPercent
import com.llamalabb.com.comllamalabbokcupidtakehome.models.TabPosition
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.FetchMatchData
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser

/**
 * Created by andyg on 1/7/2018.
 */
class SearchTabPresenter(val view: SearchTabContract.SearchTabView, private val tab: Int)
    : SearchTabContract.TabPresenter{

    lateinit var matchedUsers: List<MatchedUser>

    override fun onStart() {
        FetchMatchData.getMatchedUsers().subscribe{
            matchedUsers = it.data
            processMatchedUsers(matchedUsers)
        }
    }

    private fun processMatchedUsers(matchedUsers: List<MatchedUser>){
        when(tab){
            TabPosition.SPECIAL_BLEND -> sortSpecialBlend(matchedUsers)
            TabPosition.MATCH_PERCENT -> sortMatchPercent(matchedUsers)
        }
    }

    private fun sortSpecialBlend(matchedUsers: List<MatchedUser>){
        view.showSearchList(matchedUsers)
    }

    private fun sortMatchPercent(matchedUsers: List<MatchedUser>){
        val sortedList = matchedUsers.sortedWith(compareBy{it.match})
        view.showSearchList(sortedList)
    }

    override fun onBindMatchItemAtPosition(position: Int, searchItem: SearchTabContract.SearchItem) {
        when(tab) {
            TabPosition.SPECIAL_BLEND -> displaySearchItem(matchedUsers, position, searchItem)
            TabPosition.MATCH_PERCENT -> displaySearchItem(getLikedUsers(), position, searchItem)
        }
    }

    private fun displaySearchItem(list: List<MatchedUser>, position: Int, searchItem: SearchTabContract.SearchItem){
        with(list[position]) {
            val quickInfo = "$age • ${location.cityName}, ${location.stateCode}"
            val twoDigitMatchStr = match.formatMatchPercent()
            searchItem.displayPhoto(photo.fullPaths.original)
            searchItem.displayUsername(username)
            searchItem.displayMatchPercentage(twoDigitMatchStr)
            searchItem.displayQuickInfo(quickInfo)
            searchItem.displayLiked(list[position].liked, isSetSearchItemColor())
        }
    }

    private fun isSetSearchItemColor() = tab == TabPosition.SPECIAL_BLEND

    override fun handleSearchItemClick(index: Int) {
        matchedUsers[index].liked = true
    }

    private fun getLikedUsers(): List<MatchedUser>{
        val likedUsers = ArrayList<MatchedUser>()
        matchedUsers.forEach { if(it.liked) likedUsers.add(it) }
        return likedUsers
    }

    override fun getSearchItemCount(): Int{
        return when(tab){
            TabPosition.SPECIAL_BLEND -> matchedUsers.size
            TabPosition.MATCH_PERCENT -> getLikedUsers().size
            else -> 0
        }
    }
}