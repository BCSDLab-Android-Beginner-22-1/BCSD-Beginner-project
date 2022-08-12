package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.UltraShortTermLive
import com.example.bcsd_weather.domain.repository.UltraSrtLiveRepository

class GetUltraSrtLiveUseCase(private val ultraSrtLiveRepository: UltraSrtLiveRepository) {
    suspend operator fun invoke(nx: Int, ny: Int): UltraShortTermLive =
        ultraSrtLiveRepository.getUltraSrtLive(nx, ny)
}