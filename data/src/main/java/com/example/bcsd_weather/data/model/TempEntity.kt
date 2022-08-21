package com.example.bcsd_weather.data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "tempDataTable",
    indices = [Index(value = ["date"])],
    primaryKeys = ["date", "x", "y"]
)


data class TempEntity(
    val date: String,
    var x : Int,
    var y : Int,
    var updateTime : Long,
    val maxTemperature: String,
    val minTemperature: String
)
