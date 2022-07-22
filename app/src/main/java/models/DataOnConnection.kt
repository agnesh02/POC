package models

import android.bluetooth.BluetoothDevice

data class DataOnConnection(
    var fragmentChangeStatus: Boolean?=null,
    var deviceName: String?=null,
    var deviceAddress: String?=null,
    var device: BluetoothDevice?=null
)
