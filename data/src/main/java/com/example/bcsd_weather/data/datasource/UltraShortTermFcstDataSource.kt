package com.example.bcsd_weather.data.datasource

import kotlinx.coroutines.flow.Flow
import com.example.bcsd_weather.data.model.UltraShortTermForeCastRemote

interface UltraShortTermFcstDataSource {
    fun getUltraShortTermFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): Flow<UltraShortTermForeCastRemote>
}