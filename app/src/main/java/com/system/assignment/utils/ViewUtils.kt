package com.system.assignment.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.system.assignment.R
import android.graphics.PorterDuff
import kotlin.math.roundToInt

object ViewUtils {
    fun changeIconDrawableToGray(context: Context?, drawable: Drawable?) {
        if (drawable != null) {
            drawable.mutate()
            drawable.setColorFilter(
                ContextCompat.getColor(context!!, R.color.black),
                PorterDuff.Mode.SRC_ATOP
            )
        }
    }

    fun dpToPx(dp: Float): Int {
        val density = Resources.getSystem().displayMetrics.density
        return (dp * density).roundToInt()
    }

    fun pxToDp(px: Float): Float {
        val densityDpi = Resources.getSystem().displayMetrics.densityDpi.toFloat()
        return px / (densityDpi / 160f)
    }
}