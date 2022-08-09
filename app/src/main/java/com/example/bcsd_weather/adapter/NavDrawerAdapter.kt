package com.example.bcsd_weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bcsd_weather.databinding.ItemNavItemBinding
import com.example.bcsd_weather.domain.model.LocationItem
import com.example.bcsd_weather.util.LocationItemDiffUtil

class NavDrawerAdapter :
    ListAdapter<LocationItem, NavDrawerAdapter.ViewHolder>(LocationItemDiffUtil) {

    lateinit var onClickListener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNavItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position], onClickListener)
    }

    class ViewHolder(private val binding: ItemNavItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(locationItem: LocationItem, onClickListener: OnClickListener) {
            binding.locationItem = locationItem
            binding.navItem.setOnClickListener {
                onClickListener.onClick(locationItem)
            }
        }
    }

    interface OnClickListener {
        fun onClick(position: LocationItem)
    }

    inline fun setOnClickListener(crossinline item: (LocationItem) -> Unit) {
        this.onClickListener = object : OnClickListener {
            override fun onClick(position: LocationItem) {
                item(position)
            }
        }
    }

}
