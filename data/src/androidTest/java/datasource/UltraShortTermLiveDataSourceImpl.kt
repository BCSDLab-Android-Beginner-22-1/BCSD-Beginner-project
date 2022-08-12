package datasource

import api.RetrofitBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import model.UltraShortTermLiveRemote

class UltraShortTermLiveDataSourceImpl: UltraShortTermLiveDataSource {
    override fun getUltraShortTermLive(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): Flow<UltraShortTermLiveRemote>
    = flow {
        emit(RetrofitBuilder
        .ultraShortTermLiveService()
        .getWeather(serviceKey, numOfRows, pageNo, dataType, baseDate, baseTime, nx, ny))
    }
}