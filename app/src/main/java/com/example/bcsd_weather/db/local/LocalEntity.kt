package com.example.bcsd_weather.db.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "localDataTable")
data class LocalEntity(
    @PrimaryKey val id : Int,
    val firstLocalName: String,
    val secondLocalName: String,
    val thirdLocalName: String,
    val x:Int,
    val y:Int
)
