package com.example.bcsd_weather.domain.model

import com.google.gson.annotations.SerializedName

// 단기 예보
data class ShortTermForecastModel(
    @SerializedName("TMP") var temp: String = "",            // 온도
    @SerializedName("PCP") var precipitation: String = "",   // 강수량
    @SerializedName("PEH") var humidity: String = "",        // 습도
    @SerializedName("WSP") var windSpeed: String = "",       // 풍속
    @SerializedName("fcstTime") var fcstTime: String = "",   // 예보시각
)

// xml 파일 형식을 data class로 구현
data class StWEATHER(val response: StRESPONSE)
data class StRESPONSE(val header: StHEADER, val body: StBODY)
data class StHEADER(val resultCode: Int, val resultMsg: String)
data class StBODY(val dataType: String, val items: StITEMList, val totalCount: Int)
data class StITEMList(val item: List<StITEM>)

data class StITEM(
    val category: String,  // 자료 구분
    val fcstDate: String,  // 예측 날짜
    val fcstTime: String,  // 예측 시간
    val fcstValue: String  // 예보 값
    )
