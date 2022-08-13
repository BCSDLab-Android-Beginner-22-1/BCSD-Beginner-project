package com.example.bcsd_weather.data.datasource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.bcsd_weather.data.model.FutureWeatherEntity

@Dao
interface FutureWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFutureWeather(futureWeatherEntity: FutureWeatherEntity)

    @Query("select * from future_weather where date(fcstDate) >= date(:startDate)")
    fun getFutureWeather(startDate: String): List<FutureWeatherEntity>

    @Query("select * from future_weather where date(fcstDate) = date(:date)")
    fun getDetailedFutureWeather(date: String): FutureWeatherEntity

    @Query("delete from future_weather where date(fcstDate) < date(:firstDateToKeep)")
    fun deleteWeather(firstDateToKeep: String)

}