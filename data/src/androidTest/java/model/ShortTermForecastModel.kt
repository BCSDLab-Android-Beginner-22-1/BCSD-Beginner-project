package model

import com.google.gson.annotations.SerializedName

// 단기 예보
data class ShortTermForecastModel(
    @SerializedName("TMP") var temp: String = "",            // 온도
    @SerializedName("PCP") var precipitation: String = "",   // 강수량
    @SerializedName("PEH") var humidity: String = "",        // 습도
    @SerializedName("WSP") var windSpeed: String = "",       // 풍속
    @SerializedName("fcstTime") var fcstTime: String = ""   // 예보시각
)