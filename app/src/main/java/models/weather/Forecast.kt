package models.weather

data class Forecast(
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind,
    val dt_txt: String
)
