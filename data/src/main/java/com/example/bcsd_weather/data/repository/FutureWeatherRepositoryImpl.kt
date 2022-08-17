package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.dao.FutureWeatherDao
import com.example.bcsd_weather.data.mapper.mapToFutureWeather
import com.example.bcsd_weather.data.mapper.mapToFutureWeatherEntity
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository


class FutureWeatherRepositoryImpl(private val futureWeatherDao: FutureWeatherDao) :
    FutureWeatherRepository {

    override suspend fun insertFutureWeather(futureWeather: FutureWeather) {
        futureWeatherDao.insertFutureWeather(futureWeather.mapToFutureWeatherEntity())
    }

    override fun getFutureWeather(startDate: String): List<FutureWeather> {
        val data = futureWeatherDao.getFutureWeather(startDate)
        val converted = ArrayList<FutureWeather>()

        for (i in data) {
            converted.add(i.mapToFutureWeather())
        }

        return converted.toList()
    }

    override fun getDetailedFutureWeather(date: String): List<FutureWeather> {
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

    override fun getHighestTemp(date: String): FutureWeather {
        val data = futureWeatherDao.getHighestTemp(date)

        return data.mapToFutureWeather()
    }

    override fun getLowestTemp(date: String): FutureWeather {
        val data = futureWeatherDao.getLowestTemp(date)

        return data.mapToFutureWeather()
    }

}