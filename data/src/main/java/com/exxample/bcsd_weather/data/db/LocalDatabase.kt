package com.exxample.bcsd_weather.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.exxample.bcsd_weather.data.model.LocalEntity
import com.exxample.bcsd_weather.data.dao.LocalDao


@Database(entities = [LocalEntity::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun localDao(): LocalDao

    companion object {
        private var instance: LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase? {
            if (instance == null) {
                synchronized(LocalDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        "local_db"
                    ).build()
                }
            }
            return instance
        }
    }

}