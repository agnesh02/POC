package weather

import android.app.Application
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.poc.R
import models.Main
import models.Weather
import models.WeatherResponse
import repository.WeatherRepository

class WeatherViewModel(application: Application) : AndroidViewModel(application) {


    var cityName: String = ""
    var citiesList: Array<String> = application.resources.getStringArray(R.array.cities)
    var cityAdapter: ArrayAdapter<String> = ArrayAdapter(application.applicationContext, android.R.layout.simple_list_item_1, citiesList)
    var weatherRepository: WeatherRepository = WeatherRepository()
    var liveWeatherData: MutableLiveData<WeatherResponse> = MutableLiveData()

    private fun validate(s: String): Boolean
    {
        if(s.isEmpty())
            return false
        return true
    }

    fun fetchWeatherData()
    {

        if(!validate(cityName))
        {
            Toast.makeText(getApplication(),"Enter a valid city or region", Toast.LENGTH_SHORT).show()
            return
        }

        weatherRepository.getCurrentWeatherData(cityName, getApplication())
        weatherRepository.liveData.observeForever(Observer {
            liveWeatherData.postValue(it)
        })

    }


}