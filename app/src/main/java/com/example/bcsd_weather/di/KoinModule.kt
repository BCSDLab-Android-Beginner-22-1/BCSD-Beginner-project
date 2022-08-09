package com.example.bcsd_weather.di

import com.example.bcsd_weather.viewmodel.DayForecastViewModel
import com.example.bcsd_weather.viewmodel.ForecastViewModel
import com.example.bcsd_weather.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

}

val viewModelModule = module {
    viewModel {
        MainViewModel()
    }
    viewModel {
        ForecastViewModel()
    }
    viewModel {
        DayForecastViewModel()
    }
}
