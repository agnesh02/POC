package models.weather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET(value = "weather")
    fun sendRequestForCurrent(@Query("q")city:String, @Query("appid")appID: String): Call<WeatherData>

    @GET(value = "forecast")
    fun sendRequestForForecast(@Query("q")city: String, @Query("appid")appID: String): Call<ForecastData>

}