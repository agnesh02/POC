package ble

import android.bluetooth.BluetoothDevice
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import quevedo.soares.leandro.blemadeeasy.BLE

@OptIn(DelicateCoroutinesApi::class)
object BleManager {

    var ble: BLE?=null
    var bluetoothDevice: BluetoothDevice?=null
    var connectionStatus: MutableLiveData<String> = MutableLiveData()
    var writeStatus: MutableLiveData<String> = MutableLiveData()

    fun createBleInstance(ble: BLE)
    {
        this.ble = ble
    }

    fun setDevice(device: BluetoothDevice)
    {
        this.bluetoothDevice = device
    }

    fun connectDevice()
    {
        if(bluetoothDevice == null)
        {
            connectionStatus.postValue("no device, scan again")
            return
        }

        GlobalScope.launch {
            connectionStatus.postValue("trying to connect")
            ble!!.connect(bluetoothDevice!!)?.let { connection ->
                while (!connection.isActive)
                {
                    connectDevice()
                }
                connectionStatus.postValue("connected")

                while (connection.isActive)
                {
                    //
                }
                connectionStatus.postValue("connection lost")
                cancel()
                //Log.d("CONNECTION",connection.readableCharacteristics.toString())
            }
        }
    }

    fun disconnectDevice()
    {
        GlobalScope.launch(Dispatchers.Default) {
            ble!!.connect(bluetoothDevice!!)?.let { connection ->
                connection.close()
                connectionStatus.postValue("disconnected")
            }
        }
    }

    fun writeData()
    {
        GlobalScope.launch(Dispatchers.Default) {
            ble!!.connect(bluetoothDevice!!)?.let { connection ->
                val data = "A50419" + Integer.toHexString((System.currentTimeMillis() / 1000).toInt())
                val value = connection.write("f000ee07-0451-4000-b000-000000000000", data)

                if(value)
                    writeStatus.postValue("write successful")
                else
                    writeStatus.postValue("write failed")

            }
        }
//        Log.e("ble write", "response:  "+value)
//        Log.d("CON", connection.readableCharacteristics.toString())
//        val readValue = connection.read("f000ee03-0451-4000-b000-000000000000")
//        val values = connection.write("f000ee07-0451-4000-b000-000000000000", "A50014")
//        for(service in connection.services)
//            for(chara in service.characteristics)
//                Log.d("SERVICE :  $service","CHARA:   "+chara.uuid.toString())
    }


}