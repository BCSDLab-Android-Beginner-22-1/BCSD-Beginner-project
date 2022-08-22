package com.example.bcsd_weather.util

import androidx.recyclerview.widget.DiffUtil
import com.example.bcsd_weather.domain.model.LocalData

object LocationItemDiffUtil : DiffUtil.ItemCallback<LocalData>() {
    override fun areItemsTheSame(oldItem: LocalData, newItem: LocalData): Boolean {
        return oldItem.localName == newItem.localName
    }

    override fun areContentsTheSame(oldItem: LocalData, newItem: LocalData): Boolean {
        return oldItem == newItem
    }
}
