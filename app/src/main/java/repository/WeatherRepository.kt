package repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import models.*
import models.Common.toast
import models.weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class WeatherRepository {

    val liveData: MutableLiveData<WeatherResponse> = MutableLiveData()
    var forecastList: ArrayList<WeatherResponse> = ArrayList()
    val liveForecastList: MutableLiveData<ArrayList<WeatherResponse>> = MutableLiveData()

    fun getWeatherData(city: String, application: Application) {

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

        val retrofitDataForCurrent = retrofitBuilder.sendRequestForCurrent(city, APP_ID)
        val retrofitDataForForecast = retrofitBuilder.sendRequestForForecast(city, APP_ID)

        retrofitDataForCurrent.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {

                if (!response.isSuccessful) {
                    toast(application.applicationContext, "Some error occurred.\nTry entering a valid city / region")
                    return
                }

                val responseBody = response.body()

                val weatherData: List<Weather> = responseBody!!.weather
                val weatherMain = weatherData[0]
                val weatherCondition = weatherMain.main
                val weatherDescription = weatherMain.description

                val weatherDetails = responseBody.main
                val maxTemp = (weatherDetails.temp_max - 273.15).roundToInt()
                val minTemp = (weatherDetails.temp_min - 273.15).roundToInt()
                val temp = (weatherDetails.temp - 273.15).roundToInt()
                val feelsLike = (weatherDetails.feels_like - 273.15).roundToInt()
                val humidity = weatherDetails.humidity

                val windSpeed = responseBody.wind.speed.roundToInt()

                val obj = WeatherResponse(
                    weatherCondition,
                    weatherDescription,
                    windSpeed,
                    maxTemp,
                    minTemp,
                    temp,
                    feelsLike,
                    humidity,""
                )
                liveData.postValue(obj)

                toast(application.applicationContext, city)

            }

            override fun onFailure(call: Call<WeatherData?>, t: Throwable) {
                toast(application.applicationContext, t.message.toString())
            }
        })

        forecastList.clear()
        retrofitDataForForecast.enqueue(object : Callback<ForecastData> {
            override fun onResponse(call: Call<ForecastData>, response: Response<ForecastData>) {
//                if (!response.isSuccessful) {
//                    Toast.makeText(application.applicationContext, "Some error occurred.\nTry entering a valid city / region", Toast.LENGTH_SHORT).show()
//                    return
//                }

                for (i in 0..4)
                {

                    val responseBody = response.body()!!.list[i]

                    val weatherData: List<Weather> = responseBody.weather
                    val weatherMain = weatherData[0]
                    val weatherCondition = weatherMain.main
                    val weatherDescription = weatherMain.description

                    val weatherDetails = responseBody.main
                    val maxTemp = (weatherDetails.temp_max - 273.15).roundToInt()
                    val minTemp = (weatherDetails.temp_min - 273.15).roundToInt()
                    val temp = (weatherDetails.temp - 273.15).roundToInt()
                    val feelsLike = (weatherDetails.feels_like - 273.15).roundToInt()
                    val humidity = weatherDetails.humidity

                    val windSpeed = responseBody.wind.speed.roundToInt()
                    val timeAndDate = responseBody.dt_txt

                    val separated: List<String> = timeAndDate.split(" ")
                    val date = separated[0].split("-")
                    val hrs = separated[1].split(":")
                    val forecastTimeAndDate = date[2] + "/" + date[1] + " | " + hrs[0] + ":" + hrs[1] + "hrs"

                    val obj = WeatherResponse(
                        weatherCondition,
                        weatherDescription,
                        windSpeed,
                        maxTemp,
                        minTemp,
                        temp,
                        feelsLike,
                        humidity,
                        forecastTimeAndDate
                    )

                    forecastList.add(obj)
                }

                liveForecastList.postValue(forecastList)

            }

            override fun onFailure(call: Call<ForecastData?>, t: Throwable) {
                toast(application.applicationContext, t.message.toString())
            }
        })

    }

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        const val APP_ID = "64558cdf1afc2d3a085c537c449b1770"
    }

}


