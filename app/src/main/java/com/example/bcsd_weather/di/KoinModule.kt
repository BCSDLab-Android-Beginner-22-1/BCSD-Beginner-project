package com.example.bcsd_weather.di

import com.example.bcsd_weather.data.repository.GPSRepositoryImpl
import com.example.bcsd_weather.domain.repository.GPSRepository
import com.example.bcsd_weather.domain.usecase.GetGPSLocation
import com.example.bcsd_weather.domain.usecase.InitGPSLocation
import org.koin.dsl.module

val appModule = module {
    single<GPSRepository> { GPSRepositoryImpl(get()) }

    single { GetGPSLocation(get()) }
    single { InitGPSLocation(get()) }
}

val viewModelModule = module {

}
