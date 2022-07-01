package weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.poc.R
import com.example.poc.databinding.FragmentWeatherBinding

class WeatherFragment : Fragment() {

    lateinit var binding: FragmentWeatherBinding
    lateinit var viewModel: WeatherViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentWeatherBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val appCompatActivity: AppCompatActivity = activity as AppCompatActivity
        val actionBar: ActionBar = appCompatActivity.supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.title = "Weather"

        binding.searchView.setAdapter(viewModel.cityAdapter)

        viewModel.liveWeatherData.observe(viewLifecycleOwner) {

            binding.tvWeatherDescription.text = it.weatherDescription
            binding.tvWeatherCondition.text = it.weatherCondition
            binding.tvMaxTemp.text = "Max : ${it.maxTemp} °C"
            binding.tvMinTemp.text = "Min : ${it.minTemp} °C"
            binding.tvTemp.text = "${it.temp} °C"
            binding.tvFeelsLike.text = "Feels like : ${it.feelsLike} °C"
            binding.tvHumidity.text = "Humidity : ${it.humidity}%"
            binding.tvWindSpeed.text = "${it.windSpeed} m/s"

            setDrawables(it.temp, it.weatherDescription)

        }

        return binding.root
    }

    private fun setDrawables(temp: Int, desc: String)
    {
        if (temp <= 25) {
            binding.temperatureImg.setImageResource(R.drawable.cold)
        } else {
            binding.temperatureImg.setImageResource(R.drawable.hot)
        }

        if (desc == "clear sky") {
            binding.weatherConditionImage.setImageResource(R.drawable.clear_sky)
        }
        if (desc == "few clouds") {
            binding.weatherConditionImage.setImageResource(R.drawable.few_clouds)
        }
        if (desc == "scattered clouds") {
            binding.weatherConditionImage.setImageResource(R.drawable.scattered_clouds)
        }
        if (desc == "broken clouds" || desc == "overcast clouds") {
            binding.weatherConditionImage.setImageResource(R.drawable.broken_clouds)
        }
        if (desc == "shower rain") {
            binding.weatherConditionImage.setImageResource(R.drawable.shower_rain)
        }
        if (desc == "rain" || desc == "light rain" || desc == "moderate rain") {
            binding.weatherConditionImage.setImageResource(R.drawable.rain)
        }
        if (desc == "thunderstorm") {
            binding.weatherConditionImage.setImageResource(R.drawable.thunderstorm)
        }
        if (desc == "snow") {
            binding.weatherConditionImage.setImageResource(R.drawable.snow)
        }
        if (desc == "mist") {
            binding.weatherConditionImage.setImageResource(R.drawable.mist)
        }

        binding.progressBarWeather.visibility = View.INVISIBLE

    }


}