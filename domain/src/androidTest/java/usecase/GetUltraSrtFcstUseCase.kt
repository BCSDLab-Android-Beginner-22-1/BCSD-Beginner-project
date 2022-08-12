package usecase

import model.UltraShortTermForecast
import repository.UltraSrtFcstRepository

class GetUltraSrtFcstUseCase(private val ultraSrtFcstRepository: UltraSrtFcstRepository) {
    suspend fun execute(serviceKey: String,
                        numOfRows: Int,
                        pageNo: Int,
                        dataType: String,
                        baseDate: String,
                        baseTime: String,
                        nx: Int,
                        ny: Int): UltraShortTermForecast
    = ultraSrtFcstRepository.getUltraSrtFcst(
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