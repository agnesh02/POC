package weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.poc.databinding.FragmentWeatherBinding
import kotlin.math.roundToInt

class WeatherFragment : Fragment() {

    lateinit var binding: FragmentWeatherBinding
    lateinit var viewModel: WeatherViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWeatherBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val appCompatActivity: AppCompatActivity = activity as AppCompatActivity
        var actionBar: ActionBar = appCompatActivity.supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.title = "Weather"

        binding.searchView.setAdapter(viewModel.cityAdapter)

        binding.btnWeatherGo.setOnClickListener {
            viewModel.fetchWeatherData(binding.searchView.text.toString())
        }

        viewModel.liveWeatherData.observe(viewLifecycleOwner, Observer {
            binding.tvWeatherDescription.text = it.description
            binding.tvWeatherCondition.text = it.main
        })

        viewModel.liveWeatherDetails.observe(viewLifecycleOwner, Observer {

            binding.tvMaxTemp.text = "Max : ${(it.temp_max-273.15).roundToInt()} °C"
            binding.tvMinTemp.text = "Min : ${(it.temp_min-273.15).roundToInt()} °C"
            binding.tvTemp.text = "${(it.temp-273.15).roundToInt()} °C"
            binding.tvFeelsLike.text = "Feels like : ${(it.feels_like-273.15).roundToInt()} °C"
            binding.tvHumidity.text = "Humidity : ${it.humidity}%"
        })

        //tv_wind_speed.setText(wind_speed.toString() + "m/s")



        return binding.root
    }


}