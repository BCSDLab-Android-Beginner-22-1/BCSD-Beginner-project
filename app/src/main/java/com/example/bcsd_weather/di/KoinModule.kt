package com.example.bcsd_weather.di

import android.app.Application
import androidx.room.Room
import com.example.bcsd_weather.data.dao.TempDao
import com.example.bcsd_weather.data.datasource.ShortTermForecastDataSource
import com.example.bcsd_weather.data.datasource.UltraShortTermFcstDataSource
import com.example.bcsd_weather.data.datasource.UltraShortTermLiveDataSource
import com.example.bcsd_weather.data.datasource.remote.GPSRemoteDataSource
import com.example.bcsd_weather.data.db.TempDatabase
import com.example.bcsd_weather.data.mapper.ConvertGPS
import com.example.bcsd_weather.data.repository.*
import com.example.bcsd_weather.domain.repository.*
import com.example.bcsd_weather.domain.usecase.*
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
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

    single { TempProvideDataBase(androidApplication()) }
    single { TempProvideDao(get()) }

    single<ShortTermFcstRepository> { ShortTermFcstRepositoryImpl(get()) }
    single<UltraSrtFcstRepository> { UltraSrtFcstRepositoryImpl(get()) }
    single<UltraSrtLiveRepository> { UltraSrtLiveRepositoryImpl(get()) }
    single<GPSRepository> { GPSRepositoryImpl(get(), get()) }
    single<TempRepository> { TempRepositoryImpl(get()) }

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

    single { ConvertGPS() }
}

val viewModelModule = module {

}