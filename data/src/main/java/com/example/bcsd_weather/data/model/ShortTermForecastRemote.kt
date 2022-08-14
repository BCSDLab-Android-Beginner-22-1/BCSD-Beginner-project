package com.example.bcsd_weather.data.model

import com.example.bcsd_weather.domain.enum.ShortForecastPrecipitationType
import com.example.bcsd_weather.domain.enum.SkyType
import com.example.bcsd_weather.domain.model.ShortTermForecast
import com.example.bcsd_weather.domain.model.ShortTermTempForecast

data class ShortTermForecastRemote(val response: StResponse)
data class StResponse(val header: StHeader, val body: StBody)
data class StHeader(val resultCode: Int, val resultMsg: String)
data class StBody(val dataType: String, val items: StItemList, val totalCount: Int)
data class StItemList(val item: List<ShortTermFcst>)

data class ShortTermFcst(
    val category: String,  // 자료 구분
    val fcstDate: String,  // 예측 날짜
    val fcstTime: String,  // 예측 시간
    val fcstValue: String  // 예보 값
)

fun ShortTermForecastRemote.mapToShortTermForecast(): ArrayList<ShortTermForecast>? {
    val list = response.body.items.item

    if (response.header.resultCode != 0) {
        return null
    }

    val mappedData = ArrayList<ShortTermForecast>()
    var newData = ShortTermForecast()

    var forecastDate: String
    var forecastTime = ""

    for (item in list) {
        if (forecastTime != item.fcstTime) {
            if (forecastTime != "") {
                mappedData.add(newData)
            }

            newData = ShortTermForecast()
            forecastDate = item.fcstDate
            forecastTime = item.fcstTime
            newData.forecastDate = forecastDate
            newData.forecastTime = forecastTime
        }

        when (item.category) {
            "POP" -> {
                newData.precipitationProbability = item.fcstValue
            }
            "PTY" -> {
                newData.precipitationTypes = when (item.fcstValue) {
                    "0" -> ShortForecastPrecipitationType.NONE
                    "1" -> ShortForecastPrecipitationType.RAIN
                    "2" -> ShortForecastPrecipitationType.RAIN_SNOW
                    "3" -> ShortForecastPrecipitationType.SNOW
                    "4" -> ShortForecastPrecipitationType.SHOWER
                    else -> ShortForecastPrecipitationType.NONE
                }
            }
            "PCP" -> {
                newData.precipitation = item.fcstValue
            }
            "REH" -> {
                newData.humidity = item.fcstValue
            }
            "SNO" -> {
                newData.snow = item.fcstValue
            }
            "SKY" -> {
                newData.skyState = when (item.fcstValue) {
                    "1" -> SkyType.SUNNY
                    "3" -> SkyType.CLOUDY
                    "4" -> SkyType.OVERCAST
                    else -> SkyType.SUNNY
                }
            }
            "TMP" -> {
                newData.temperature = item.fcstValue
            }
            "WAV" -> {
                newData.waveHeight = item.fcstValue
            }
            "VEC" -> {
                newData.windDirection = item.fcstValue
            }
            "WSD" -> {
                newData.windSpeed = item.fcstValue
            }
            else -> {}
        }
    }
    return mappedData
}

fun ShortTermForecastRemote.mapToShortTermTempForecast(): ArrayList<ShortTermTempForecast>? {
    val list = response.body.items.item

    if (response.header.resultCode != 0) {
        return null
    }

    val mappedData = ArrayList<ShortTermTempForecast>()
    var newData = ShortTermTempForecast()

    var forecastDate = ""

    for (item in list) {
        if (forecastDate != item.fcstDate) {
            if (forecastDate != "") {
                mappedData.add(newData)
            }

            newData = ShortTermTempForecast()
            forecastDate = item.fcstDate
            newData.forecastDate = forecastDate
        }

        when (item.category) {
            "TMN" -> {
                newData.lowestTemperature = item.fcstValue
            }
            "TMX" -> {
                newData.highestTemperature = item.fcstValue
            }
            else -> {}
        }
    }
    return mappedData
}