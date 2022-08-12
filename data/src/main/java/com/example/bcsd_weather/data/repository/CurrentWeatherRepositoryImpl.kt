package com.example.bcsd_weather.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.WeatherModel
import com.example.bcsd_weather.data.db.CurrentWeatherDao
import com.example.bcsd_weather.data.db.CurrentWeatherDatabase
import com.example.bcsd_weather.domain.repository.CurrentWeatherRepository


class CurrentWeatherRepositoryImpl(
    application: Application,
    var currentDb: CurrentWeatherDatabase, val currentWeatherDao: CurrentWeatherDao,
) : CurrentWeatherRepository {

    private val weatherList: LiveData<List<WeatherModel>>

    init {
        currentDb = CurrentWeatherDatabase.getInstance(application)!!
        weatherList = currentDb.currentWeatherDao().getAllWeather()
    }

    override suspend fun insert(weather: WeatherModel) {
        this.currentWeatherDao.insert(weather)
    }

    override suspend fun delete(weather: WeatherModel) {
        this.currentWeatherDao.delete(weather)
    }

    override fun getIdWeather(): LiveData<WeatherModel> {
        return this.currentWeatherDao.getIdWeather()
    }

    override fun getAllWeather(): LiveData<List<WeatherModel>> {
        return this.currentWeatherDao.getAllWeather()
    }

}