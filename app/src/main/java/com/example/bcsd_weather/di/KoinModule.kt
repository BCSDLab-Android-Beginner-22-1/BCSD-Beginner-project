package com.example.bcsd_weather.di

import com.example.bcsd_weather.data.datasource.ShortTermForecastDataSource
import com.example.bcsd_weather.data.datasource.UltraShortTermFcstDataSource
import com.example.bcsd_weather.data.datasource.UltraShortTermLiveDataSource
import com.example.bcsd_weather.data.datasource.remote.GPSRemoteDataSource
import com.example.bcsd_weather.data.mapper.ConvertGPS
import com.example.bcsd_weather.data.repository.GPSRepositoryImpl
import com.example.bcsd_weather.data.repository.ShortTermFcstRepositoryImpl
import com.example.bcsd_weather.data.repository.UltraSrtFcstRepositoryImpl
import com.example.bcsd_weather.data.repository.UltraSrtLiveRepositoryImpl
import com.example.bcsd_weather.domain.repository.GPSRepository
import com.example.bcsd_weather.domain.repository.ShortTermFcstRepository
import com.example.bcsd_weather.domain.repository.UltraSrtFcstRepository
import com.example.bcsd_weather.domain.repository.UltraSrtLiveRepository
import com.example.bcsd_weather.domain.usecase.*
import com.example.bcsd_weather.viewmodel.DayForecastViewModel
import com.example.bcsd_weather.viewmodel.ForecastViewModel
import com.example.bcsd_weather.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ShortTermFcstRepository> { ShortTermFcstRepositoryImpl(get()) }
    single<UltraSrtFcstRepository> { UltraSrtFcstRepositoryImpl(get()) }
    single<UltraSrtLiveRepository> { UltraSrtLiveRepositoryImpl(get()) }
    single<GPSRepository> { GPSRepositoryImpl(get(), get()) }

    single { ShortTermForecastDataSource() }
    single { UltraShortTermFcstDataSource() }
    single { UltraShortTermLiveDataSource() }
    single { GPSRemoteDataSource(androidContext()) }

    single { GetShortTermFcstUseCase(get()) }
    single { GetShortTermTempFcstUseCase(get()) }
    single { GetUltraSrtFcstUseCase(get()) }
    single { GetUltraSrtLiveUseCase(get()) }
    single { GetGPSLocationUseCase(get()) }
    single { InitGPSLocationUseCase(get()) }

    single { ConvertGPS() }
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
