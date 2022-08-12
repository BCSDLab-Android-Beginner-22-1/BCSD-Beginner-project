package datasource

import kotlinx.coroutines.flow.Flow
import model.UltraShortTermLiveRemote

interface UltraShortTermLiveDataSource {
    fun getUltraShortTermLive(serviceKey: String,
                              numOfRows: Int,
                              pageNo: Int,
                              dataType: String,
                              baseDate: String,
                              baseTime: String,
                              nx: Int,
                              ny: Int
    ): Flow<UltraShortTermLiveRemote>
}