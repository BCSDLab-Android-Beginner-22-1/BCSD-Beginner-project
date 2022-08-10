package com.example.bcsd_weather.db.future

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.bcsd_weather.data.FutureWeatherEntity
import com.google.gson.Gson
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class FutureWeatherRepositoryImpl(application: Application, var futureDb:FutureWeatherDatabase) : FutureWeatherRepository {
    private val futureWeatherDao: FutureWeatherDao
    private val futureWeatherList: LiveData<List<FutureWeatherEntity>>
    private val gson = Gson()
    private val current = LocalDate.now()
    private val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    private val formatted = current.format(formatter)

    // 날짜 형식 : yyyyMMdd
    init {
        futureDb = FutureWeatherDatabase.getInstance(application, gson)!!
        futureWeatherDao = futureDb.futureWeatherDao()
        futureWeatherList = futureDb.futureWeatherDao().getFutureWeather(formatted)
    }

    override fun insertFutureWeather(futureWeatherEntity: List<FutureWeatherEntity>) {
        futureWeatherDao.insertFutureWeather(futureWeatherEntity)
    }

    override fun getFutureWeather(startDate: String): LiveData<List<FutureWeatherEntity>> {
        return futureWeatherDao.getFutureWeather(startDate)
    }

    override fun getDetailedFutureWeather(date: String): LiveData<FutureWeatherEntity> {
        return futureWeatherDao.getDetailedFutureWeather(date)
    }

    override fun deleteWeather(firstDateToKeep: String) {
        futureWeatherDao.deleteWeather(firstDateToKeep)
    }

}