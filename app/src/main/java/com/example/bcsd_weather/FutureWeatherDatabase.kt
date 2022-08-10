package com.example.bcsd_weather.db.future

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.bcsd_weather.data.FutureWeatherEntity
import com.example.bcsd_weather.db.future.converter.StItemTypeConverter
import com.example.bcsd_weather.db.future.converter.shortTermForecastModelTypeConverter
import com.google.gson.Gson


@Database(entities = [FutureWeatherEntity::class], version = 1)
@TypeConverters(
    value = [
        shortTermForecastModelTypeConverter::class,
        StItemTypeConverter::class
    ]
)
abstract class FutureWeatherDatabase : RoomDatabase() {

    abstract fun futureWeatherDao(): FutureWeatherDao

    companion object {
        private var instance: FutureWeatherDatabase? = null

        fun getInstance(context: Context, gson: Gson): FutureWeatherDatabase? {
            if (instance == null) {
                synchronized(FutureWeatherDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FutureWeatherDatabase::class.java,
                        "future_weather.db"
                    )
                        .addTypeConverter(shortTermForecastModelTypeConverter(gson))
                        .addTypeConverter(StItemTypeConverter(gson))
                        .build()
                }
            }
            return instance
        }
    }

}