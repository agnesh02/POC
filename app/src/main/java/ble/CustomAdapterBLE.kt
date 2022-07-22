package ble

import android.bluetooth.BluetoothDevice
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.poc.R
import quevedo.soares.leandro.blemadeeasy.BLE

class CustomAdapterBLE(
    private val viewModel: BleViewModel,
    private val ble: BLE,
    private val deviceList: ArrayList<BluetoothDevice>
) : RecyclerView.Adapter<CustomAdapterBLE.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_layout_ble, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var dName = deviceList[position].name?.toString()
        var dAddr = deviceList[position].address

        holder.tvName.text = dName
        holder.tvAddress.text = dAddr
        holder.connect.setOnClickListener {
            viewModel.connectDevice(ble, deviceList[position], true, dName, dAddr)
        }

    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.custom_tv_name)
        val tvAddress: TextView = view.findViewById(R.id.custom_tv_address)
        val connect: Button = view.findViewById(R.id.custom_btn_connect)
    }


}