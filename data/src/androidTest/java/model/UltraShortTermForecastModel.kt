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
