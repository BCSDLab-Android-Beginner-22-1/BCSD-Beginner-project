package com.example.bcsd_weather.util

import java.text.SimpleDateFormat
import java.util.*

class BaseTime {
    fun getBaseDateAndTime(apiType: ApiType): Map<String, String> {
        val now = Date()

        val yearPattern = SimpleDateFormat("yyyy", Locale.getDefault())
        val monthPattern = SimpleDateFormat("MM", Locale.getDefault())
        val dayPattern = SimpleDateFormat("dd", Locale.getDefault())
        val hourPattern = SimpleDateFormat("HH", Locale.getDefault())
        val minutePattern = SimpleDateFormat("mm", Locale.getDefault())

        val currentYear = Integer.parseInt(yearPattern.format(now))
        val currentMonth = Integer.parseInt(monthPattern.format(now))
        val currentDay = Integer.parseInt(dayPattern.format(now))
        val currentHour = Integer.parseInt(hourPattern.format(now))
        val currentMinute = Integer.parseInt(minutePattern.format(now))

        var baseYear = currentYear
        var baseMonth = currentMonth
        var baseDay = currentDay
        var baseHour = currentHour
        var baseMinute = 0

        var apiUpdateMinute = 0

        when (apiType) {
            ApiType.NOW_CAST -> {
                apiUpdateMinute = 40
                baseMinute = 0
            }
            ApiType.SHORT_FORECAST -> {
                apiUpdateMinute = 45
                baseMinute = 30
            }
            ApiType.FORECAST -> {
                apiUpdateMinute = 10
                baseMinute = 0
            }
        }

        if (currentMinute < apiUpdateMinute) {
            baseHour -= 1
        }

        when (apiType) {
            ApiType.FORECAST -> {
                val forecastTime = listOf(2, 5, 8, 11, 14, 17, 20, 23)
                run loop@{
                    forecastTime.reversed().forEach {
                        if (baseHour > it) {
                            baseHour = it
                            return@loop
                        } else if (baseHour < 2) {
                            baseHour = 23
                            baseDay -= 1
                            return@loop
                        }
                    }
                }
            }
            else -> {
                if (baseHour < 0) {
                    baseHour = 23
                    baseDay -= 1
                }
            }
        }

        if (baseDay < 0) {
            baseMonth -= 1

            if (baseMonth < 0) {
                baseYear -= 1
                baseMonth = 12
            }

            val cal = Calendar.getInstance()
            cal.set(baseYear, baseMonth - 1, baseDay)

            baseDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        }

        val baseDate = String.format("%d%02d%02d", baseYear, baseMonth, baseDay)
        val baseTime = String.format("%02d%02d", baseHour, baseMinute)

        return mapOf("baseDate" to baseDate, "baseTime" to baseTime)
    }
}