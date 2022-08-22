package com.example.bcsd_weather.data.dao

import androidx.room.*
import com.example.bcsd_weather.data.model.TempEntity

@Dao
interface TempDao {
    @Query("SELECT * FROM tempDataTable where x = :x and y = :y")
    fun getAllTempData(x: Int, y: Int):List<TempEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTempData(localWeatherEntity: TempEntity)

    @Delete
    fun deleteTempData(localWeatherEntity: TempEntity)

    @Query("SELECT * FROM tempDataTable where CAST(date AS INTEGER) >= CAST(:findDate AS INTEGER ) and x = :x and y = :y")
    fun getTempData(findDate : String, x: Int, y: Int):List<TempEntity>
}