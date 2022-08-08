package com.example.bcsd_weather.db.local

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room

class LocalRepository(application: Application) {
    private val localDao:LocalDao
    private val localDataList: LiveData<List<LocalEntity>>

    init {
        val localDb = Room.databaseBuilder(application, LocalDatabase::class.java,"localdb").build()
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