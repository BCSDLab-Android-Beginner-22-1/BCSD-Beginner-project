package com.example.bcsd_weather.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bcsd_weather.data.model.TempEntity
import com.example.bcsd_weather.data.dao.TempDao


@Database(entities = [TempEntity::class], version = 2)
abstract class TempDatabase : RoomDatabase() {
    abstract fun tempDao(): TempDao

}