package com.example.bcsd_weather.db.local

import android.app.Application
import com.exxample.bcsd_weather.data.dao.LocalDao
import com.exxample.bcsd_weather.data.db.LocalDatabase
import com.exxample.bcsd_weather.data.model.LocalEntity

class LocalRepository(application: Application) {
    private val localDao: LocalDao
    private val localDataList: List<LocalEntity>

    init {
        val localDb : LocalDatabase = LocalDatabase.getInstance(application)!!
        localDao = localDb.localDao()
        localDataList = localDb.localDao().getAllLocalData()
    }

    fun getAllLocalData():List<LocalEntity>{
        return localDao.getAllLocalData()
    }

    fun insert(localWeatherEntity: LocalEntity){
        localDao.insert(localWeatherEntity)
    }
    fun deleteAllLocalData(){
        localDao.deleteAllLocalData()
    }

}