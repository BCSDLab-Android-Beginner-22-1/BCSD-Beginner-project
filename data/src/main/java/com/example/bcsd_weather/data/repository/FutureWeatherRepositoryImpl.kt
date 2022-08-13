package com.example.bcsd_weather.data.repository

import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.db.FutureWeatherDao
import com.example.bcsd_weather.data.model.FutureWeatherEntity
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository


class FutureWeatherRepositoryImpl(private val futureWeatherDao: FutureWeatherDao) :
    FutureWeatherRepository {

//    private val futureWeatherList: LiveData<List<FutureWeatherEntity>>
//    private val current = LocalDate.now()


    // 날짜 형식 : yyyy-MM-dd
//    init {
//        futureWeatherList = futureWeatherDao.getFutureWeather(formatted)
//    }

    override suspend fun insertFutureWeather(futureWeatherEntity: FutureWeatherEntity) {
        futureWeatherDao.insertFutureWeather(futureWeatherEntity)
    }

    override fun getFutureWeather(startDate: String): List<FutureWeatherEntity> {
        return futureWeatherDao.getFutureWeather(startDate)
    }

    override fun getDetailedFutureWeather(date: String): FutureWeatherEntity {
        return futureWeatherDao.getDetailedFutureWeather(date)
    }

    override suspend fun deleteWeather(firstDateToKeep: String) {
        futureWeatherDao.deleteWeather(firstDateToKeep)
    }

}