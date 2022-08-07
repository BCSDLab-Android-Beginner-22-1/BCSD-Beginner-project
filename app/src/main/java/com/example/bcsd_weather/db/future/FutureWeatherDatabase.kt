package com.example.bcsd_weather.db.future

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bcsd_weather.data.FutureWeatherEntity
import com.example.bcsd_weather.data.WeatherModel
import com.example.bcsd_weather.db.current.CurrentWeatherDao

@Database(entities = [FutureWeatherEntity::class], version = 1)
abstract class FutureWeatherDatabase : RoomDatabase() {

    abstract fun futureWeatherDao(): FutureWeatherDao

    companion object {
        private var instance: FutureWeatherDatabase? = null

        fun getInstance(context: Context): FutureWeatherDatabase? {
            if (instance == null) {
                synchronized(FutureWeatherDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FutureWeatherDatabase::class.java,
                        "future_weather.db"
                    ).build()
                }
            }
            return instance
        }
    }

}