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

    @Query("select * from future_weather where fcstDate = :date and x = :x and y = :y and CAST(fcstTime AS INTEGER) >= CAST(:startTime AS INTEGER)")
    fun getDetailedFutureWeather(date: String, x: Int, y: Int, startTime: String): List<FutureWeatherEntity>

    @Query("delete from future_weather where CAST(fcstDate AS INTEGER) < CAST(:firstDateToKeep AS INTEGER)")
    fun deleteWeather(firstDateToKeep: String)
}