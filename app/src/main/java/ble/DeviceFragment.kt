package ble

import android.bluetooth.BluetoothDevice
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.poc.R
import com.example.poc.databinding.FragmentDeviceBinding
import main.DashboardFragment
import models.Common.toast
import quevedo.soares.leandro.blemadeeasy.BLE

class DeviceFragment : Fragment() {

    lateinit var binding: FragmentDeviceBinding
    private lateinit var viewModel: BleViewModel
    private lateinit var device: BluetoothDevice


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDeviceBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[BleViewModel::class.java]

        device = BleManager.bluetoothDevice!!
        binding.tvFragDeviceName.text = device.name
        binding.tvFragDeviceAddress.text = device.address

        BleManager.connectionStatus.observeForever {
            if(it=="disconnected")
            {
                toast(context!!, "Device disconnected successfully")

                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.nav_host_fragment_content_side_menu, DashboardFragment()).commit()
            }
        }

        BleManager.writeStatus.observeForever {
            toast(context!!, it)
        }

        binding.btnFragDeviceDisconnect.setOnClickListener {
            BleManager.disconnectDevice()
        }

        binding.btnFragDeviceWriteData.setOnClickListener {
            BleManager.writeData()
        }

        return binding.root
    }

}