package weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poc.R
import com.example.poc.databinding.FragmentWeatherBinding
import models.Common

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

            Common.setDrawables( binding.weatherConditionImage, it.weatherDescription)
            Common.setTempDrawables(binding.temperatureImg, it.temp)
            binding.progressBarWeather.visibility = View.INVISIBLE
        }

        viewModel.weatherAdapter.observe(viewLifecycleOwner) {

            binding.forecastRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.forecastRecyclerView.adapter = it
        }


        return binding.root
    }


}