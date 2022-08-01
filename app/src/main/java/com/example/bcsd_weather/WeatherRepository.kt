package com.example.bcsd_weather

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.WeatherModel

class WeatherRepository(application: Application) {
    private val weatherDao: WeatherDao
    private val weatherList : LiveData<List<WeatherModel>>

    init {
        val db : WeatherDatabase = WeatherDatabase.getInstance(application)!!
        weatherDao = db.weatherDao()
        weatherList = db.weatherDao().getAllWeather()
    }

    fun insert(weather: WeatherModel){
        weatherDao.insert(weather)
    }

    fun delete(weather: WeatherModel){
        weatherDao.delete(weather)
    }

    fun getIdWeather(): LiveData<WeatherModel> {
        return weatherDao.getIdWeather()
    }

    fun getAllWeather(): LiveData<List<WeatherModel>>{
        return weatherDao.getAllWeather()
    }

}