package com.example.bcsd_weather.db.future.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.bcsd_weather.data.StITEM
import com.google.gson.Gson

@ProvidedTypeConverter
class StItemTypeConverter(private val gson: Gson) {

    @TypeConverter
    fun listToJson(value: StITEM): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): StITEM {
        return gson.fromJson(value, StITEM::class.java)
    }
}