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
}