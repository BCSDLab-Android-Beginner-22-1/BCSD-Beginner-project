package com.example.bcsd_weather.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter

object TextBindingAdapter {
    @BindingAdapter("sky_type_text")
    @JvmStatic
    fun setSkyTypeText(textView: TextView, text: String) {
        val context = textView.context

        val resourceId = context.resources.getIdentifier(
            "forecast_sky_type_${text.lowercase()}",
            "string",
            context.packageName
        )
        textView.text = context.getString(resourceId)
    }

    @BindingAdapter("date_text")
    @JvmStatic
    fun setDateText(textView: TextView, text: String) {
        val year = text.substring(0 until 4)
        val month = text.substring(4 until 6)
        val day = text.substring(6 until 8)

        val formatted = "$year/$month/$day"

        textView.text = formatted
    }

    @BindingAdapter("time_text")
    @JvmStatic
    fun setTimeText(textView: TextView, text: String) {
        val hour = text.substring(0 until 2)
        val minute = text.substring(2 until 4)

        val formatted = "$hour:$minute"

        textView.text = formatted
    }
}