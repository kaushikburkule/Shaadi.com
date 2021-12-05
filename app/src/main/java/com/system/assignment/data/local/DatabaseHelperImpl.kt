package com.system.assignment.data.local

import com.system.assignment.data.local.entity.User
import javax.inject.Inject

class DatabaseHelperImpl @Inject constructor(private val appDatabase: AppDatabase) :
    DatabaseHelper {

    override fun getAllUsers(): List<User?> {
        return appDatabase.userDao().loadAll()
    }

    override fun insertUser(user: User) {
        appDatabase.userDao().insert(user)
    }

}