package com.example.bcsd_weather.db

import android.content.Context
import androidx.room.*
import com.example.bcsd_weather.data.WeatherModel
import com.example.bcsd_weather.db.current.CurrentWeatherDao

@Database(entities = [WeatherModel::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): CurrentWeatherDao

    companion object {
        private var instance: WeatherDatabase? = null

        fun getInstance(context: Context): WeatherDatabase? {
            if (instance == null) {
                synchronized(WeatherDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WeatherDatabase::class.java,
                        "weather.db"
                    ).build()
                }
            }
            return instance
        }
    }

}