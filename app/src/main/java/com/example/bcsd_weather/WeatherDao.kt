package com.example.bcsd_weather

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bcsd_weather.data.WEATHER
import com.example.bcsd_weather.data.WeatherModel

interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weather: WeatherModel)

    @Delete
    fun delete(weather: WeatherModel)

    @Query("SELECT * FROM WeatherModel")
    fun getAll() : LiveData<List<WeatherModel>>
}