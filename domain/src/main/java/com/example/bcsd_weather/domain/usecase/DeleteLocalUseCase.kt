package com.example.bcsd_weather.domain.usecase

import com.example.bcsd_weather.domain.model.LocalData
import com.example.bcsd_weather.domain.repository.LocalRepository

class DeleteLocalUseCase(private val localRepository: LocalRepository) {
    suspend operator fun invoke(localData : LocalData) =
        localRepository.deleteLocalData(localData)
}