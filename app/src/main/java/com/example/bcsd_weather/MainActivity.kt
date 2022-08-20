package com.example.bcsd_weather

import android.location.Geocoder
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
import java.util.*

class MainActivity : AppCompatActivity() {
    private val localViewModel: LocalViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


/*
        val geocoder = Geocoder(this, Locale.KOREA)
        val add = geocoder.getFromLocationName("대천해수욕장", 1) // locationName은 추후 사용자가 입력
        val input = LocalData(11140625004, "대천해수욕장", add[0].latitude, add[0].longitude)
        localViewModel.deleteLocalData(input)
        localViewModel.insertLocalData(input)

        CoroutineScope(Dispatchers.IO).launch {
            val data = localViewModel.getAllLocalData()
            binding.textview.text = data.toString()
        }

*/
    }
}