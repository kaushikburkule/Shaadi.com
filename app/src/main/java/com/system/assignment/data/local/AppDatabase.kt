package com.system.assignment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.system.assignment.data.local.dao.UserDao
import com.system.assignment.data.local.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}