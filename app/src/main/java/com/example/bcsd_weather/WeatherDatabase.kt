package com.example.bcsd_weather

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.bcsd_weather.data.WeatherModel

@Database(entities = [WeatherModel::class], version = 1)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object{
        private var instance : WeatherDatabase?=null

        fun getInstance(context : Context) : WeatherDatabase? {
            if(instance == null){
                synchronized(WeatherDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WeatherDatabase::class.java,
                        "user.db"
                    ).build()
                }
            }
            return instance
        }
    }

}