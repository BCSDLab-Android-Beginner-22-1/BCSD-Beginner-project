package com.example.bcsd_weather.data.dao

import androidx.room.*
import com.example.bcsd_weather.data.model.LocalEntity

@Dao
interface LocalDao {
    @Query("SELECT * FROM localDataTable")
    fun getAllLocalData(): List<LocalEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertLocalData(localEntity: LocalEntity)

    @Delete
    fun deleteLocalData(localEntity: LocalEntity)
}