package usecase

import model.ShortTermForecast
import repository.ShortTermFcstRepository

class GetShortTermFcstUseCase(private val shortTermFcstRepository: ShortTermFcstRepository) {
    suspend fun excute(serviceKey: String,
                       numOfRows: Int,
                       pageNo: Int,
                       dataType: String,
                       baseDate: String,
                       baseTime: String,
                       nx: Int,
                       ny: Int): ShortTermForecast
    = shortTermFcstRepository.getShortTermFcst(
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