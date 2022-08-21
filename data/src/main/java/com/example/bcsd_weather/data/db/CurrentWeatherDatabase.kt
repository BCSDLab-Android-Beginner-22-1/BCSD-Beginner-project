package com.example.bcsd_weather.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bcsd_weather.data.model.CurrentWeatherEntity

import com.example.bcsd_weather.data.dao.CurrentWeatherDao

@Database(entities = [CurrentWeatherEntity::class], version = 9)
abstract class CurrentWeatherDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao


}