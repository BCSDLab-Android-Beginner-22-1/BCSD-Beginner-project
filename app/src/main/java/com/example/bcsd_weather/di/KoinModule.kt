package com.example.bcsd_weather.di

import android.app.Application
import androidx.room.Room
import com.example.bcsd_weather.CurrentWeatherViewModel
import com.example.bcsd_weather.data.dao.CurrentWeatherDao
import com.example.bcsd_weather.data.db.CurrentWeatherDatabase
import com.example.bcsd_weather.data.repository.CurrentWeatherRepositoryImpl
import com.example.bcsd_weather.domain.repository.CurrentWeatherRepository
import com.example.bcsd_weather.domain.usecase.DeleteCurrentWeatherUseCase
import com.example.bcsd_weather.domain.usecase.GetCurrentWeatherUseCase
import com.example.bcsd_weather.domain.usecase.InsertCurrentWeatherUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    fun provideDataBase(application: Application): CurrentWeatherDatabase {

        return Room.databaseBuilder(application,CurrentWeatherDatabase::class.java, "current_weather")
            .fallbackToDestructiveMigration()
            .build()

    }

    fun provideDao(dataBase: CurrentWeatherDatabase): CurrentWeatherDao {
        return dataBase.currentWeatherDao()
    }

    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }

    single<CurrentWeatherRepository> {CurrentWeatherRepositoryImpl(get())  }
    single { DeleteCurrentWeatherUseCase(get()) }
    single { GetCurrentWeatherUseCase(get()) }
    single { InsertCurrentWeatherUseCase(get()) }

}

val viewModelModule = module {
    viewModel { CurrentWeatherViewModel(get(),get(),get()) }
}
