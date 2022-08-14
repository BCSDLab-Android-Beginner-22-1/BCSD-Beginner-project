package com.exxample.bcsd_weather.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.exxample.bcsd_weather.data.model.LocalEntity
import com.exxample.bcsd_weather.data.dao.LocalDao


@Database(entities = [LocalEntity::class], version = 2)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun localDao(): LocalDao

}