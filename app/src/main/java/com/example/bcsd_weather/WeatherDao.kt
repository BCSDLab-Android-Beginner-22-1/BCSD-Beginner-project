package com.example.bcsd_weather

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bcsd_weather.data.CURRENT_WEATHER_ID
import com.example.bcsd_weather.data.WEATHER
import com.example.bcsd_weather.data.WeatherModel

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weather: WeatherModel)

    @Delete
    fun delete(weather: WeatherModel)

    @Query("SELECT * FROM current_weather WHERE id = $CURRENT_WEATHER_ID")
    fun getIdWeather() : LiveData<WeatherModel>

    @Query("SELECT * FROM current_weather")
    fun getAllWeather() : LiveData<List<WeatherModel>>
}