package com.example.bcsd_weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bcsd_weather.databinding.ActivityMainBinding
import com.example.bcsd_weather.db.local.LocalViewModel
import com.example.bcsd_weather.domain.model.LocalData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val localViewModel: LocalViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val input = LocalData(111406250000,"seoul", "jongrogu", "dasandong", 60, 126)
        localViewModel.insertLocalData(input)
        CoroutineScope(Dispatchers.IO).launch {
            val data = localViewModel.getAllLocalData()
            binding.textview.text = data.toString()
        }


    }
}