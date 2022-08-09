package com.example.bcsd_weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bcsd_weather.databinding.ItemTodayForecastBinding
import com.example.bcsd_weather.domain.model.TodayForecast
import com.example.bcsd_weather.util.TodayForecastDiffUtil

class TodayForecastAdapter :
    ListAdapter<TodayForecast, TodayForecastAdapter.ViewHolder>(TodayForecastDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemTodayForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ViewHolder(private val binding: ItemTodayForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todayForecast: TodayForecast) {
            binding.todayForecast = todayForecast
        }
    }
}
