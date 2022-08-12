package datasource

import kotlinx.coroutines.flow.Flow
import model.ShortTermForecastRemote

interface ShortTermForecastDataSource {
    fun getShortTermFcst(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): Flow<ShortTermForecastRemote>
}