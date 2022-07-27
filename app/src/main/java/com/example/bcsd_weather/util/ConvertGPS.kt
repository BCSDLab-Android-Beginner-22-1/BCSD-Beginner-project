package com.example.bcsd_weather.util

import kotlin.math.*

class ConvertGPS {
    val RE = 6371.00877 // 지구 반경
    val GRID = 5.0 // 격자 간격
    val SLAT1 = 30.0 // 표준 위도
    val SLAT2 = 60.0 // 표준 위도
    val OLON = 126.0 // 기준점 경도
    val OLAT = 38.0 // 기준점 위도
    val XO = 210 / GRID // 기준점 X 좌표
    val YO = 675 / GRID // 기준점 Y 좌표

    fun convertGPStoXY(latitude: Double, longitude: Double): Map<String, Int> {
        val map = lamcproj(latitude, longitude)
        val x = (map["x"]!! + 1.5).toInt()
        val y = (map["y"]!! + 1.5).toInt()

        return mapOf("x" to x, "y" to y)
    }

    /** Lambert Conformal Conic Projection **/
    private fun lamcproj(latitude: Double, longitude: Double): Map<String, Double> {
        val PI = asin(1.0) * 2.0
        val DEGRAD = PI / 180.0

        val radius = RE / GRID
        val slat1 = SLAT1 * DEGRAD
        val slat2 = SLAT2 * DEGRAD
        val olon = OLON * DEGRAD
        val olat = OLAT * DEGRAD

        var sn = tan(PI * 0.25 + slat2 * 0.5) / tan(PI * 0.25 + slat1 * 0.5)
        sn = ln(cos(slat1) / cos(slat2)) / ln(sn)
        var sf = tan(PI * 0.25 + slat1 * 0.5)
        sf = sf.pow(sn) * cos(slat1) / sn
        var ro = tan(PI * 0.25 + olat * 0.5)
        ro = radius * sf / ro.pow(sn)
        var ra = tan(PI * 0.25 + latitude * DEGRAD * 0.5)
        ra = radius * sf / ra.pow(sn)

        var theta = longitude * DEGRAD - olon
        if (theta > PI)
            theta -= 2.0 * PI
        if (theta < -PI)
            theta += 2.0 * PI
        theta *= sn

        val x = (ra * sin(theta)) + XO
        val y = (ro - ra * cos(theta)) + YO

        return mapOf("x" to x, "y" to y)
    }
}