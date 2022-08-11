package model

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
data class UslWeather(val response: UslResponse)
data class UslResponse(val header: UslHeader, val body: UslBody)
data class UslHeader(val resultCode: Int, val resultMsg: String)
data class UslBody(val dataType: String, val items: UslItemList, val totalCount: Int)
data class UslItemList(val item: List<UslItem>)

data class UslItem(
    val category: String,   // 자료 구분
    val baseDate: String,   // 발표일자
    val baseTime: String,   // 발표시각
    val obsrValue: String,  // 실황 값
)