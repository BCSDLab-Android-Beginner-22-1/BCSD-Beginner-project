package com.example.bcsd_weather.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "future_weather", indices = [Index(value = ["fcstDate"], unique = true)])
data class FutureWeatherEntity(
    val response: UstRESPONSE,
    @Embedded
    val ultraShortTermForecastModel: UltraShortTermForecastModel,
    @Embedded
    val ustITEM: UstITEM
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}