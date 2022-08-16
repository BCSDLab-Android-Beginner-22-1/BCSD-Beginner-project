package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.LocalData
import com.example.bcsd_weather.domain.repository.LocalRepository

class GetLocalUseCase(private val localRepository: LocalRepository) {
    operator fun invoke() =
        localRepository.getAllLocalData()
}