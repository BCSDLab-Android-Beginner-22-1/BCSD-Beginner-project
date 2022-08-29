package com.example.bcsd_weather.util

import androidx.recyclerview.widget.DiffUtil
import com.example.bcsd_weather.domain.model.TempData

object ForecastDiffUtil : DiffUtil.ItemCallback<TempData>() {
    override fun areItemsTheSame(oldItem: TempData, newItem: TempData): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: TempData, newItem: TempData): Boolean {
        return oldItem == newItem
    }
}
