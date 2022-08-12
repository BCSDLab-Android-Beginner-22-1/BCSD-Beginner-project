package com.example.bcsd_weather.di

import com.example.bcsd_weather.data.repository.GPSRepositoryImpl
import com.example.bcsd_weather.data.datasource.remote.GPSRemoteDataSource
import com.example.bcsd_weather.data.mapper.ConvertGPS
import com.example.bcsd_weather.domain.repository.GPSRepository
import com.example.bcsd_weather.domain.usecase.GetGPSLocationUseCase
import com.example.bcsd_weather.domain.usecase.InitGPSLocationUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<GPSRepository> { GPSRepositoryImpl(get(), get()) }

    single { GPSRemoteDataSource(androidContext()) }

    single { GetGPSLocationUseCase(get()) }
    single { InitGPSLocationUseCase(get()) }

    single { ConvertGPS() }
}

val viewModelModule = module {

}
