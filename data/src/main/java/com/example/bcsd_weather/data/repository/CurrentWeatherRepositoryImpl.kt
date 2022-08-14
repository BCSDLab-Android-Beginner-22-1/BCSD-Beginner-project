package com.example.bcsd_weather.data.repository


import com.example.bcsd_weather.data.dao.CurrentWeatherDao
import com.example.bcsd_weather.data.mapper.mapToCurrentWeather
import com.example.bcsd_weather.data.mapper.mapToCurrentWeatherEntity
import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.repository.CurrentWeatherRepository


class CurrentWeatherRepositoryImpl(private val currentWeatherDao: CurrentWeatherDao) :
    CurrentWeatherRepository {


    override suspend fun insert(currentWeather: CurrentWeather) {
        currentWeatherDao.insert(currentWeather.mapToCurrentWeatherEntity())
    }

    override suspend fun delete(currentWeather: CurrentWeather) {
        this.currentWeatherDao.delete(currentWeather.mapToCurrentWeatherEntity())
    }


    override fun getCurrentWeather(): List<CurrentWeather> {
        val data = currentWeatherDao.getCurrentWeather()
        val converted = ArrayList<CurrentWeather>()

        for (i in data){
            converted.add(i.mapToCurrentWeather())
        }
        return converted.toList()
    }

}