package com.saathi.common

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat

object Utils {

      fun shareCourse(link: String?, context: Context) {
        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_TEXT, link)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        ContextCompat.startActivity(context, shareIntent, null)
    }

}