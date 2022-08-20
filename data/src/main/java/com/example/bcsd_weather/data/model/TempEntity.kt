package com.example.bcsd_weather.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tempDataTable")
data class TempEntity(
    @PrimaryKey(autoGenerate = true) val id : Long,
    val date: Int,
    val maxTemperature: Double,
    val minTemperature: Double
)
