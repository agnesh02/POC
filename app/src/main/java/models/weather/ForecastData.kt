package models.weather

data class ForecastData(
    val cnt: Int,
    val cod: String,
    val list: List<Forecast>,
    val message: Int
)