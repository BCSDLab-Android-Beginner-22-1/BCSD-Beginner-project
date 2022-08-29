package com.example.bcsd_weather.util

import androidx.recyclerview.widget.DiffUtil
import com.example.bcsd_weather.domain.model.CurrentWeather

object TodayForecastDiffUtil : DiffUtil.ItemCallback<CurrentWeather>() {
    override fun areItemsTheSame(
        oldItem: CurrentWeather,
        newItem: CurrentWeather
    ): Boolean {
        return oldItem.forecastTime == newItem.forecastTime
    }

    override fun areContentsTheSame(
        oldItem: CurrentWeather,
        newItem: CurrentWeather
    ): Boolean {
        return oldItem == newItem
    }
}
