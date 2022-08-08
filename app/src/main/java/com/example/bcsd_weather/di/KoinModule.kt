package com.example.bcsd_weather.di

import com.example.bcsd_weather.data.repository.GPSRepositoryImpl
import com.example.bcsd_weather.data.repository.remote.GPSRemoteDataSource
import com.example.bcsd_weather.data.repository.remote.GPSRemoteDataSourceImpl
import com.example.bcsd_weather.domain.repository.GPSRepository
import com.example.bcsd_weather.domain.usecase.GetGPSLocation
import com.example.bcsd_weather.domain.usecase.InitGPSLocation
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<GPSRepository> { GPSRepositoryImpl(get()) }

    single<GPSRemoteDataSource> { GPSRemoteDataSourceImpl(androidContext()) }

    single { GetGPSLocation(get()) }
    single { InitGPSLocation(get()) }
}

val viewModelModule = module {

}
