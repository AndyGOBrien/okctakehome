package com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.blend

import com.llamalabb.com.comllamalabbokcupidtakehome.formatMatchPercent
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service.MatchedUsersRepository
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser
import com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.liked.LikedTabContract

/**
 * Created by andyg on 1/7/2018.
 */
class LikedTabPresenter(val view: LikedTabContract.LikedTabView)
    : LikedTabContract.TabPresenter {

    override fun onStart() {
        MatchedUsersRepository.getUsersFromApi().subscribe{
            MatchedUsersRepository.users = it.data
            processMatchedUsers(MatchedUsersRepository.users)
        }
    }

    private fun processMatchedUsers(matchedUsers: List<MatchedUser>){
            sortMatchPercent(matchedUsers)
    }


    private fun sortMatchPercent(matchedUsers: List<MatchedUser>){
        val sortedList = matchedUsers.sortedWith(compareBy{it.match})
        view.showSearchList(sortedList)
    }

    override fun onBindMatchItemAtPosition(position: Int, searchItem: LikedTabContract.SearchItem) {
            displaySearchItem(getLikedUsers(), position, searchItem)
    }

    override fun handleSearchItemClick(index: Int) {

    }

    private fun displaySearchItem(list: List<MatchedUser>, position: Int, searchItem: LikedTabContract.SearchItem){
        with(list[position]) {
            val quickInfo = "$age • ${location.cityName}, ${location.stateCode}"
            val twoDigitMatchStr = match.formatMatchPercent()
            searchItem.displayPhoto(photo.fullPaths.original, photo.cropRect.x, photo.cropRect.y)
            searchItem.displayUsername(username)
            searchItem.displayMatchPercentage(twoDigitMatchStr)
            searchItem.displayQuickInfo(quickInfo)
        }
    }

    private fun getLikedUsers(): List<MatchedUser>{
        return ArrayList<MatchedUser>()
    }

    override fun getSearchItemCount(): Int = getLikedUsers().size
}