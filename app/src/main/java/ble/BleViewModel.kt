package ble

import android.app.Application
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import models.Common.toast
import models.DataOnConnection
import quevedo.soares.leandro.blemadeeasy.BLE
import java.lang.Runnable

class BleViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var bluetoothManager: BluetoothManager
    private lateinit var bluetoothAdapter: BluetoothAdapter
    private lateinit var bluetoothLeScanner: BluetoothLeScanner
    var buttonText:MutableLiveData<String> = MutableLiveData("start scanning")
    var liveDevicesList: MutableLiveData<ArrayList<BluetoothDevice>> = MutableLiveData()
    var deviceList: ArrayList<BluetoothDevice> = ArrayList()
    var pBarVisibility: MutableLiveData<Boolean> = MutableLiveData(false)


    private fun requestPermission(ble: BLE)
    {
        deviceList.clear()
        liveDevicesList.postValue(deviceList)
        pBarVisibility.postValue(true)
        viewModelScope.launch(Dispatchers.Default) {
            val granted = ble.verifyPermissions(rationaleRequestCallback = { next ->
                next()
            })

            if (granted) {
                //Log.d("BLE","Permission granted")
                checkBleAdapterState(ble)
            } else {
                Log.d("BLE","Permission denied, permission is required for the functionality")
            }
        }

    }

    private fun checkBleAdapterState(ble: BLE)
    {
        viewModelScope.launch(Dispatchers.Default) {
            if (ble.verifyBluetoothAdapterState()) {
                //Log.d("BLE","Bluetooth turned on")
                checkLocationPermission(ble)
            } else {
                //Log.d("BLE","Turn on bluetooth")
            }
        }
    }

    private fun checkLocationPermission(ble: BLE)
    {
        viewModelScope.launch(Dispatchers.Default) {
            if (ble.verifyLocationState()) {
                //Log.d("BLE","Location turned on")
                delay(5000)
                initializeBLE()
            } else {
                //Log.d("BLE","Turn on location")
            }
        }
    }

    private fun initializeBLE()
    {
        bluetoothManager = getApplication<Application>().applicationContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter
        bluetoothLeScanner = bluetoothAdapter.bluetoothLeScanner
        startScanning()
    }

    fun scanState(ble: BLE)
    {
        if(buttonText.value == "start scanning")
        {
            requestPermission(ble)
            buttonText.postValue("stop scanning")
        }
        else
        {
            stopScanning()
            buttonText.postValue("start scanning")
        }
    }

    /* Listen for scan results */
    private val leScanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult) {

            if (!deviceList.contains(result.device)){
                //Log.d("DEVICE",result.device.toString())
                deviceList.add(result.device)
            }

        }
    }

    private fun startScanning() {
        viewModelScope.launch(Dispatchers.Default) {
            bluetoothLeScanner.startScan(leScanCallback)
            Handler(Looper.getMainLooper()).postDelayed({
                stopScanning()
                buttonText.postValue("start scanning")
            },8000)
        }
    }

    private fun stopScanning() {
        viewModelScope.launch(Dispatchers.Default) {
            bluetoothLeScanner.stopScan(leScanCallback)
            pBarVisibility.postValue(false)
            liveDevicesList.postValue(deviceList)
        }
    }


}