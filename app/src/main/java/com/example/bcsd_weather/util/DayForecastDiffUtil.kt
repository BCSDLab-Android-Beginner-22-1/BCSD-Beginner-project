package com.example.bcsd_weather.util

import androidx.recyclerview.widget.DiffUtil
import com.example.bcsd_weather.domain.model.DayForecast

object DayForecastDiffUtil : DiffUtil.ItemCallback<DayForecast>() {
    override fun areItemsTheSame(oldItem: DayForecast, newItem: DayForecast): Boolean {
        return oldItem.forecastDate == newItem.forecastDate && oldItem.forecastTime == newItem.forecastTime
    }

    override fun areContentsTheSame(oldItem: DayForecast, newItem: DayForecast): Boolean {
        return oldItem == newItem
    }
}
