package com.example.bcsd_weather.data.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.bcsd_weather.data.model.FutureWeatherEntity

@Dao
interface FutureWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFutureWeather(futureWeatherEntity: FutureWeatherEntity)

    @Query("select * from future_weather where CAST(fcstDate AS INTEGER) >= CAST(:startDate AS INTEGER)")
    fun getFutureWeather(startDate: String): List<FutureWeatherEntity>

    @Query("select * from future_weather where fcstDate = :date")
    fun getDetailedFutureWeather(date: String): List<FutureWeatherEntity>

    @Query("delete from future_weather where CAST(fcstDate AS INTEGER) < CAST(:firstDateToKeep AS INTEGER)")
    fun deleteWeather(firstDateToKeep: String)

    @Query("select * from future_weather where date(fcstDate) = date(:date) ORDER BY CAST(`temp` as INTEGER) DESC LIMIT 1")
    fun getHighestTemp(date:String):FutureWeatherEntity

    @Query("select * from future_weather where date(fcstDate) = date(:date) ORDER BY CAST(`temp` as INTEGER) ASC LIMIT 1")
    fun getLowestTemp(date:String):FutureWeatherEntity

}