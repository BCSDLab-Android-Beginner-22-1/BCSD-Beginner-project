package com.example.bcsd_weather.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.bcsd_weather.domain.model.ShortTermForecastModel
import com.example.bcsd_weather.domain.model.StITEM
import com.google.gson.annotations.SerializedName

@Entity(tableName = "future_weather", indices = [Index(value = ["fcstDate"])])
data class FutureWeatherEntity(
    @SerializedName("TMP") var temp: String = "",            // 온도
    @SerializedName("PCP") var precipitation: String = "",   // 강수량
    @SerializedName("PEH") var humidity: String = "",        // 습도
    @SerializedName("WSP") var windSpeed: String = "",       // 풍속
    @SerializedName("fcstTime") var fcstTime: String = "",   // 예보시각
    val category: String="",  // 자료 구분
    val fcstDate: String = "",  // 예측 날짜
    val fcstValue: String = ""  // 예보 값
){
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null
}