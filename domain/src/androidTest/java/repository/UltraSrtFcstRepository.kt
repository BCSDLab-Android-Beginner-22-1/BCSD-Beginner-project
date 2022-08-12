package repository

import model.UltraShortTermForecast

interface UltraSrtFcstRepository {
    suspend fun getUltraSrtFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int): UltraShortTermForecast
}