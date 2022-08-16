package com.example.bcsd_weather.data.dao


import androidx.room.*
import com.example.bcsd_weather.data.CurrentWeatherEntity

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Delete
    fun deleteCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Query("select * from current_weather")
    fun getCurrentWeather() : List<CurrentWeatherEntity>
}