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
import models.Common.toast
import quevedo.soares.leandro.blemadeeasy.BLE

class DeviceFragment(private val ble: BLE) : Fragment() {

    lateinit var binding: FragmentDeviceBinding
    private lateinit var viewModel: BleViewModel
    private lateinit var device: BluetoothDevice


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDeviceBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[BleViewModel::class.java]

        val bundle = this.arguments
        if(bundle != null)
        {
            binding.tvFragDeviceName.text = bundle.getString("DEVICE NAME")
            binding.tvFragDeviceAddress.text = bundle.getString("DEVICE ADDRESS")
            device = bundle.getParcelable("DEVICE")!!
        }

        viewModel.connectionStatus.observe(viewLifecycleOwner) {
            if(it=="disconnected")
            {
                toast(requireContext(), "Device disconnected successfully")

                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.nav_host_fragment_content_side_menu, BleFragment()).commit()
            }
        }

        binding.btnFragDeviceDisconnect.setOnClickListener {
            viewModel.disconnectDevice(ble,device)
        }

        binding.btnFragDeviceWriteData.setOnClickListener {
            viewModel.writeData(ble, device)
        }

        return binding.root
    }

}