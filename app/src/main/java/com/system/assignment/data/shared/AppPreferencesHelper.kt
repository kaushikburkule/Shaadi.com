package com.system.assignment.data.shared

import android.content.Context
import android.content.SharedPreferences
import com.system.assignment.di.annotations.Preference
import javax.inject.Inject

class AppPreferencesHelper @Inject constructor(
    context: Context,
    @Preference prefFileName: String?
) : PreferencesHelper {

    companion object {
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private const val PREF_KEY_USER_STORAGE = "PREF_KEY_USER_STORAGE"
    }

    private val mPrefs: SharedPreferences =
        context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    private var accessToken: String?
        get() = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null)
        set(accessToken) = mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply()

    private var userStorage : String?
        get() = mPrefs.getString(PREF_KEY_USER_STORAGE, "null")
        set(value) = mPrefs.edit().putString(PREF_KEY_USER_STORAGE, userStorage).apply()

    override fun saveLocalStorage(value: String): String {
        return userStorage.toString();
    }

}