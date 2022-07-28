package com.example.bcsd_weather.util

import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import android.util.Log
import com.google.android.gms.location.*

@SuppressLint("MissingPermission")
class GPSClient {
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var onGPSUpdate: OnGPSUpdate

    private val locationRequest = LocationRequest.create().apply {
        interval = 10000
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            for (location in locationResult.locations) {
                onGPSUpdate.updateGPS(location.latitude, location.longitude)
                break
            }
        }
    }

    fun initGPS(context: Context) {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
        val client = LocationServices.getSettingsClient(context)
        val task = client.checkLocationSettings(builder.build())

        task.addOnSuccessListener {
            Log.d("Test", "location client setting success")
        }

        task.addOnFailureListener {
            Log.d("Test", "location client setting failure")
        }

        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location ->
                if (location == null)
                    Log.d("Test", "location is null!")
            }
    }

    fun requestGPS() {
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    interface OnGPSUpdate {
        fun updateGPS(latitude: Double, longitude: Double)
    }

    inline fun setOnGPSUpdate(crossinline item: (Double, Double) -> Unit) {
        this.onGPSUpdate = object : OnGPSUpdate {
            override fun updateGPS(latitude: Double, longitude: Double) {
                item(latitude, longitude)
            }
        }
    }
}