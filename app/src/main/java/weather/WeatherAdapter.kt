package weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.poc.R
import models.Common
import models.WeatherResponse

class WeatherAdapter(val list: List<WeatherResponse>) : RecyclerView.Adapter<WeatherAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_weather_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvWeatherDescription.text = list[position].weatherDescription
        holder.tvMaxTemp.text =  "Max : ${list[position].maxTemp} °C"
        holder.tvFeelsLike.text = "Feels like : \n${list[position].feelsLike} °C"
        holder.tvTime.text = list[position].time

        Common.setDrawables(holder.weatherImg, list[position].weatherDescription)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvWeatherDescription:TextView = itemView.findViewById(R.id.custom_weather_card_description)
        val tvMaxTemp:TextView = itemView.findViewById(R.id.custom_weather_card_max_temp)
        val tvFeelsLike:TextView = itemView.findViewById(R.id.custom_weather_card_feels_like)
        val tvTime:TextView = itemView.findViewById(R.id.custom_weather_card_time)
        val weatherImg:ImageView = itemView.findViewById(R.id.custom_weather_image)
    }

}