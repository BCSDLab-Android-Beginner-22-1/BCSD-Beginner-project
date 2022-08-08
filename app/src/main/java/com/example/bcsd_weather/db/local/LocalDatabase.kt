package com.example.bcsd_weather.db.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalEntity::class], version = 1)
abstract class LocalDatabase:RoomDatabase() {
    abstract fun localDao(): LocalDao
}