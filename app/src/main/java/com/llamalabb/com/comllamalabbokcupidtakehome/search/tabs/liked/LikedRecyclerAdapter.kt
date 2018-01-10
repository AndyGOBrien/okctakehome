package com.llamalabb.com.comllamalabbokcupidtakehome.search.tabs.liked

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.llamalabb.com.comllamalabbokcupidtakehome.R
import com.llamalabb.com.comllamalabbokcupidtakehome.loadSquareImage

/**
 * Created by andyg on 1/7/2018.
 */
class LikedRecyclerAdapter(private val presenter: LikedTabContract.TabAdapterPresenter)
    : RecyclerView.Adapter<LikedRecyclerAdapter.SearchViewHolder>() {

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        presenter.onBindMatchItemAtPosition(position, holder)
        holder.cardView.setOnClickListener {
            presenter.handleSearchItemClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        return SearchViewHolder(parent.context, view)
    }

    override fun getItemCount(): Int = presenter.getSearchItemCount()

    class SearchViewHolder(private val context: Context, view: View)
        : RecyclerView.ViewHolder(view), LikedTabContract.SearchItem {

        val image: ImageView = view.findViewById(R.id.match_user_image)
        val username: TextView = view.findViewById(R.id.match_username_text)
        val quickInfo: TextView = view.findViewById(R.id.match_location_text)
        val matchPercentage: TextView = view.findViewById(R.id.match_percentage_text)
        val cardView: CardView = view.findViewById(R.id.search_item_card_view)

        override fun displayQuickInfo(info: String) {
            quickInfo.text = info
        }

        override fun displayUsername(username: String) {
            this.username.text = username
        }

        override fun displayPhoto(url: String, x: Int, y: Int) {
            image.loadSquareImage(url, x, y)
        }

        override fun displayMatchPercentage(match: String) {
            matchPercentage.text = String.format(context.getString(R.string.match_percent), match)
        }

    }
}