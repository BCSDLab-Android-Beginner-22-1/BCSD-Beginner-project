package com.example.bcsd_weather.data.repository


import com.example.bcsd_weather.data.dao.CurrentWeatherDao
import com.example.bcsd_weather.data.mapper.mapToCurrentWeather
import com.example.bcsd_weather.data.mapper.mapToCurrentWeatherEntity
import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.repository.CurrentWeatherRepository


class CurrentWeatherRepositoryImpl(private val currentWeatherDao: CurrentWeatherDao) :
    CurrentWeatherRepository {


    override suspend fun insertCurrentWeather(currentWeather: CurrentWeather, x: Int, y: Int) {
        currentWeatherDao.insertCurrentWeather(currentWeather.mapToCurrentWeatherEntity(x,y))
    }

    override suspend fun deleteCurrentWeather(currentWeather: CurrentWeather, x: Int, y: Int) {
        this.currentWeatherDao.deleteCurrentWeather(currentWeather.mapToCurrentWeatherEntity(x,y))
    }


    override fun getCurrentWeather(x: Int, y: Int): List<CurrentWeather> {
        val data = currentWeatherDao.getCurrentWeather()
        val converted = ArrayList<CurrentWeather>()

        for (i in data){
            converted.add(i.mapToCurrentWeather())
        }
        return converted.toList()
    }

}