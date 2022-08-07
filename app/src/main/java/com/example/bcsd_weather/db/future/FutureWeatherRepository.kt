package com.example.bcsd_weather.db.future

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.FutureWeatherEntity
import com.example.bcsd_weather.data.WeatherModel
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class FutureWeatherRepository(application: Application) {
    private val futureWeatherDao: FutureWeatherDao
    private val futureWeatherList : LiveData<List<FutureWeatherEntity>>

    init {
        val futureDb: FutureWeatherDatabase = FutureWeatherDatabase.getInstance(application)!!
        futureWeatherDao = futureDb.futureWeatherDao()
        futureWeatherList = futureDb.futureWeatherDao().getFutureWeather(LocalDate.now())
    }

    fun insertFutureWeather(futureWeatherEntity: List<FutureWeatherEntity>){
        futureWeatherDao.insertFutureWeather(futureWeatherEntity)
    }

    fun getFutureWeather(startDate: LocalDate): LiveData<List<FutureWeatherEntity>>{
        return futureWeatherDao.getFutureWeather(startDate)
    }

    fun getDetailedFutureWeather(date: LocalDate): LiveData<FutureWeatherEntity>{
        return futureWeatherDao.getDetailedFutureWeather(date)
    }
    fun deleteWeather(firstDateToKeep: LocalDate){
        futureWeatherDao.deleteWeather(firstDateToKeep)
    }

}