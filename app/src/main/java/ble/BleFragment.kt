package ble

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poc.databinding.FragmentBleBinding
import quevedo.soares.leandro.blemadeeasy.BLE


class BleFragment : Fragment() {

    private lateinit var binding: FragmentBleBinding
    private lateinit var viewModel: BleViewModel
    private lateinit var ble: BLE

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

            binding.recyclerViewDevices.adapter = CustomAdapterBLE(ble,it)
            binding.recyclerViewDevices.layoutManager = LinearLayoutManager(context)
            binding.recyclerViewDevices.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
            binding.recyclerViewDevices.adapter?.notifyDataSetChanged()

        }


        return binding.root
    }


}