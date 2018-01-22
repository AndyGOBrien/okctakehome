package com.llamalabb.com.comllamalabbokcupidtakehome.profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.eightbitlab.rxbus.Bus
import com.llamalabb.com.comllamalabbokcupidtakehome.R
import com.llamalabb.com.comllamalabbokcupidtakehome.loadImage
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service.MatchedUsersRepository
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service.MatchedUsersRepository.deleteLikedUser
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service.MatchedUsersRepository.isUserLiked
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.service.MatchedUsersRepository.saveLikedUser
import com.llamalabb.com.comllamalabbokcupidtakehome.search.BusEvent
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(), ProfileContract.ProfileView {
    override var presenter: ProfileContract.Presenter = ProfilePresenter(this)


    lateinit var user: MatchedUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        user = intent.getSerializableExtra("user") as MatchedUser
        setOnClickListers()
        setUserInformation()
    }

    fun setOnClickListers(){
        like_button.setOnClickListener { likeButtonCliked() }
    }

    fun likeButtonCliked(){
        MatchedUsersRepository.let{
            if(isUserLiked(user.userId)){
                deleteLikedUser(user)
                like_button.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))
            } else {
                saveLikedUser(user)
                like_button.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.search_card_liked_background))
            }
        }
        Bus.send(BusEvent.UpdateLikedTab)
        Bus.send(BusEvent.UpdateBlendTab)
    }

    private fun Int.formatMatchPercent() = "%.0f".format(this.toDouble()*.01)

    fun setUserInformation(){
        val quickInfo = "${user.age} • ${user.location.cityName}, ${user.location.stateCode}"
        val matchStr = user.match.formatMatchPercent()
        profile_image_view.loadImage(user.photo.fullPaths.original)
        profile_basic_info_text.text = quickInfo
        profile_username_text.text = user.username
        profile_match_text.text = String.format(this.getString(R.string.match_percent), matchStr)
    }

}
