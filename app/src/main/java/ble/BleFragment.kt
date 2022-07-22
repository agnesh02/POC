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
import main.DashboardFragment
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

        BleManager.createBleInstance(BLE(this))
        ble = BleManager.ble!!

        binding.btnScan.setOnClickListener {
            viewModel.scanState(ble)
        }

        viewModel.liveDevicesList.observe(viewLifecycleOwner) {

            binding.recyclerViewDevices.adapter = CustomAdapterBLE(it)
            binding.recyclerViewDevices.layoutManager = LinearLayoutManager(context)
            binding.recyclerViewDevices.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
            binding.recyclerViewDevices.adapter?.notifyDataSetChanged()

        }

        BleManager.connectionStatus.observeForever {
            when (it) {
                "trying to connect" -> {
                    val builder = AlertDialog.Builder(context!!)
                    builder.setCancelable(false)
                        .setTitle("Connecting..")
                        .setMessage("Please wait till the connection is active")
                        .setIcon(R.drawable.ic_baseline_bluetooth_searching_24)
                    alertDialog= builder.create()
                    alertDialog.show()
                }
                "connection lost" -> {
                    toast(requireContext(), it)
                    val builder = AlertDialog.Builder(context!!)
                    builder.setCancelable(false)
                        .setTitle("Connecting Lost")
                        .setMessage("Please try reconnecting")
                        .setIcon(R.drawable.ic_baseline_bluetooth_disabled_24)
                        .setPositiveButton("Reconnect") { _, _ ->
                            BleManager.connectDevice()
                        }
                        .setNegativeButton("Exit") { dialogInterface, _ ->
                            val transaction = parentFragmentManager.beginTransaction()
                            transaction.replace(R.id.nav_host_fragment_content_side_menu, DashboardFragment()).commit()
                            dialogInterface.dismiss()
                        }

                    alertDialog= builder.create()
                    alertDialog.show()
                }
                "no device, scan again" -> {
                    toast(requireContext(),it)
                }
                else -> {
                    toast(requireContext(), "Device connected successfully")
                    alertDialog.dismiss()
                    val transaction = parentFragmentManager.beginTransaction()
                    transaction.replace(R.id.nav_host_fragment_content_side_menu, DeviceFragment()).commit()

                }
            }
        }


        return binding.root
    }


}