package com.example.bcsd_weather.util

import androidx.recyclerview.widget.DiffUtil
import com.example.bcsd_weather.domain.model.ShortTermForecast

object DayForecastDiffUtil : DiffUtil.ItemCallback<ShortTermForecast>() {
    override fun areItemsTheSame(oldItem: ShortTermForecast, newItem: ShortTermForecast): Boolean {
        return oldItem.forecastDate == newItem.forecastDate && oldItem.forecastTime == newItem.forecastTime
    }

    override fun areContentsTheSame(
        oldItem: ShortTermForecast,
        newItem: ShortTermForecast
    ): Boolean {
        return oldItem == newItem
    }
}
