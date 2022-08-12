package com.example.bcsd_weather.data.db

import android.content.Context
import androidx.room.*
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bcsd_weather.data.WeatherModel

@Database(entities = [WeatherModel::class], version = 2)
abstract class CurrentWeatherDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object {
        private var instance: CurrentWeatherDatabase? = null

        fun getInstance(context: Context): CurrentWeatherDatabase? {
            if (instance == null) {
                synchronized(CurrentWeatherDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CurrentWeatherDatabase::class.java,
                        "current_weather.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }
    }

}