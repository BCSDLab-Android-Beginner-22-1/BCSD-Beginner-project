package com.example.bcsd_weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bcsd_weather.databinding.ItemDayForecastBinding
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.util.DayForecastDiffUtil

class DayForecastAdapter :
    ListAdapter<FutureWeather, DayForecastAdapter.ViewHolder>(DayForecastDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemDayForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ViewHolder(private val binding: ItemDayForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(futureWeather: FutureWeather) {
            binding.shortTermForecast = futureWeather
        }
    }
}
