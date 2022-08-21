package com.example.bcsd_weather.data.repository

import com.example.bcsd_weather.domain.model.TempData
import com.example.bcsd_weather.domain.repository.TempRepository
import com.example.bcsd_weather.data.dao.TempDao
import com.example.bcsd_weather.data.mapper.mapToTempData
import com.example.bcsd_weather.data.mapper.mapToTempEntity

class TempRepositoryImpl(private val tempDao: TempDao):TempRepository {

    override fun getAllTempData(x: Int, y: Int): List<TempData> {
        val data = tempDao.getAllTempData(x, y)
        val converted = ArrayList<TempData>()

        for (i in data){
            converted.add(i.mapToTempData())
        }
        return converted.toList()
    }

    override fun getTempData(findDate: String, x: Int, y: Int): List<TempData> {
        val data = tempDao.getTempData(findDate, x, y)
        val converted = ArrayList<TempData>()

        for (i in data){
            converted.add(i.mapToTempData())
        }
        return converted.toList()
    }

    override suspend fun insertTempData(TempData: TempData) {
        tempDao.insertTempData(TempData.mapToTempEntity())
    }


    override suspend fun deleteTempData(TempData: TempData){
        this.tempDao.deleteTempData(TempData.mapToTempEntity())
    }

}