package ble

import android.bluetooth.BluetoothDevice
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.poc.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import quevedo.soares.leandro.blemadeeasy.BLE

class CustomAdapterBLE(private val ble:BLE, private val deviceList: ArrayList<BluetoothDevice>) : RecyclerView.Adapter<CustomAdapterBLE.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_layout_ble, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = deviceList[position].name?.toString()
        holder.tvAddress.text = deviceList[position].address
        holder.connect.setOnClickListener(View.OnClickListener {
            connectDevice(ble,deviceList[position])
        })

    }

    override fun getItemCount(): Int {
        return deviceList.size
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val tvName: TextView = view.findViewById(R.id.custom_tv_name)
        val tvAddress: TextView = view.findViewById(R.id.custom_tv_address)
        val connect: Button = view.findViewById(R.id.custom_btn_connect)
    }

    private fun connectDevice(ble: BLE, device: BluetoothDevice)
    {
        GlobalScope.launch {

//            ble.connect(device)?.let { connection ->
//
//                Log.d("CON", connection.readableCharacteristics.toString())
//                val value = connection.read("00002a00-0000-1000-8000-00805f9b34fb")
//                Log.d("CON", value.toString())
//                //connection.write("00000000-0000-0000-0000-000000000000", "0")
//                //connection.close()
//
//            }

            ble.connect(device)?.let { connection ->

                Log.d("CON", connection.readableCharacteristics.toString())
                // For watching bytes
                connection.observe(characteristic = "00002a00-0000-1000-8000-00805f9b34fb") { value: ByteArray ->
                    // This will run everytime the characteristic changes it's value
                    Log.d("CON", value.toString())
                }

                // For watching strings
                connection.observeString(characteristic = "00002a00-0000-1000-8000-00805f9b34fb", charset = Charsets.UTF_8) { value: String ->
                    // This will run everytime the characteristic changes it's value
                    Log.d("CON", value)
                }
            }

        }

    }
}