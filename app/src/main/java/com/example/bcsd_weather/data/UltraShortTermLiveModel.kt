package com.example.bcsd_weather.data

import com.google.gson.annotations.SerializedName

// 초단기 실황
data class UltraShortTermLiveModel (
    @SerializedName("T1H") var temp: String = "",            // 온도
    @SerializedName("RN1") var precipitation: String = "",   // 강수량
    @SerializedName("REH") var humidity: String = "",        // 습도
    @SerializedName("WSD") var windSpeed: String = "",       // 풍속
    @SerializedName("fcstTime") var fcstTime: String = ""   // 예보시각
)

// xml 파일 형식을 data class로 구현
data class UslWEATHER(val response: UslRESPONSE)
data class UslRESPONSE(val header: UslHEADER, val body: UslBODY)
data class UslHEADER(val resultCode: Int, val resultMsg: String)
data class UslBODY(val dataType: String, val items: UslITEMList, val totalCount: Int)
data class UslITEMList(val item: List<UslITEM>)

data class UslITEM(
    val category: String,   // 자료 구분
    val baseDate: String,   // 발표일자
    val baseTime: String,   // 발표시각
    val obsrValue: String,  // 실황 값
)