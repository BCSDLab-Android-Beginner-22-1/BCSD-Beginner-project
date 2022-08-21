package com.example.bcsd_weather.di

import android.app.Application
import androidx.room.Room
import com.example.bcsd_weather.FutureWeatherViewModel
import com.example.bcsd_weather.data.dao.FutureWeatherDao
import com.example.bcsd_weather.data.db.FutureWeatherDatabase
import com.example.bcsd_weather.data.repository.FutureWeatherRepositoryImpl
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository
import com.example.bcsd_weather.domain.usecase.DeleteWeatherUseCase
import com.example.bcsd_weather.domain.usecase.GetDetailedFutureWeatherUseCase
import com.example.bcsd_weather.domain.usecase.GetFutureWeatherUseCase
import com.example.bcsd_weather.domain.usecase.InsertFutureWeatherUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
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
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val appModule = module {
    fun provideFutureWeatherDataBase(application: Application): FutureWeatherDatabase {
        return Room.databaseBuilder(application,
            FutureWeatherDatabase::class.java,
            "future_weather")
            .fallbackToDestructiveMigration()
            .build()

    }

    fun provideFutureWeatherDao(dataBase: FutureWeatherDatabase): FutureWeatherDao {
        return dataBase.futureWeatherDao()
    }

    single { provideFutureWeatherDataBase(androidApplication()) }
    single { provideFutureWeatherDao(get()) }

    single<ShortTermFcstRepository> { ShortTermFcstRepositoryImpl(get()) }
    single<UltraSrtFcstRepository> { UltraSrtFcstRepositoryImpl(get()) }
    single<UltraSrtLiveRepository> { UltraSrtLiveRepositoryImpl(get()) }
    single<GPSRepository> { GPSRepositoryImpl(get(), get()) }
    single<FutureWeatherRepository> { FutureWeatherRepositoryImpl(get()) }

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
    single { DeleteWeatherUseCase(get()) }
    single { GetDetailedFutureWeatherUseCase(get()) }
    single { GetFutureWeatherUseCase(get()) }
    single { InsertFutureWeatherUseCase(get()) }
    single { GetHighestTempUseCase(get()) }
    single { GetLowestTempUseCase(get()) }

    single { ConvertGPS() }
}

val viewModelModule = module {
    viewModel { FutureWeatherViewModel(get(), get(), get(), get(),get(),get()) }
}
