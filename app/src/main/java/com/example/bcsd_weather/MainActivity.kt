package com.example.bcsd_weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.bcsd_weather.db.local.LocalEntity
import com.example.bcsd_weather.db.local.LocalViewModel
import com.example.bcsd_weather.db.local.LocalViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:LocalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        viewModel = ViewModelProvider(this, LocalViewModelFactory(application)).get(
//            LocalViewModel::class.java)
        val input = LocalEntity(1114062500,"seoul", "jongrogu", "dasandong", 60, 126)
//        viewModel.deleteAllLocalData()
//        viewModel.insert(input)

//        var output = viewModel.getAllLocalData()
//        Log.d("db_test","dbtest : $output")


    }
}