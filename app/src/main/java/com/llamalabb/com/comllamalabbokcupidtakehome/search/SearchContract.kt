package com.llamalabb.com.comllamalabbokcupidtakehome.search

import com.llamalabb.com.comllamalabbokcupidtakehome.base.BasePresenter
import com.llamalabb.com.comllamalabbokcupidtakehome.base.BaseView

/**
 * Created by andyg on 1/7/2018.
 */
interface SearchContract {
    interface SearchView : BaseView<Presenter> {
        fun showNotConnected()
    }

    interface Presenter : BasePresenter {
        fun getUserDataFromApi(isConnected: Boolean)
    }
}