package com.llamalabb.com.comllamalabbokcupidtakehome.search

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.llamalabb.com.comllamalabbokcupidtakehome.R
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : AppCompatActivity(), SearchContract.SearchView{
    override var presenter: SearchContract.Presenter = SearchPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.search_title)
        supportActionBar?.elevation = 0f
        setContentView(R.layout.activity_search)
        gallery_view_pager.adapter = SearchPagerAdapter(this, supportFragmentManager)
        search_tab_layout.setupWithViewPager(gallery_view_pager)
        presenter.onStart()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}