package com.example.bcsd_weather.util

import androidx.recyclerview.widget.DiffUtil
import com.example.bcsd_weather.domain.model.FutureWeather

object DayForecastDiffUtil : DiffUtil.ItemCallback<FutureWeather>() {
    override fun areItemsTheSame(oldItem: FutureWeather, newItem: FutureWeather): Boolean {
        return oldItem.forecastDate == newItem.forecastDate && oldItem.forecastTime == newItem.forecastTime
    }

    override fun areContentsTheSame(
        oldItem: FutureWeather,
        newItem: FutureWeather
    ): Boolean {
        return oldItem == newItem
    }
}
