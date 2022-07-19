package ble

import android.app.Application
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import quevedo.soares.leandro.blemadeeasy.BLE

class BleViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var bluetoothManager: BluetoothManager
    private lateinit var bluetoothAdapter: BluetoothAdapter
    private lateinit var bluetoothLeScanner: BluetoothLeScanner
    var buttonText:MutableLiveData<String> = MutableLiveData("start scanning")
    var liveDevicesList: MutableLiveData<ArrayList<BluetoothDevice>> = MutableLiveData()
    var deviceList: ArrayList<BluetoothDevice> = ArrayList()

    private fun requestPermission(ble: BLE)
    {
        GlobalScope.launch {
            val granted = ble.verifyPermissions(rationaleRequestCallback = { next ->
                next()
            })

            if (granted) {
                Log.d("BLE","Permission granted")
                checkBleAdapterState(ble)
            } else {
                Log.d("BLE","Permission denied, permission is required for the functionality")
            }
        }

    }

    private fun checkBleAdapterState(ble: BLE)
    {
        GlobalScope.launch {
            if (ble.verifyBluetoothAdapterState()) {
                Log.d("BLE","Bluetooth turned on")
                checkLocationPermission(ble)
            } else {
                Log.d("BLE","Turn on bluetooth")
            }
        }
    }

    private fun checkLocationPermission(ble: BLE)
    {
        GlobalScope.launch {
            if (ble.verifyLocationState()) {
                Log.d("BLE","Location turned on")
                delay(5000)
                initializeBLE()
            } else {
                Log.d("BLE","Turn on location")
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
        Log.d("button text",buttonText.value.toString())

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
                Log.d("DEVICE",result.device.toString())
                deviceList.add(result.device);
            }

            liveDevicesList.postValue(deviceList)
        }
    }

    private fun startScanning() {
        GlobalScope.launch {
            deviceList.clear()
            bluetoothLeScanner.startScan(leScanCallback)
        }
    }

    private fun stopScanning() {
        GlobalScope.launch {
            bluetoothLeScanner.stopScan(leScanCallback)
        }
    }



}