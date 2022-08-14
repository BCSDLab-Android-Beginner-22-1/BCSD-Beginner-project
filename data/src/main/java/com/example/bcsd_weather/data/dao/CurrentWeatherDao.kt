package com.example.bcsd_weather.data.dao


import androidx.room.*
import com.example.bcsd_weather.data.CurrentWeatherEntity

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weather: CurrentWeatherEntity)

    @Delete
    fun delete(weather: CurrentWeatherEntity)

    @Query("SELECT * FROM current_weather")
    fun getCurrentWeather() : List<CurrentWeatherEntity>
}