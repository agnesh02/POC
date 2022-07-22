package ble

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poc.R
import com.example.poc.databinding.FragmentBleBinding
import models.Common.toast
import quevedo.soares.leandro.blemadeeasy.BLE


class BleFragment : Fragment() {

    private lateinit var binding: FragmentBleBinding
    private lateinit var viewModel: BleViewModel
    private lateinit var ble: BLE
    private lateinit var alertDialog: AlertDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentBleBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[BleViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        ble = BLE(this)

        binding.btnScan.setOnClickListener {
            viewModel.scanState(ble)
        }

        viewModel.liveDevicesList.observe(viewLifecycleOwner) {

            binding.recyclerViewDevices.adapter = CustomAdapterBLE(viewModel,ble,it)
            binding.recyclerViewDevices.layoutManager = LinearLayoutManager(context)
            binding.recyclerViewDevices.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
            binding.recyclerViewDevices.adapter?.notifyDataSetChanged()

        }

        viewModel.connectionStatus.observe(viewLifecycleOwner) {
            if(it == "trying to connect")
            {
                val builder = AlertDialog.Builder(context!!)
                builder.setCancelable(false)
                builder.setTitle("Connecting..")
                builder.setMessage("Please wait till the connection is active")
                builder.setIcon(R.drawable.ic_baseline_bluetooth_searching_24)
                alertDialog= builder.create()
                alertDialog.show()
            }
            else{
                toast(requireContext(), "Device connected successfully")
                alertDialog.dismiss()
            }

        }

        viewModel.upOnConnection.observe(viewLifecycleOwner) {
            if(it.fragmentChangeStatus == true)
            {
                val bundle = Bundle()
                bundle.putParcelable("DEVICE",it.device)
                bundle.putString("DEVICE NAME",it.deviceName)
                bundle.putString("DEVICE ADDRESS",it.deviceAddress)
                val fragment = DeviceFragment(ble)
                fragment.arguments = bundle

                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.nav_host_fragment_content_side_menu, fragment).commit()
            }
        }


        return binding.root
    }


}