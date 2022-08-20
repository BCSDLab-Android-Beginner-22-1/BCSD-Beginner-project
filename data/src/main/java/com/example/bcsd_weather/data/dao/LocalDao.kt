package com.example.bcsd_weather.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.bcsd_weather.data.model.LocalEntity

@Dao
interface LocalDao {
    @Query("SELECT * FROM localDataTable")
    fun getAllLocalData():List<LocalEntity>

    @Insert
    fun insertLocalData(localWeatherEntity: LocalEntity)

    @Delete
    fun deleteLocalData(localWeatherEntity: LocalEntity)
}