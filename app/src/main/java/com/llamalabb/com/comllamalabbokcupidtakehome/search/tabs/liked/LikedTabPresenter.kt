package com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.blend

import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service.MatchedUsersRepository
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser
import com.llamalabb.com.comllamalabbokcupidtakehome.search.BusEvent
import com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.liked.LikedTabContract

/**
 * Created by andyg on 1/7/2018.
 */
class LikedTabPresenter(val view: LikedTabContract.LikedTabView)
    : LikedTabContract.TabPresenter {

    private val MAX_ITEMS_IN_VIEW = 6
    private var likedUsers = emptyList<MatchedUser>()

    override fun onStart() {
        view.showSearchList()
        Bus.observe<BusEvent.UpdateLikedTab>()
                .subscribe{ processMatchedUsers() }
                .registerInBus(this)
    }

    private fun processMatchedUsers(){
        val tempList = ArrayList<MatchedUser>()
        MatchedUsersRepository.usersCache.forEach {
            if(MatchedUsersRepository.likedUsersCache.contains(it.userId)) tempList.add(it)
        }

        likedUsers = if (tempList.size <= MAX_ITEMS_IN_VIEW) {
            tempList.sortedWith(compareByDescending { it.match })
        } else {
            tempList.sortedWith(compareByDescending { it.match })
                    .subList(0, MAX_ITEMS_IN_VIEW)
        }

        view.refreshList()
    }

    private fun Int.formatMatchPercent() = "%.0f".format(this.toDouble()*.01)

    override fun onBindMatchItemAtPosition(position: Int, searchItem: LikedTabContract.SearchItem) {
        with(likedUsers[position]) {
            val quickInfo = "$age • ${location.cityName}, ${location.stateCode}"
            val twoDigitMatchStr = match.formatMatchPercent()
            searchItem.displayPhoto(photo.fullPaths.original, photo.cropRect.x, photo.cropRect.y)
            searchItem.displayUsername(username)
            searchItem.displayMatchPercentage(twoDigitMatchStr)
            searchItem.displayQuickInfo(quickInfo)
        }
    }

    override fun handleSearchItemClick(index: Int) {
        view.showProfile(likedUsers[index])
    }

    override fun getSearchItemCount(): Int = likedUsers.size

    override fun onDestroy() {
        Bus.unregister(this)
    }
}