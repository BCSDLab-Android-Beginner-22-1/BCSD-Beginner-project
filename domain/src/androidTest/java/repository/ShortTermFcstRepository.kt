package repository

import model.ShortTermForecast

interface ShortTermFcstRepository {
    suspend fun getShortTermFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int): ShortTermForecast
}