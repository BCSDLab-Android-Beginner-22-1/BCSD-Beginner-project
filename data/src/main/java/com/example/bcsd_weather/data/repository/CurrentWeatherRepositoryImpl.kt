package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.dao.CurrentWeatherDao
import com.example.bcsd_weather.data.mapper.mapToCurrentWeather
import com.example.bcsd_weather.data.mapper.mapToCurrentWeatherEntity
import com.example.bcsd_weather.domain.model.CurrentWeather
import com.example.bcsd_weather.domain.repository.CurrentWeatherRepository
import com.example.bcsd_weather.domain.usecase.GetUltraSrtFcstUseCase

class CurrentWeatherRepositoryImpl(
    private val currentWeatherDao: CurrentWeatherDao,
    private val getUltraSrtFcstUseCase: GetUltraSrtFcstUseCase
) :
    CurrentWeatherRepository {


    override suspend fun insertCurrentWeather(currentWeather: CurrentWeather, x: Int, y: Int) {
        currentWeatherDao.insertCurrentWeather(currentWeather.mapToCurrentWeatherEntity(x, y))
    }

    override suspend fun deleteCurrentWeather(currentWeather: CurrentWeather, x: Int, y: Int) {
        this.currentWeatherDao.deleteCurrentWeather(currentWeather.mapToCurrentWeatherEntity(x, y))
    }


    override suspend fun getCurrentWeather(x: Int, y: Int): List<CurrentWeather> {
        val data = currentWeatherDao.getCurrentWeather(x, y)

        val updatedTime = if (data.isNotEmpty()) {
            data[data.lastIndex].lastUpdateTime
        } else {
            0
        }

        val currentTime = System.currentTimeMillis()

        if (currentTime - updatedTime > 600000) {
            val apiData = getUltraSrtFcstUseCase(x, y)

            for (i in apiData) {
                currentWeatherDao.insertCurrentWeather(i.mapToCurrentWeatherEntity(x, y))
            }

            return apiData
        }

        val converted = ArrayList<CurrentWeather>()

        for (i in data) {
            converted.add(i.mapToCurrentWeather())
        }
        return converted.toList()
    }

}