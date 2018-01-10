package com.llamalabb.com.comllamalabbokcupidtakehome

import android.annotation.SuppressLint
import android.app.Application
import android.arch.persistence.room.Room
import com.llamalabb.com.comllamalabbokcupidtakehome.models.AppDatabase

@SuppressLint("Registered")
/**
 * Created by andyg on 1/9/2018.
 */
class MyApp : Application() {

    companion object {
        lateinit var database: AppDatabase
    }
    override fun onCreate() {
        super.onCreate()
        createDatabase()
    }

    private fun createDatabase(){
        database = Room.databaseBuilder(applicationContext,
                AppDatabase::class.java, "AppDatabase").build()
    }

}