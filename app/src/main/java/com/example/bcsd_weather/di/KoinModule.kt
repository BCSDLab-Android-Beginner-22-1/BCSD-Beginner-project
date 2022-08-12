package com.example.bcsd_weather.di

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.bcsd_weather.FutureWeatherViewModel
import com.example.bcsd_weather.data.db.FutureWeatherDatabase
import com.example.bcsd_weather.data.repository.FutureWeatherRepositoryImpl
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository
import com.google.gson.Gson
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@RequiresApi(Build.VERSION_CODES.O)
val appModule = module {

    single { FutureWeatherDatabase }
    single { get<FutureWeatherDatabase>().futureWeatherDao() }
    single { FutureWeatherDatabase.getInstance(androidContext(), Gson()) }
    single<FutureWeatherRepository> {
        FutureWeatherRepositoryImpl(androidApplication(),
            get(),get())
    }

}

val viewModelModule = module {
    viewModel { FutureWeatherViewModel(get()) }
}
