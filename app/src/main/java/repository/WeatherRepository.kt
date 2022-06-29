package repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class WeatherRepository {

    val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    val APP_ID = "64558cdf1afc2d3a085c537c449b1770"
    val liveData: MutableLiveData<WeatherResponse> = MutableLiveData()

    fun getCurrentWeatherData(city: String, application: Application)
    {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

        val retrofitData = retrofitBuilder.sendRequest(city,APP_ID)

        retrofitData.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {

                if(!response.isSuccessful) {
                    Toast.makeText(application.applicationContext,"Some error occurred.\nTry entering a valid city / region", Toast.LENGTH_SHORT).show()
                    return
                }

                val responseBody = response.body()

                val weatherData: List<Weather> = responseBody!!.weather
                val weatherMain = weatherData.get(0)
                val weatherCondition = weatherMain.main
                val weatherDescription = weatherMain.description

                val weatherDetails = responseBody.main
                val maxTemp = (weatherDetails.temp_max-273.15).roundToInt()
                val minTemp = (weatherDetails.temp_min-273.15).roundToInt()
                val temp = (weatherDetails.temp-273.15).roundToInt()
                val feelsLike = (weatherDetails.feels_like-273.15).roundToInt()
                val humidity = weatherDetails.humidity

                val windSpeed = responseBody.wind.speed.roundToInt()

                var obj = WeatherResponse(weatherCondition,weatherDescription, windSpeed, maxTemp, minTemp, temp, feelsLike, humidity)
                liveData.postValue(obj)

                Toast.makeText(application.applicationContext,city, Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<WeatherData?>, t: Throwable) {
                Toast.makeText(application.applicationContext,t.message, Toast.LENGTH_SHORT).show()
            }
        })


    }

}


