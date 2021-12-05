package com.system.assignment.utils

import android.content.Intent
import com.system.assignment.R
import android.content.ActivityNotFoundException
import android.content.Context
import android.net.Uri

object AppUtils {
    fun openPlayStoreForApp(context: Context) {
        val appPackageName = context.packageName
        try {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        context
                            .resources
                            .getString(R.string.app_market_link) + appPackageName
                    )
                )
            )
        } catch (e: ActivityNotFoundException) {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        context
                            .resources
                            .getString(R.string.app_google_play_store_link) + appPackageName
                    )
                )
            )
        }
    }
}