package com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.blend

import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service.MatchedUsersRepository
import com.llamalabb.com.comllamalabbokcupidtakehome.search.BusEvent

/**
 * Created by andyg on 1/7/2018.
 */
class BlendTabPresenter(val view: BlendTabContract.SearchTabView)
    : BlendTabContract.TabPresenter {


    override fun onStart() {
        view.showSearchList()
        Bus.observe<BusEvent.UpdateBlendTab>()
                .subscribe{view.refreshList()}
                .registerInBus(this)
    }

    fun Int.formatMatchPercent() = "%.0f".format(this.toDouble()*.01)

    override fun onBindMatchItemAtPosition(position: Int, searchItem: BlendTabContract.SearchItem) {
        with(MatchedUsersRepository.usersCache[position]) {
            val isLiked = MatchedUsersRepository.likedUsersCache.contains(userId)
            val quickInfo = "$age • ${location.cityName}, ${location.stateCode}"
            val twoDigitMatchStr = match.formatMatchPercent()
            searchItem.displayPhoto(photo.fullPaths.original, photo.cropRect.x, photo.cropRect.y)
            searchItem.displayUsername(username)
            searchItem.displayMatchPercentage(twoDigitMatchStr)
            searchItem.displayQuickInfo(quickInfo)
            searchItem.displayLiked(isLiked)
        }
    }

    override fun handleSearchItemClick(index: Int) {
        MatchedUsersRepository.usersCache[index].liked = true
        MatchedUsersRepository.saveLikedUser(MatchedUsersRepository.usersCache[index])
        Bus.send(BusEvent.UpdateLikedTab)
    }

    override fun getSearchItemCount(): Int = MatchedUsersRepository.usersCache.size

    override fun onDestroy() {
        Bus.unregister(this)
    }
}