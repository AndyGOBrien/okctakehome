package com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.blend

import com.llamalabb.com.comllamalabbokcupidtakehome.formatMatchPercent
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service.MatchedUsersRepository
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by andyg on 1/7/2018.
 */
class BlendTabPresenter(val view: BlendTabContract.SearchTabView)
    : BlendTabContract.TabPresenter {

    override fun onStart() {
        MatchedUsersRepository.getUsersFromApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
            MatchedUsersRepository.users = it.data
            processMatchedUsers(MatchedUsersRepository.users)
        }
    }

    private fun processMatchedUsers(matchedUsers: List<MatchedUser>){
            sortSpecialBlend(matchedUsers)
    }

    private fun sortSpecialBlend(matchedUsers: List<MatchedUser>){
        view.showSearchList(matchedUsers)
    }

    override fun onBindMatchItemAtPosition(position: Int, searchItem: BlendTabContract.SearchItem) {
            displaySearchItem(MatchedUsersRepository.users, position, searchItem)
    }

    private fun displaySearchItem(list: List<MatchedUser>, position: Int, searchItem: BlendTabContract.SearchItem){
        with(list[position]) {
            val quickInfo = "$age • ${location?.cityName}, ${location.stateCode}"
            val twoDigitMatchStr = match.formatMatchPercent()
            searchItem.displayPhoto(photo.fullPaths.original, photo.cropRect.x, photo.cropRect.y)
            searchItem.displayUsername(username)
            searchItem.displayMatchPercentage(twoDigitMatchStr)
            searchItem.displayQuickInfo(quickInfo)
            searchItem.displayLiked(list[position].liked)
        }
    }

    override fun handleSearchItemClick(index: Int) {
        MatchedUsersRepository.users[index].liked = true
    }

    private fun getLikedUsers(): List<MatchedUser>{
        val likedUsers = ArrayList<MatchedUser>()
        MatchedUsersRepository.users.forEach { if(it.liked) likedUsers.add(it) }
        return likedUsers
    }

    override fun getSearchItemCount(): Int = MatchedUsersRepository.users.size

}