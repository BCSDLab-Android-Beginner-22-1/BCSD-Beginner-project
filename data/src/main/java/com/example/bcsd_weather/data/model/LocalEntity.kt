package com.example.bcsd_weather.data.model

import androidx.room.Entity

@Entity(tableName = "localDataTable", primaryKeys = ["x", "y"])
data class LocalEntity(
    val localName: String,
    val x: Int,
    val y: Int
)
