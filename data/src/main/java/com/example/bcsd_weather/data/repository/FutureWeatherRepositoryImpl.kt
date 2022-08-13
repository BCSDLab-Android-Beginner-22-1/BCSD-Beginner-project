package com.example.bcsd_weather.data.repository

import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.db.FutureWeatherDao
import com.example.bcsd_weather.domain.model.FutureWeatherEntity
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository


class FutureWeatherRepositoryImpl(private val futureWeatherDao: FutureWeatherDao) :
    FutureWeatherRepository {

//    private val futureWeatherList: LiveData<List<FutureWeatherEntity>>
//    private val current = LocalDate.now()
//    private val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
//    private val formatted = current.format(formatter)

    // 날짜 형식 : yyyyMMdd
//    init {
//        futureWeatherList = futureWeatherDao.getFutureWeather(formatted)
//    }

    override suspend fun insertFutureWeather(futureWeatherEntity: List<FutureWeatherEntity>) {
        futureWeatherDao.insertFutureWeather(futureWeatherEntity)
    }

    override fun getFutureWeather(startDate: String): LiveData<List<FutureWeatherEntity>> {
        return futureWeatherDao.getFutureWeather(startDate)
    }

    override fun getDetailedFutureWeather(date: String): LiveData<FutureWeatherEntity> {
        return futureWeatherDao.getDetailedFutureWeather(date)
    }

    override suspend fun deleteWeather(firstDateToKeep: String) {
        futureWeatherDao.deleteWeather(firstDateToKeep)
    }

}