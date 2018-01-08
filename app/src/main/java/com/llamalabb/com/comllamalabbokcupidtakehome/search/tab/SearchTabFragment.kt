package com.llamalabb.com.comllamalabbokcupidtakehome.search.tab

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.llamalabb.com.comllamalabbokcupidtakehome.R
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser
import kotlinx.android.synthetic.main.fragment_search_tab.view.*

/**
 * Created by andyg on 1/7/2018.
 */
class SearchTabFragment : Fragment(), SearchTabContract.SearchTabView {
    override lateinit var presenter: SearchTabContract.TabPresenter
    private var page: Int = 0
    private var title: String = ""

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        page = arguments.getInt("pageNum", 0)
        title = arguments.getString("title")
        presenter = SearchTabPresenter(this, page)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_search_tab, container, false)
        recyclerView = view.search_recycler_view
        presenter.onStart()
        return view
    }

    override fun showSearchList(matchedUsers: List<MatchedUser>){
        val span = resources.getInteger(R.integer.gallery_columns)
        val itemDecoration = EqualSpaceItemDecorator(context, R.dimen.item_spacing)
        recyclerView.layoutManager = GridLayoutManager(context, span)
        recyclerView.addItemDecoration(itemDecoration)
        recyclerView.adapter = SearchRecyclerAdapter(context, presenter)
    }

    override fun refreshList(){
        recyclerView.adapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance(pageNum: Int, title: String) : SearchTabFragment {
            val galFrag = SearchTabFragment()
            val args = Bundle()
            args.putInt("pageNum", pageNum)
            args.putString("title", title)
            galFrag.arguments = args
            return galFrag
        }
    }
}