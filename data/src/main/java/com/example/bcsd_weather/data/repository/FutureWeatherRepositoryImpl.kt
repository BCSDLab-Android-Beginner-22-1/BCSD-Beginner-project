package com.example.bcsd_weather.data.repository

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.db.FutureWeatherDao
import com.example.bcsd_weather.data.db.FutureWeatherDatabase
import com.example.bcsd_weather.domain.model.FutureWeatherEntity
import com.example.bcsd_weather.domain.repository.FutureWeatherRepository
import com.google.gson.Gson
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class FutureWeatherRepositoryImpl(application: Application, var futureDb: FutureWeatherDatabase,val futureWeatherDao: FutureWeatherDao) :
    FutureWeatherRepository {

//    private val futureWeatherList: LiveData<List<FutureWeatherEntity>>
    private val gson = Gson()
    private val current = LocalDate.now()
    private val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    private val formatted = current.format(formatter)

    // 날짜 형식 : yyyyMMdd
    init {
        futureDb = FutureWeatherDatabase.getInstance(application, gson)!!
        Log.v("init", ">>> 초기화")
//        futureWeatherList = futureDb.futureWeatherDao().getFutureWeather(formatted)
    }

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