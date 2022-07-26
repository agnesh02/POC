package ble

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.clj.fastble.data.BleDevice
import com.example.poc.databinding.FragmentDeviceBinding

class DeviceFragment : Fragment() {

//all readable characteristics for sample smartwatch
//[00002a00-0000-1000-8000-00805f9b34fb, 00002a01-0000-1000-8000-00805f9b34fb, 00002a04-0000-1000-8000-00805f9b34fb, 00002aa6-0000-1000-8000-00805f9b34fb]

//readable: 00001800-0000-1000-8000-00805f9b34fb: 00002a00-0000-1000-8000-00805f9b34fb (device name)
//writeable: 0000f618-0000-1000-8000-00805f9b34fb: 0000b002-0000-1000-8000-00805f9b34fb

    private lateinit var binding: FragmentDeviceBinding
    private lateinit var viewModel: BleViewModel
    private lateinit var device: BleDevice

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDeviceBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[BleViewModel::class.java]

        BLE.selectedDevice.observeForever {
            device = it
        }
        binding.tvFragDeviceName.text = device.name
        binding.tvFragDeviceAddress.text = device.mac

        binding.btnFragDeviceReadData.setOnClickListener {
            BLE.readData(device, "00001800-0000-1000-8000-00805f9b34fb","00002a00-0000-1000-8000-00805f9b34fb")
        }

        binding.btnFragDeviceWriteData.setOnClickListener {
            //BLE.writeData
            //val data = "A50419" + Integer.toHexString((System.currentTimeMillis() / 1000).toInt())
            //val value = BLE.writeData(device,"service","f000ee07-0451-4000-b000-000000000000",data)
        }

        binding.btnFragDeviceDisconnect.setOnClickListener {
            BLE.disconnect(device)
        }


        return binding.root
    }
}