package repository

import androidx.lifecycle.MutableLiveData
import models.Main
import models.RetrofitInterface
import models.Weather
import models.WeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {

    val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    val APP_ID = "64558cdf1afc2d3a085c537c449b1770"
    val liveData: MutableLiveData<Weather> = MutableLiveData()
    val liveDetails: MutableLiveData<Main> = MutableLiveData()

    fun getCurrentWeatherData(city: String)
    {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

        val retrofitData = retrofitBuilder.sendRequest(city,APP_ID)

        retrofitData.enqueue(object : Callback<WeatherData?> {
            override fun onResponse(call: Call<WeatherData?>, response: Response<WeatherData?>) {

                val responseBody = response.body()!!
                val weatherData: List<Weather> = responseBody.weather
                val weatherMain = weatherData.get(0)
                val weatherDetails = responseBody.main
                val weatherCondition = weatherMain.main
                val weatherDescription = weatherMain.description

                var obj = Weather(weatherDescription,"",0,weatherCondition)
                liveData.postValue(obj)
                liveDetails.postValue(weatherDetails)

            }

            override fun onFailure(call: Call<WeatherData?>, t: Throwable) {

            }
        })


    }

}


