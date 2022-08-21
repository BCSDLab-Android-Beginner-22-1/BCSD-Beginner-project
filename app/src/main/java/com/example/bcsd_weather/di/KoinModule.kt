package com.example.bcsd_weather.di

import android.app.Application
import androidx.room.Room
import com.example.bcsd_weather.data.dao.CurrentWeatherDao
import com.example.bcsd_weather.data.dao.FutureWeatherDao
import com.example.bcsd_weather.data.dao.TempDao
import com.example.bcsd_weather.data.datasource.ShortTermForecastDataSource
import com.example.bcsd_weather.data.datasource.UltraShortTermFcstDataSource
import com.example.bcsd_weather.data.datasource.UltraShortTermLiveDataSource
import com.example.bcsd_weather.data.datasource.remote.GPSRemoteDataSource
import com.example.bcsd_weather.data.db.CurrentWeatherDatabase
import com.example.bcsd_weather.data.db.FutureWeatherDatabase
import com.example.bcsd_weather.data.db.TempDatabase
import com.example.bcsd_weather.data.mapper.ConvertGPS
import com.example.bcsd_weather.data.repository.*
import com.example.bcsd_weather.domain.repository.*
import com.example.bcsd_weather.domain.usecase.*
import com.example.bcsd_weather.viewmodel.DayForecastViewModel
import com.example.bcsd_weather.viewmodel.ForecastViewModel
import com.example.bcsd_weather.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    fun TempProvideDataBase(application: Application): TempDatabase {

        return Room.databaseBuilder(application, TempDatabase::class.java, "TempDataTable")
            .fallbackToDestructiveMigration()
            .build()

    }

    fun TempProvideDao(dataBase: TempDatabase): TempDao {
        return dataBase.tempDao()
    }

    fun provideFutureWeatherDataBase(application: Application): FutureWeatherDatabase {
        return Room.databaseBuilder(
            application,
            FutureWeatherDatabase::class.java,
            "future_weather"
        )
            .fallbackToDestructiveMigration()
            .build()

    }

    fun provideFutureWeatherDao(dataBase: FutureWeatherDatabase): FutureWeatherDao {
        return dataBase.futureWeatherDao()
    }

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

    single { TempProvideDataBase(androidApplication()) }
    single { TempProvideDao(get()) }

    single { provideFutureWeatherDataBase(androidApplication()) }
    single { provideFutureWeatherDao(get()) }

    single { provideCurrentWeatherDataBase(androidApplication()) }
    single { provideCurrentWeatherDao(get()) }

    single<ShortTermFcstRepository> { ShortTermFcstRepositoryImpl(get()) }
    single<UltraSrtFcstRepository> { UltraSrtFcstRepositoryImpl(get()) }
    single<UltraSrtLiveRepository> { UltraSrtLiveRepositoryImpl(get()) }
    single<GPSRepository> { GPSRepositoryImpl(get(), get()) }
    single<TempRepository> { TempRepositoryImpl(get()) }
    single<FutureWeatherRepository> { FutureWeatherRepositoryImpl(get()) }
    single<CurrentWeatherRepository> { CurrentWeatherRepositoryImpl(get()) }

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
    single { GetAllTempUseCase(get()) }
    single { GetTempUseCase(get()) }
    single { InsertTempUseCase(get()) }
    single { DeleteTempUseCase(get()) }
    single { DeleteWeatherUseCase(get()) }
    single { GetDetailedFutureWeatherUseCase(get()) }
    single { InsertFutureWeatherUseCase(get()) }
    single { DeleteCurrentWeatherUseCase(get()) }
    single { GetCurrentWeatherUseCase(get()) }
    single { InsertCurrentWeatherUseCase(get()) }

    single { ConvertGPS() }
}

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }
    viewModel {
        ForecastViewModel()
    }
    viewModel {
        DayForecastViewModel()
    }
}