package com.example.bcsd_weather.data.model

import com.example.bcsd_weather.domain.enums.ShortForecastPrecipitationType
import com.example.bcsd_weather.domain.enums.SkyType
import com.example.bcsd_weather.domain.model.FutureWeather
import com.example.bcsd_weather.domain.model.TempData

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

fun ShortTermForecastRemote.mapToShortTermForecast(): List<FutureWeather> {

    if (response.header.resultCode != 0) {
        return listOf()
    }

    val list = response.body.items.item

    val mappedData = ArrayList<FutureWeather>()

    var forecastDate = ""
    var forecastTime = ""

    lateinit var precipitationProbability: String
    lateinit var precipitationType: ShortForecastPrecipitationType
    lateinit var precipitation: String
    lateinit var humidity: String
    lateinit var snow: String
    lateinit var skyState: SkyType
    lateinit var temperature: String
    lateinit var waveHeight: String
    lateinit var windDirection: String
    lateinit var windSpeed: String

    for (item in list) {
        if (forecastTime != item.fcstTime) {
            if (forecastTime != "") {
                mappedData.add(
                    FutureWeather(
                        forecastDate,
                        forecastTime,
                        precipitationProbability,
                        precipitationType,
                        precipitation,
                        humidity,
                        snow,
                        skyState,
                        temperature,
                        windDirection,
                        windSpeed,
                        waveHeight
                    )
                )
            }
        }

        forecastDate = item.fcstDate
        forecastTime = item.fcstTime

        when (item.category) {
            "POP" -> {
                precipitationProbability = item.fcstValue
            }
            "PTY" -> {
                precipitationType = when (item.fcstValue) {
                    "0" -> ShortForecastPrecipitationType.NONE
                    "1" -> ShortForecastPrecipitationType.RAIN
                    "2" -> ShortForecastPrecipitationType.RAIN_SNOW
                    "3" -> ShortForecastPrecipitationType.SNOW
                    "4" -> ShortForecastPrecipitationType.SHOWER
                    else -> ShortForecastPrecipitationType.NONE
                }
            }
            "PCP" -> {
                precipitation = item.fcstValue
            }
            "REH" -> {
                humidity = item.fcstValue
            }
            "SNO" -> {
                snow = item.fcstValue
            }
            "SKY" -> {
                skyState = when (item.fcstValue) {
                    "1" -> SkyType.SUNNY
                    "3" -> SkyType.CLOUDY
                    "4" -> SkyType.OVERCAST
                    else -> SkyType.SUNNY
                }
            }
            "TMP" -> {
                temperature = item.fcstValue
            }
            "WAV" -> {
                waveHeight = item.fcstValue
            }
            "VEC" -> {
                windDirection = item.fcstValue
            }
            "WSD" -> {
                windSpeed = item.fcstValue
            }
            else -> {}
        }
    }
    return mappedData
}

fun ShortTermForecastRemote.mapToTempData(): List<TempData> {
    if (response.header.resultCode != 0) {
        return listOf()
    }

    val list = response.body.items.item

    val mappedData = ArrayList<TempData>()

    var lowestTemperature = ""
    var highestTemperature = ""

    var forecastDate = ""

    for (item in list) {
        if (forecastDate != item.fcstDate && forecastDate != "") {
            mappedData.add(
                TempData(
                    forecastDate,
                    lowestTemperature,
                    highestTemperature
                )
            )
        }

        forecastDate = item.fcstDate

        when (item.category) {
            "TMN" -> {
                lowestTemperature = item.fcstValue
            }
            "TMX" -> {
                highestTemperature = item.fcstValue
            }
            else -> {}
        }
    }
    return mappedData
}