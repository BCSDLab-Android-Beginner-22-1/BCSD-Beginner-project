package com.example.bcsd_weather.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class WeatherModel(
    @SerializedName("TMP") var temp: String = "",            // 온도
    @SerializedName("PCP") var precipitation: String = "",   // 강수량
    @SerializedName("PEH") var humidity: String = "",        // 습도
    @SerializedName("WSP") var windSpeed: String = "",       // 풍속
    @SerializedName("fcstTime") var fcstTime: String = "",   // 예보시각
){
    @PrimaryKey(autoGenerate = true)
    var id = 0

}



// xml 파일 형식을 data class로 구현
data class WEATHER(val response: RESPONSE)
data class RESPONSE(val header: HEADER, val body: BODY)
data class HEADER(val resultCode: Int, val resultMsg: String)
data class BODY(val dataType: String, val items: ITEMS, val totalCount: Int)
data class ITEMS(val item: List<ITEM>)

// category: 자료 구분, fcstDate: 예측 날짜, fcstTime: 예측 시간, fcstValue = 예보 값
data class ITEM(val category: String, val fcstDate: String, val fcstTime: String, val fcstValue: String)
