package com.example.bcsd_weather.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "localDataTable")
data class LocalEntity(
    @PrimaryKey(autoGenerate = true) val id : Long,
    val LocalName: String,
    val x:Double,
    val y:Double
)
