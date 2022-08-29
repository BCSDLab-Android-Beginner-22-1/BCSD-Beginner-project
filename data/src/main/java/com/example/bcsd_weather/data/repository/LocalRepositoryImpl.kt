package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.data.dao.LocalDao
import com.example.bcsd_weather.data.mapper.mapToLocalData
import com.example.bcsd_weather.data.mapper.mapToLocalEntity
import com.example.bcsd_weather.domain.model.LocalData
import com.example.bcsd_weather.domain.repository.LocalRepository

class LocalRepositoryImpl(private val localDao: LocalDao) : LocalRepository {

    override fun getAllLocalData(): List<LocalData> {
        val data = localDao.getAllLocalData()
        val converted = ArrayList<LocalData>()

        for (i in data) {
            converted.add(i.mapToLocalData())
        }
        return converted.toList()
    }

    override suspend fun insertLocalData(localData: LocalData) {
        localDao.insertLocalData(localData.mapToLocalEntity())
    }


    override suspend fun deleteLocalData(localData: LocalData) {
        this.localDao.deleteLocalData(localData.mapToLocalEntity())
    }

}