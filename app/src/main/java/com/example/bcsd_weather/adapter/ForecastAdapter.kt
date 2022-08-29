package com.example.bcsd_weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bcsd_weather.databinding.ItemForecastBinding
import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.util.ForecastDiffUtil

class ForecastAdapter : ListAdapter<TempData, ForecastAdapter.ViewHolder>(ForecastDiffUtil) {

    lateinit var onClickListener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position], onClickListener)
    }

    class ViewHolder(private val binding: ItemForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tempData: TempData, onClickListener: OnClickListener) {
            binding.tempData = tempData
            binding.forecastLayout.setOnClickListener {
                onClickListener.onClick(tempData.date)
            }
        }
    }

    interface OnClickListener {
        fun onClick(date: String)
    }

    inline fun setOnClickListener(crossinline item: (String) -> Unit) {
        this.onClickListener = object : OnClickListener {
            override fun onClick(date: String) {
                item(date)
            }
        }
    }
}
