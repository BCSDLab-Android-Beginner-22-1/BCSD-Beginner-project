package com.example.bcsd_weather.util

import androidx.recyclerview.widget.DiffUtil
import com.example.bcsd_weather.domain.model.ShortTermTempForecast

object ForecastDiffUtil : DiffUtil.ItemCallback<ShortTermTempForecast>() {
    override fun areItemsTheSame(oldItem: ShortTermTempForecast, newItem: ShortTermTempForecast): Boolean {
        return oldItem.forecastDate == newItem.forecastDate
    }

    override fun areContentsTheSame(oldItem: ShortTermTempForecast, newItem: ShortTermTempForecast): Boolean {
        return oldItem == newItem
    }
}
