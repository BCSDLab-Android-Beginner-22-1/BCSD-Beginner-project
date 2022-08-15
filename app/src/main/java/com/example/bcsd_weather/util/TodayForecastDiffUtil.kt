package com.example.bcsd_weather.util

import androidx.recyclerview.widget.DiffUtil
import com.example.bcsd_weather.domain.model.UltraShortTermForecast

object TodayForecastDiffUtil : DiffUtil.ItemCallback<UltraShortTermForecast>() {
    override fun areItemsTheSame(
        oldItem: UltraShortTermForecast,
        newItem: UltraShortTermForecast
    ): Boolean {
        return oldItem.forecastTime == newItem.forecastTime
    }

    override fun areContentsTheSame(
        oldItem: UltraShortTermForecast,
        newItem: UltraShortTermForecast
    ): Boolean {
        return oldItem == newItem
    }
}
