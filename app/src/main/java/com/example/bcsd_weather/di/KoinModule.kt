package com.example.bcsd_weather.di

import android.app.Application
import com.example.bcsd_weather.db.future.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { FutureWeatherDatabase }
    single { FutureWeatherRepositoryImpl(androidContext() as Application,get())  }

}

val viewModelModule = module {
    viewModel{FutureWeatherViewModel(get())}
}
