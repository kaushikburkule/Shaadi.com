package com.system.assignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.system.assignment.data.local.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun loadAll(): List<User?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User?>?)

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: List<Int?>?): List<User?>?

}