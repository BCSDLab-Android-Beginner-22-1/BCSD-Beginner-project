package datasource

import kotlinx.coroutines.flow.Flow
import model.UltraShortTermForeCastRemote

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