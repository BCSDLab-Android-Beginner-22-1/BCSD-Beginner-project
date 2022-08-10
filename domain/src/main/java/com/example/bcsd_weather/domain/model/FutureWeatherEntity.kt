package com.example.bcsd_weather.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.bcsd_weather.domain.model.ShortTermForecastModel
import com.example.bcsd_weather.domain.model.StITEM

@Entity(tableName = "future_weather", indices = [Index(value = ["fcstDate"], unique = true)])
data class FutureWeatherEntity(
    @Embedded(prefix = "foo_")
    val shortTermForecastModel: ShortTermForecastModel,
    @Embedded
    val StITEM: StITEM
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}