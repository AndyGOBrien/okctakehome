package com.llamalabb.com.comllamalabbokcupidtakehome.models

import android.arch.persistence.room.*
import com.llamalabb.com.comllamalabbokcupidtakehome.models.match.user.MatchedUser
import io.reactivex.Single

/**
 * Created by andyg on 1/8/2018.
 */

@Database(entities = arrayOf(MatchedUser::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

@Dao
interface UserDao {
    @Query("SELECT * FROM LikedUsers")
    fun getUsers(): Single<List<MatchedUser>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: MatchedUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<MatchedUser>)
}