package com.example.bcsd_weather

import android.Manifest
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.bcsd_weather.util.OpenSettings

class MainActivity : AppCompatActivity() {

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            when (isGranted) {
                true -> getGPSLocation()
                else -> {
                    when (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                        true -> permissionDialog(true)
                        else -> permissionDialog(false)
                    }
                }

            }
        }

    private val openSettings =
        registerForActivityResult(OpenSettings()) {
            checkPermission()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()
    }

    private fun checkPermission() {
        requestPermission.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    private fun permissionDialog(isDeniedOnce: Boolean) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.dialog_request_permission_title))
            .setMessage(getString(R.string.dialog_request_permission_message))
            .setPositiveButton(getString(R.string.dialog_request_permission_ok)) { dialog, _ ->
                when (isDeniedOnce) {
                    true -> checkPermission()
                    false -> openSettings.launch(null)
                }
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.dialog_request_permission_cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
        builder.show()
    }

    private fun getGPSLocation() {

    }

}