package weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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


        viewModel.liveWeatherData.observe(viewLifecycleOwner, Observer {

            binding.tvWeatherDescription.text = it.weatherDescription
            binding.tvWeatherCondition.text = it.weatherCondition
            binding.tvMaxTemp.text = "Max : ${it.maxTemp} °C"
            binding.tvMinTemp.text = "Min : ${it.minTemp} °C"
            binding.tvTemp.text = "${it.temp} °C"
            binding.tvFeelsLike.text = "Feels like : ${it.feelsLike} °C"
            binding.tvHumidity.text = "Humidity : ${it.humidity}%"
            binding.tvWindSpeed.text = "${it.windSpeed} m/s"

        })

        return binding.root
    }


}