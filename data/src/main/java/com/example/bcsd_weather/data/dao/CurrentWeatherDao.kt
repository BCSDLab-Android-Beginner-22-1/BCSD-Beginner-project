package com.example.bcsd_weather.data.dao

import androidx.room.*
import com.example.bcsd_weather.data.model.CurrentWeatherEntity

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Delete
    fun deleteCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Query("select * from current_weather where (x = :x and y = :y)" +
            "and ((CAST(fcstDate AS INTEGER) = CAST(:todayDate AS INTEGER) and CAST(fcstTime AS INTEGER) > CAST(:startTime AS INTEGER))" +
            "or (CAST(fcstDate AS INTEGER) > CAST(:todayDate AS INTEGER)))" +
            "ORDER BY fcstDate ASC")
    fun getCurrentWeather(x: Int, y: Int, startTime: String, todayDate: String) : List<CurrentWeatherEntity>
}