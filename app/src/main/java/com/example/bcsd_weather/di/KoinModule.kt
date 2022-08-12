package com.example.bcsd_weather.di

import com.example.bcsd_weather.data.db.CurrentWeatherDatabase
import com.example.bcsd_weather.data.repository.CurrentWeatherRepositoryImpl
import com.example.bcsd_weather.db.CurrentWeatherViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { CurrentWeatherDatabase }
    single { get<CurrentWeatherDatabase>().currentWeatherDao() }
    single { CurrentWeatherDatabase.getInstance(androidContext()) }
    single {
        CurrentWeatherRepositoryImpl(androidApplication(),
            get(),get())
    }
}

val viewModelModule = module {
    viewModel { CurrentWeatherViewModel(get()) }
}
