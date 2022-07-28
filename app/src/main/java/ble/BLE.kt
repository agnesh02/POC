package ble

import android.app.Application
import android.bluetooth.BluetoothGatt
import androidx.lifecycle.MutableLiveData
import com.clj.fastble.BleManager
import com.clj.fastble.callback.*
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.orhanobut.logger.Logger
import java.nio.charset.StandardCharsets


object BLE {

    private val ble: BleManager = BleManager.getInstance()
    private var deviceList: ArrayList<BleDevice> = ArrayList()
    var bleLiveDeviceList: MutableLiveData<ArrayList<BleDevice>> = MutableLiveData()
    var scanStatus: MutableLiveData<Boolean> = MutableLiveData()
    var connectionStatus: MutableLiveData<Int> = MutableLiveData()
    var selectedDevice: MutableLiveData<BleDevice> = MutableLiveData()
    var availableGatt: ArrayList<String> = ArrayList()
    var requestQueueStatus: MutableLiveData<Boolean> = MutableLiveData(true)
    var strData: String = "Perform an operation"

    enum class CONNECTIVITY(var flag: Int){
        ATTEMPT(0),
        FAILED(1),
        SUCCESS(2),
        LOST(3),
        DISCONNECT(4)
    }

    fun initiate(application: Application) {
        ble.init(application)
    }

    fun checkBleSupport(): Boolean {
        if (ble.isSupportBle) {
            Logger.i("BLE is supported")
            ble.enableBluetooth()
            return ble.isBlueEnable
        } else
        {
            Logger.e("BLE is not supported")
            return false
        }
    }

    fun startScan() {
        scanStatus.postValue(true)
        deviceList.clear()
        bleLiveDeviceList.postValue(deviceList)
        ble.scan(object : BleScanCallback() {
            override fun onScanStarted(success: Boolean) {
                scanStatus.postValue(true)
                Logger.d("Scan started : $success")
            }

            override fun onScanning(bleDevice: BleDevice?) {}

            override fun onScanFinished(scanResultList: MutableList<BleDevice>?) {
                for (scanResult in scanResultList!!) {
                    deviceList.add(scanResult)
                }
                bleLiveDeviceList.postValue(deviceList)
                scanStatus.postValue(false)
            }
        })
    }

    fun connect(device: BleDevice) {
        selectedDevice.postValue(device)

        ble.connect(device, object : BleGattCallback() {
            override fun onStartConnect() {
                //connectionStatus.postValue("trying to connect")
                connectionStatus.postValue(CONNECTIVITY.ATTEMPT.flag)
                Logger.i("Trying to connect to ${device.device}")
            }

            override fun onConnectFail(bleDevice: BleDevice, exception: BleException) {
                //connectionStatus.postValue("connection failed")
                connectionStatus.postValue(CONNECTIVITY.FAILED.flag)
                Logger.e("Connection failed")
            }

            override fun onConnectSuccess(bleDevice: BleDevice, gatt: BluetoothGatt, status: Int) {
                //connectionStatus.postValue("connected")
                connectionStatus.postValue(CONNECTIVITY.SUCCESS.flag)
                Logger.i("Connected successfully")

                val availableServices = ble.getBluetoothGattServices(bleDevice)
                availableGatt.clear()
                for (service in availableServices) {
                    for (characteristics in service.characteristics) {
                        availableGatt.add(service.uuid.toString() + " : " + characteristics.uuid + "\n")
                    }
                }
                Logger.i(availableGatt.toString())
            }

            override fun onDisConnected(isActiveDisConnected: Boolean, bleDevice: BleDevice, gatt: BluetoothGatt, status: Int) {
                //connectionStatus.postValue("connection lost")
                connectionStatus.postValue(CONNECTIVITY.LOST.flag)
                Logger.e("Disconnected")
            }
        })
    }

    fun readData(bleDevice: BleDevice, uuid_service: String, uuid_characteristic_read: String) {
        requestQueueStatus.postValue(false)
        ble.read(bleDevice, uuid_service, uuid_characteristic_read, object : BleReadCallback() {
            override fun onReadSuccess(data: ByteArray) {
                requestQueueStatus.postValue(true)
                strData = String(data, StandardCharsets.UTF_8)
                Logger.i("READ DATA = $strData")
            }
            override fun onReadFailure(exception: BleException) {
                requestQueueStatus.postValue(true)
                Logger.e("Reading failed")
            }
        })
    }

    fun writeData(bleDevice: BleDevice, uuid_service: String, uuid_characteristic_write: String, data: ByteArray) {
        requestQueueStatus.postValue(false)
        ble.write(bleDevice, uuid_service, uuid_characteristic_write, data, object : BleWriteCallback() {
                override fun onWriteSuccess(current: Int, total: Int, justWrite: ByteArray) {
                    requestQueueStatus.postValue(true)
                    Logger.i("WRITE SUCCESSFUL")
                }
                override fun onWriteFailure(exception: BleException) {
                     requestQueueStatus.postValue(true)
                    Logger.i("WRITE FAILED")
                }
            })
    }

    fun notify(bleDevice: BleDevice, uuid_service: String, uuid_characteristic_notify: String, data: ByteArray)
    {
        requestQueueStatus.postValue(false)
        ble.notify(bleDevice, uuid_service, uuid_characteristic_notify, object : BleNotifyCallback() {
                override fun onNotifySuccess() {
                     requestQueueStatus.postValue(true)
                    Logger.i("NOTIFY SUCCESSFUL")
                }
                override fun onNotifyFailure(exception: BleException) {
                     requestQueueStatus.postValue(true)
                    Logger.i("NOTIFY SUCCESSFUL")
                }
                override fun onCharacteristicChanged(data: ByteArray) {
                     requestQueueStatus.postValue(true)
                    Logger.i("CHARACTERISTICS HAS BEEN CHANGED")
                }
            })
    }

    fun disconnect(device: BleDevice) {
        ble.disconnect(device)
        ble.destroy()
        //connectionStatus.postValue("disconnected")
        connectionStatus.postValue(CONNECTIVITY.DISCONNECT.flag)
        Logger.i("Device disconnected successfully")
    }

    fun stopScan()
    {
        ble.cancelScan()
    }


}