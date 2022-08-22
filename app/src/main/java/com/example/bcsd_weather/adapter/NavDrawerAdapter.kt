package com.example.bcsd_weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bcsd_weather.databinding.ItemNavItemBinding
import com.example.bcsd_weather.domain.model.LocalData
import com.example.bcsd_weather.util.LocationItemDiffUtil

class NavDrawerAdapter :
    ListAdapter<LocalData, NavDrawerAdapter.ViewHolder>(LocationItemDiffUtil) {

    lateinit var onClickListener: OnClickListener
    lateinit var onLongClickListener: OnLongClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNavItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position], onClickListener, onLongClickListener)
    }

    class ViewHolder(private val binding: ItemNavItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            localData: LocalData,
            onClickListener: OnClickListener,
            onLongClickListener: OnLongClickListener
        ) {
            binding.localData = localData
            binding.navItem.setOnClickListener {
                onClickListener.onClick(localData)
            }
            binding.navItem.setOnLongClickListener {
                onLongClickListener.onLongClick(localData)
                true
            }
        }
    }

    interface OnClickListener {
        fun onClick(localData: LocalData)
    }

    interface OnLongClickListener {
        fun onLongClick(localData: LocalData)
    }

    inline fun setOnClickListener(crossinline item: (LocalData) -> Unit) {
        this.onClickListener = object : OnClickListener {
            override fun onClick(localData: LocalData) {
                item(localData)
            }
        }
    }

    inline fun setOnLongClickListener(crossinline item: (LocalData) -> Unit) {
        this.onLongClickListener = object : OnLongClickListener {
            override fun onLongClick(localData: LocalData) {
                item(localData)
            }
        }
    }
}
