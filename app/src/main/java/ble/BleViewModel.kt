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

    var upOnConnection: MutableLiveData<DataOnConnection> = MutableLiveData()
    var connectionStatus: MutableLiveData<String> = MutableLiveData()

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

            liveDevicesList.postValue(deviceList)
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
        }
    }

    fun connectDevice(ble: BLE, device: BluetoothDevice, status: Boolean, dName: String?, dAddr: String)
    {
        connectionStatus.postValue("trying to connect")
        viewModelScope.launch(Dispatchers.Default) {
            ble.connect(device)?.let { connection ->
                while(!connection.isActive) {
                    connectDevice(ble, device, status, dName, dAddr)
                }
                connectionStatus.postValue("connected")
                //Log.d("CONNECTION",connection.readableCharacteristics.toString())
                onConnection(status, device, dName, dAddr)
            }
        }
    }


    private fun onConnection(status: Boolean, device: BluetoothDevice, dName: String?, dAddr: String)
    {
        val obj = DataOnConnection()
        obj.fragmentChangeStatus = status
        obj.device = device
        obj.deviceName = dName
        obj.deviceAddress = dAddr

        upOnConnection.postValue(obj)
    }

    fun disconnectDevice(ble: BLE, device: BluetoothDevice)
    {
        viewModelScope.launch(Dispatchers.Default) {
            ble.connect(device)?.let { connection ->
                connection.close()
                connectionStatus.postValue("disconnected")
            }
        }
    }

    fun writeData(ble: BLE, device: BluetoothDevice) {
        viewModelScope.launch(Dispatchers.Default) {
            ble.connect(device)?.let { connection ->
                val data = "A50419" + Integer.toHexString((System.currentTimeMillis() / 1000).toInt())
                val value = connection.write("f000ee07-0451-4000-b000-000000000000", data)
                Handler(Looper.getMainLooper()).postDelayed({
                    toast(getApplication(), value.toString())
                }, 1000)
            }
        }

//                Log.e("ble write", "response:  "+value)
//                Log.d("CON", connection.readableCharacteristics.toString())
//                val readValue = connection.read("f000ee03-0451-4000-b000-000000000000")
//                val values = connection.write("f000ee07-0451-4000-b000-000000000000", "A50014")
//                for(service in connection.services)
//                    for(chara in service.characteristics)
//                        Log.d("SERVICE :  $service","CHARA:   "+chara.uuid.toString())
    }


}