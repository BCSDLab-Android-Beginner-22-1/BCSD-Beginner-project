package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.dao.FutureWeatherDao
import com.example.bcsd_weather.data.mapper.mapToFutureWeather
import com.example.bcsd_weather.data.mapper.mapToFutureWeatherEntity
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository


class FutureWeatherRepositoryImpl(private val futureWeatherDao: FutureWeatherDao) :
    FutureWeatherRepository {

    override suspend fun insertFutureWeather(futureWeather: FutureWeather, x: Int, y: Int) {
        futureWeatherDao.insertFutureWeather(futureWeather.mapToFutureWeatherEntity(x,y))
    }


    override fun getDetailedFutureWeather(date: String, x: Int, y: Int): List<FutureWeather> {
        val data = futureWeatherDao.getDetailedFutureWeather(date)
        val converted = ArrayList<FutureWeather>()

        for (i in data) {
            converted.add(i.mapToFutureWeather())
        }

        return converted.toList()
    }

    override suspend fun deleteWeather(firstDateToKeep: String) {
        futureWeatherDao.deleteWeather(firstDateToKeep)
    }


}