package com.example.bcsd_weather.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bcsd_weather.data.dao.FutureWeatherDao
import com.example.bcsd_weather.data.model.FutureWeatherEntity


@Database(entities = [FutureWeatherEntity::class], version = 5)
abstract class FutureWeatherDatabase : RoomDatabase() {

    abstract fun futureWeatherDao(): FutureWeatherDao


}