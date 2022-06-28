package models

data class WeatherData(
    val base: String,
    val cod: Int,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>
)