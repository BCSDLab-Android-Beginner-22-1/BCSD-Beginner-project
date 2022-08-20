package com.example.bcsd_weather.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.bcsd_weather.data.model.TempEntity

@Dao
interface TempDao {
    @Query("SELECT * FROM tempDataTable")
    fun getAllTempData():List<TempEntity>

    @Insert
    fun insertTempData(localWeatherEntity: TempEntity)

    @Delete
    fun deleteTempData(localWeatherEntity: TempEntity)

    @Query("SELECT * FROM tempDataTable where CAST(date AS INTEGER) >= CAST(:findDate AS INTEGER )")
    fun getTempData(findDate : String):List<TempEntity>
}