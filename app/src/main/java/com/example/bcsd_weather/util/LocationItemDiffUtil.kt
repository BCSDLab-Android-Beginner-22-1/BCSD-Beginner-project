package com.example.bcsd_weather.util

import androidx.recyclerview.widget.DiffUtil
import com.example.bcsd_weather.domain.model.LocationItem

object LocationItemDiffUtil : DiffUtil.ItemCallback<LocationItem>() {
    override fun areItemsTheSame(oldItem: LocationItem, newItem: LocationItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: LocationItem, newItem: LocationItem): Boolean {
        return oldItem == newItem
    }
}
