package models

data class WeatherResponse(
    val weatherCondition: String,
    val weatherDescription: String,
    val windSpeed: Int,
    val maxTemp: Int,
    val minTemp: Int,
    val temp: Int,
    val feelsLike: Int,
    val humidity: Int
)
