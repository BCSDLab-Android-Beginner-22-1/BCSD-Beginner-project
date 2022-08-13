package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.dao.FutureWeatherDao
import com.example.bcsd_weather.data.mapper.mapToFutureWeather
import com.example.bcsd_weather.data.mapper.mapToFutureWeatherEntity
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository


class FutureWeatherRepositoryImpl(private val futureWeatherDao: FutureWeatherDao) :
    FutureWeatherRepository {

//    private val futureWeatherList: LiveData<List<FutureWeatherEntity>>
//    private val current = LocalDate.now()


    // 날짜 형식 : yyyy-MM-dd
//    init {
//        futureWeatherList = futureWeatherDao.getFutureWeather(formatted)
//    }

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

    override fun getDetailedFutureWeather(date: String): FutureWeather {
        return futureWeatherDao.getDetailedFutureWeather(date).mapToFutureWeather()
    }

    override suspend fun deleteWeather(firstDateToKeep: String) {
        futureWeatherDao.deleteWeather(firstDateToKeep)
    }

}