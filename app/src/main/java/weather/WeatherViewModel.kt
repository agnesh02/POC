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
import repository.WeatherRepository

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    var citiesList: Array<String> = application.resources.getStringArray(R.array.cities)
    var cityAdapter: ArrayAdapter<String> = ArrayAdapter(application.applicationContext, android.R.layout.simple_list_item_1, citiesList)

    var weatherRepository: WeatherRepository = WeatherRepository()
    var liveWeatherData: MutableLiveData<Weather> = MutableLiveData()
    var liveWeatherDetails: MutableLiveData<Main> = MutableLiveData()

    fun fetchWeatherData(cityName: String)
    {
        weatherRepository.getCurrentWeatherData(cityName)

        weatherRepository.liveData.observeForever(Observer {
            liveWeatherData.postValue(it)
        })
        weatherRepository.liveDetails.observeForever(Observer {
            liveWeatherDetails.postValue(it)
            //Toast.makeText(getApplication(),it.temp.toString(),Toast.LENGTH_SHORT).show()
        })

    }


}