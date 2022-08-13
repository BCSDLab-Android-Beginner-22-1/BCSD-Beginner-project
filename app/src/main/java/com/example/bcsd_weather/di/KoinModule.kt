package com.example.bcsd_weather.di


import android.app.Application
import androidx.room.Room
import com.example.bcsd_weather.FutureWeatherViewModel
import com.example.bcsd_weather.data.db.FutureWeatherDao
import com.example.bcsd_weather.data.db.FutureWeatherDatabase
import com.example.bcsd_weather.data.repository.FutureWeatherRepositoryImpl
import com.example.bcsd_weather.db.future.converter.StItemTypeConverter
import com.example.bcsd_weather.db.future.converter.shortTermForecastModelTypeConverter
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository
import com.google.gson.Gson
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.Future


val appModule = module {

    fun provideDataBase(application: Application): FutureWeatherDatabase {
        return Room.databaseBuilder(application, FutureWeatherDatabase::class.java, "future_weather")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: FutureWeatherDatabase): FutureWeatherDao {
        return dataBase.futureWeatherDao()
    }

    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }

    single<FutureWeatherRepository> { FutureWeatherRepositoryImpl(get()) }

}

val viewModelModule = module {
    viewModel { FutureWeatherViewModel(get()) }
}
