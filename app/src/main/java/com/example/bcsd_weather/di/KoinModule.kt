package com.example.bcsd_weather.di


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.example.bcsd_weather.FutureWeatherViewModel
import com.example.bcsd_weather.data.db.FutureWeatherDatabase
import com.example.bcsd_weather.data.repository.FutureWeatherRepositoryImpl
import com.example.bcsd_weather.db.future.converter.StItemTypeConverter
import com.example.bcsd_weather.db.future.converter.shortTermForecastModelTypeConverter
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    single {
        val gson = Gson()
        Room.databaseBuilder(
            androidContext(),
            FutureWeatherDatabase::class.java,
            "future_weather.db"
        )
            .addTypeConverter(shortTermForecastModelTypeConverter(gson))
            .addTypeConverter(StItemTypeConverter(gson))
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<FutureWeatherDatabase>().futureWeatherDao() }

    single<FutureWeatherRepository> {
        FutureWeatherRepositoryImpl(get())
    }

}

val viewModelModule = module {
    viewModel { FutureWeatherViewModel(get()) }
}
