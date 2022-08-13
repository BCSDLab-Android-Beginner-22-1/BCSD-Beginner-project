package com.example.bcsd_weather.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bcsd_weather.data.datasource.local.FutureWeatherDao
import com.example.bcsd_weather.data.model.FutureWeatherEntity


@Database(entities = [FutureWeatherEntity::class], version = 5)
abstract class FutureWeatherDatabase : RoomDatabase() {

    abstract fun futureWeatherDao(): FutureWeatherDao
//
//    companion object {
//        private var instance: FutureWeatherDatabase? = null
//
//        fun getInstance(context: Context, gson: Gson): FutureWeatherDatabase? {
//            if (instance == null) {
//                synchronized(FutureWeatherDatabase::class) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        FutureWeatherDatabase::class.java,
//                        "future_weather.db"
//                    )
//                        .addTypeConverter(shortTermForecastModelTypeConverter(gson))
//                        .addTypeConverter(StItemTypeConverter(gson))
//                        .fallbackToDestructiveMigration()
//                        .build()
//                }
//            }
//            return instance
//        }
//    }

}