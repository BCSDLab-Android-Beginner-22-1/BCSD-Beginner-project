package usecase

import model.UltraShortTermLive
import repository.UltraSrtLiveRepository

class GetUltraSrtLiveUseCase(private val ultraSrtLiveUseCase: UltraSrtLiveRepository) {
    suspend fun execute(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int): UltraShortTermLive
    = ultraSrtLiveUseCase.getUltraSrtLive(
        serviceKey,
        numOfRows,
        pageNo,
        dataType,
        baseDate,
        baseTime,
        nx,
        ny
    )
}