package ble

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import models.Common.toast
import pub.devrel.easypermissions.EasyPermissions


class BleViewModel(application: Application) : AndroidViewModel(application) {

    var buttonText:MutableLiveData<String> = MutableLiveData("start scanning")
    var locationPermissionStatus: MutableLiveData<Boolean> = MutableLiveData()
    var pBarVisibility: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkScanStatus()
    {
        BLE.scanStatus.observeForever {
            if(it)
            {
                buttonText.postValue("stop scanning")
                pBarVisibility.postValue(true)
            }
            else
            {
                if(BLE.bleLiveDeviceList.value!!.isEmpty())
                    Toast.makeText(getApplication(),"No BLE devices found, try scanning again", Toast.LENGTH_SHORT).show()
                buttonText.postValue("start scanning")
                pBarVisibility.postValue(false)
            }
        }

        if(buttonText.value == "start scanning")
            initiate()
        else
            stopScanning()
    }


    private fun initiate()
    {
        BLE.initiate(getApplication())
        if(BLE.checkBleSupport())
            checkLocationPermission()
        else
            toast(getApplication(),"Bluetooth was turned off. It has been turned on now. Try scanning again")

    }

    private fun checkLocationPermission()
    {
        val hasLocationPermission = EasyPermissions.hasPermissions(getApplication(),Manifest.permission.ACCESS_COARSE_LOCATION)

        if(!hasLocationPermission)
            locationPermissionStatus.postValue(false)
        else
            checkLocationEnabled()
    }

    private fun checkLocationEnabled()
    {
        val locationManager = getApplication<Application>().getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            BLE.startScan()
        else
        {
            toast(getApplication(), "Location should be enabled to scan BLE devices. Enable GPS and try scanning again")
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(getApplication(),intent, Bundle())
        }

    }

    private fun stopScanning()
    {
        BLE.stopScan()
    }



}