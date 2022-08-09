package com.example.bcsd_weather.util

import androidx.recyclerview.widget.DiffUtil
import com.example.bcsd_weather.domain.model.TodayForecast

object TodayForecastDiffUtil : DiffUtil.ItemCallback<TodayForecast>() {
    override fun areItemsTheSame(oldItem: TodayForecast, newItem: TodayForecast): Boolean {
        return oldItem.time == newItem.time
    }

    override fun areContentsTheSame(oldItem: TodayForecast, newItem: TodayForecast): Boolean {
        return oldItem == newItem
    }
}
