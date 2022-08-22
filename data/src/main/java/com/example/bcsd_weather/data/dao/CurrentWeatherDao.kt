package com.example.bcsd_weather.data.dao

import androidx.room.*
import com.example.bcsd_weather.data.model.CurrentWeatherEntity

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Delete
    fun deleteCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Query("select * from current_weather where x = :x and y = :y ORDER BY fcstDate ASC")
    fun getCurrentWeather(x: Int, y: Int) : List<CurrentWeatherEntity>
}