package com.example.bcsd_weather.di

import android.app.Application
import androidx.room.Room
import com.example.bcsd_weather.data.dao.CurrentWeatherDao
import com.example.bcsd_weather.data.datasource.ShortTermForecastDataSource
import com.example.bcsd_weather.data.datasource.UltraShortTermFcstDataSource
import com.example.bcsd_weather.data.datasource.UltraShortTermLiveDataSource
import com.example.bcsd_weather.data.datasource.remote.GPSRemoteDataSource
import com.example.bcsd_weather.data.db.CurrentWeatherDatabase
import com.example.bcsd_weather.data.mapper.ConvertGPS
import com.example.bcsd_weather.data.repository.*
import com.example.bcsd_weather.domain.repository.*
import com.example.bcsd_weather.domain.usecase.*
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    fun provideCurrentWeatherDataBase(application: Application): CurrentWeatherDatabase {

        return Room.databaseBuilder(
            application,
            CurrentWeatherDatabase::class.java,
            "current_weather"
        )
            .fallbackToDestructiveMigration()
            .build()

    }

    fun provideCurrentWeatherDao(dataBase: CurrentWeatherDatabase): CurrentWeatherDao {
        return dataBase.currentWeatherDao()
    }

    single { provideCurrentWeatherDataBase(androidApplication()) }
    single { provideCurrentWeatherDao(get()) }

    single<CurrentWeatherRepository> { CurrentWeatherRepositoryImpl(get()) }
    single { DeleteCurrentWeatherUseCase(get()) }
    single { GetCurrentWeatherUseCase(get()) }
    single { InsertCurrentWeatherUseCase(get()) }

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


