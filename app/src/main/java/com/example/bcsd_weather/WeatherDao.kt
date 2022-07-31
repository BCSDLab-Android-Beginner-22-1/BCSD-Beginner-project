package com.example.bcsd_weather

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bcsd_weather.data.WEATHER
import com.example.bcsd_weather.data.WeatherModel

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weather: WeatherModel)

    @Delete
    fun delete(weather: WeatherModel)

    @Query("SELECT * FROM WeatherModel")
    fun getAll() : LiveData<List<WeatherModel>>
}