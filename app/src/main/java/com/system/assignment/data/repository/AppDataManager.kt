package com.system.assignment.data.repository

import android.content.Context
import javax.inject.Singleton
import javax.inject.Inject
import com.system.assignment.data.local.DatabaseHelper
import com.system.assignment.data.shared.PreferencesHelper
import com.system.assignment.data.api.ApiHelper
import com.google.gson.Gson
import com.system.assignment.data.local.entity.User
import com.system.assignment.data.model.ApiUser
import com.system.assignment.data.model.Response
import com.system.assignment.data.repository.DataManager

@Singleton
class AppDataManager @Inject constructor() : DataManager {

    companion object {
        private const val TAG = "AppDataManager"
    }

    @Inject
    lateinit var mGson: Gson

    @Inject
    lateinit var mApiHelper: ApiHelper

    @Inject
    lateinit var mPreferencesHelper: PreferencesHelper

    @Inject
    lateinit var mDbHelper: DatabaseHelper

    @Inject
    lateinit var mContext: Context

    override fun insertUser(user: User) {
        mDbHelper.insertUser(user)
    }

    // Local user storage
    override fun getAllUsers(): List<User?> = mDbHelper.getAllUsers()

    // Shared preference
    override fun saveLocalStorage(value: String): String = mPreferencesHelper.saveLocalStorage(value)

    // Remote
    override suspend fun getUsers(): Response = mApiHelper.getUsers()

}