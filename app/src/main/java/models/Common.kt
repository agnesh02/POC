package models

import android.view.View
import android.widget.ImageView
import com.example.poc.R

object Common {

    fun setDrawables(imageView: ImageView, desc: String)
    {
        if (desc == "clear sky") {
            imageView.setImageResource(R.drawable.clear_sky)
        }
        if (desc == "few clouds") {
            imageView.setImageResource(R.drawable.few_clouds)
        }
        if (desc == "scattered clouds") {
            imageView.setImageResource(R.drawable.scattered_clouds)
        }
        if (desc == "broken clouds" || desc == "overcast clouds") {
            imageView.setImageResource(R.drawable.broken_clouds)
        }
        if (desc == "shower rain") {
            imageView.setImageResource(R.drawable.shower_rain)
        }
        if (desc == "rain" || desc == "light rain" || desc == "moderate rain") {
            imageView.setImageResource(R.drawable.rain)
        }
        if (desc == "thunderstorm") {
            imageView.setImageResource(R.drawable.thunderstorm)
        }
        if (desc == "snow") {
            imageView.setImageResource(R.drawable.snow)
        }
        if (desc == "mist") {
            imageView.setImageResource(R.drawable.mist)
        }

    }

    fun setTempDrawables(imageView: ImageView, temp: Int)
    {
        if (temp <= 25) {
            imageView.setImageResource(R.drawable.cold)
        } else {
            imageView.setImageResource(R.drawable.hot)
        }

    }

}