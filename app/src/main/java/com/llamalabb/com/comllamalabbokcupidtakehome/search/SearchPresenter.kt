package com.llamalabb.com.comllamalabbokcupidtakehome.search

import com.eightbitlab.rxbus.Bus
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service.MatchedUsersRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by andyg on 1/7/2018.
 */
class SearchPresenter(val view: SearchContract.SearchView) : SearchContract.Presenter {
    override fun onDestroy() {
        MatchedUsersRepository
                .getUsersFromApi()
                .unsubscribeOn(Schedulers.io())
    }

    override fun onStart() {}

    override fun getUserDataFromApi(isConnected: Boolean) {
        if (isConnected) {
            MatchedUsersRepository.getUsersFromApi()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        MatchedUsersRepository.usersCache.clear()
                        MatchedUsersRepository.usersCache.addAll(it.data)
                        Bus.send(BusEvent.UpdateBlendTab)
                        Bus.send(BusEvent.UpdateLikedTab)
                    }
        } else {
            view.showNotConnected()
        }
    }
}