package com.llamalabb.com.comllamalabbokcupidtakehome.search

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.llamalabb.com.comllamalabbokcupidtakehome.R
import com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.blend.BlendTabFragment
import com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.liked.LikedTabFragment

/**
 * Created by andyg on 1/7/2018.
 */
class SearchPagerAdapter(private val context: Context, fragmentManager: FragmentManager)
    : FragmentPagerAdapter(fragmentManager) {

    companion object TabPosition{
        private val NUM_ITEMS = 2
        val SPECIAL_BLEND = 0
        val MATCH_PERCENT = 1
    }

    override fun getItem(position: Int): Fragment? {
        return when(position){
            TabPosition.SPECIAL_BLEND -> BlendTabFragment.newInstance(position,
                    context.getString(R.string.search_tab_special_blend))
            TabPosition.MATCH_PERCENT -> LikedTabFragment.newInstance(position,
                    context.getString(R.string.search_tab_match_percentage))
            else -> null
        }
    }

    override fun getCount(): Int {
        return NUM_ITEMS
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            TabPosition.SPECIAL_BLEND -> context.getString(R.string.search_tab_special_blend)
            TabPosition.MATCH_PERCENT -> context.getString(R.string.search_tab_match_percentage)
            else -> null
        }
    }
}