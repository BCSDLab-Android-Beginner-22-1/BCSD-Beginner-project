package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.dao.FutureWeatherDao
import com.example.bcsd_weather.data.mapper.mapToFutureWeather
import com.example.bcsd_weather.data.mapper.mapToFutureWeatherEntity
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository
import com.example.bcsd_weather.domain.usecase.GetShortTermFcstUseCase
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FutureWeatherRepositoryImpl(
    private val futureWeatherDao: FutureWeatherDao,
    private val getShortTermFcstUseCase: GetShortTermFcstUseCase,
) :
    FutureWeatherRepository {

    override suspend fun insertFutureWeather(futureWeather: FutureWeather, x: Int, y: Int) {
        futureWeatherDao.insertFutureWeather(futureWeather.mapToFutureWeatherEntity(x, y))
    }
    
    override suspend fun getDetailedFutureWeather(date: String, x: Int, y: Int): List<FutureWeather> {
        val nowDate = Date()

        val nowTimeFormat = SimpleDateFormat("HH")
        val nowTime = nowTimeFormat.format(nowDate)
        val nextHour = Integer.parseInt(nowTime) + 1

        val todayDateFormat = SimpleDateFormat("yyyyMMdd")
        val todayDate = todayDateFormat.format(nowDate)

        val startTime = if (date == todayDate) {
            String.format("%02d00", nextHour)
        } else {
            "0000"
        }

        val data = futureWeatherDao.getDetailedFutureWeather(date, x, y, startTime)

        val updatedTime = if (data.isNotEmpty()) {
            data[data.lastIndex].lastUpdateTime
        } else {
            0
        }

        val currentTime = System.currentTimeMillis()

        if (currentTime - updatedTime > 600000) {
            val apiData = getShortTermFcstUseCase(x, y)

            for (i in apiData) {
                futureWeatherDao.insertFutureWeather(i.mapToFutureWeatherEntity(x, y))
            }

            return getDetailedFutureWeather(date, x, y)
        }

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