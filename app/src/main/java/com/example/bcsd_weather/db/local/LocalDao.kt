package com.example.bcsd_weather.db.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LocalDao {
    @Query("SELECT * FROM localDataTable")
    suspend fun getAllLocalData():LiveData<List<LocalEntity>>

    @Insert
    suspend fun insert(localWeatherEntity: LocalEntity)

    @Query("DELETE FROM localDataTable")
    suspend fun deleteAllLocalData()
}