package weather

import android.app.Application
import android.widget.ArrayAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.poc.R
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import models.Common.toast
import models.WeatherResponse
import repository.WeatherRepository
import java.util.logging.Logger

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    var cityName: String = ""
    private var citiesList: Array<String> = application.resources.getStringArray(R.array.cities)
    var cityAdapter: ArrayAdapter<String> = ArrayAdapter(application.applicationContext, android.R.layout.simple_list_item_1, citiesList)
    private var weatherRepository: WeatherRepository = WeatherRepository()
    var liveWeatherData: MutableLiveData<WeatherResponse> = MutableLiveData()
    var weatherAdapter: MutableLiveData<WeatherAdapter> = MutableLiveData()
    var pBarVisibility: MutableLiveData<Boolean> = MutableLiveData(false)

    private fun validate(s: String): Boolean {
        pBarVisibility.postValue(true)
        if (s.isEmpty())
            return false
        return true
    }

    fun fetchWeatherData() {

        if (!validate(cityName)) {
            toast(getApplication(), "Enter a valid city or region")
            return
        }

        viewModelScope.launch {
            weatherRepository.getWeatherData(cityName.trim(), getApplication())
        }

        weatherRepository.liveData.observeForever {
            liveWeatherData.postValue(it)
        }
        weatherRepository.liveForecastList.observeForever {
            weatherAdapter.postValue(WeatherAdapter(it))
            if(it!=null)
                pBarVisibility.postValue(false)
        }

    }

}