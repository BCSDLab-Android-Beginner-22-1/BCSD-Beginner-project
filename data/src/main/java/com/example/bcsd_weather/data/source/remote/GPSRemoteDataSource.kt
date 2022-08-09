package com.example.bcsd_weather.data.source.remote

import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import com.example.bcsd_weather.data.model.GPSRemote
import com.google.android.gms.location.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@SuppressLint("MissingPermission")
class GPSRemoteDataSource(private val context: Context) {
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private lateinit var currentLocation: GPSRemote

    private val locationRequest = LocationRequest.create().apply {
        interval = 1000
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            for (location in locationResult.locations) {
                currentLocation = GPSRemote(location.latitude, location.longitude)
                break
            }
        }
    }

    suspend fun initGPS(): Flow<Boolean> {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
        val client = LocationServices.getSettingsClient(context)
        val task = client.checkLocationSettings(builder.build())

        var isInitialized = false

        task.addOnSuccessListener {
            isInitialized = true
            println("location client setting success")
        }

        task.addOnFailureListener {
            println("location client setting failure")
        }

        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location ->
                if (location == null)
                    println("location is null!")
                else
                    currentLocation = GPSRemote(location.latitude, location.longitude)
            }

        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
        return flow {
            while (true) {
                emit(isInitialized)
                if (isInitialized)
                    break
                delay(1000)
            }
        }
    }

    fun getGPS(): GPSRemote {
        return currentLocation
    }
}