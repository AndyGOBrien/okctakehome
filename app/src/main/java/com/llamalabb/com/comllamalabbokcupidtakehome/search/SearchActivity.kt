package com.llamalabb.com.comllamalabbokcupidtakehome.search

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.llamalabb.com.comllamalabbokcupidtakehome.R
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : AppCompatActivity(), SearchContract.SearchView{
    override var presenter: SearchContract.Presenter = SearchPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.search_title)
        supportActionBar?.elevation = 0f
        setContentView(R.layout.activity_search)

        gallery_view_pager.adapter = SearchPagerAdapter(this, supportFragmentManager)
        search_tab_layout.setupWithViewPager(gallery_view_pager)


        presenter.getUserDataFromApi(isConnected())
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private fun isConnected(): Boolean{
        val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork =  cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

    override fun showNotConnected(){
        Toast.makeText(this,"No network connection", Toast.LENGTH_SHORT).show()
    }

}