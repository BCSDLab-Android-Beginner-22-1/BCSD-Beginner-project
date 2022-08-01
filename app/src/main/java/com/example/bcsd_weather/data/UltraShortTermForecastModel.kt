package com.example.bcsd_weather.data

import com.google.gson.annotations.SerializedName

// 초단기 예보
data class UltraShortTermForecastModel(
    @SerializedName("T1H") var temp: String = "",            // 온도
    @SerializedName("RN1") var precipitation: String = "",   // 강수량
    @SerializedName("REH") var humidity: String = "",        // 습도
    @SerializedName("WSD") var windSpeed: String = "",       // 풍속
    @SerializedName("fcstTime") var fcstTime: String = ""   // 예보시각
)

// xml 파일 형식을 data class로 구현
data class UstWEATHER(val response: UstRESPONSE)
data class UstRESPONSE(val header: UstHEADER, val body: UstBODY)
data class UstHEADER(val resultCode: Int, val resultMsg: String)
data class UstBODY(val dataType: String, val items: UstITEMList, val totalCount: Int)
data class UstITEMList(val item: List<UstITEM>)

data class UstITEM(
    val category: String,   // 자료 구분
    val fcstDate: String,   // 예측 날짜
    val fcstTime: String,   // 예측 시간
    val fcstValue: String,  // 예보 값
)