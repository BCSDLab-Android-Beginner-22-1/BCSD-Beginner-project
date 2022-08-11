package model

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
data class UstWeather(val response: UstResponse)
data class UstResponse(val header: UstHeader, val body: UstBody)
data class UstHeader(val resultCode: Int, val resultMsg: String)
data class UstBody(val dataType: String, val items: UstItemList, val totalCount: Int)
data class UstItemList(val item: List<UstItem>)

data class UstItem(
    val category: String,   // 자료 구분
    val fcstDate: String,   // 예측 날짜
    val fcstTime: String,   // 예측 시간
    val fcstValue: String,  // 예보 값
)
