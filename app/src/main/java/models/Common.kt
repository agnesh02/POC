package models

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.ImageView
import android.widget.Toast
import com.example.poc.R
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

object Common {

    fun setUpLogger()
    {
        Logger.addLogAdapter(AndroidLogAdapter())
    }
    fun clearUpLogger()
    {
        Logger.clearLogAdapters()
    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                return true
            }
        }
        return false
    }

    fun setDrawables(imageView: ImageView, desc: String) {
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
        if (desc == "shower rain" || desc == "high intensity rain") {
            imageView.setImageResource(R.drawable.shower_rain)
        }
        if (desc == "rain" || desc == "light rain" || desc == "moderate rain") {
            imageView.setImageResource(R.drawable.rain)
        }
        if (desc.contains("thunderstorm")) {
            imageView.setImageResource(R.drawable.thunderstorm)
        }
        if (desc.contains("snow")) {
            imageView.setImageResource(R.drawable.snow)
        }
        if (desc == "mist") {
            imageView.setImageResource(R.drawable.mist)
        }
        if (desc == "haze") {
            imageView.setImageResource(R.drawable.haze)
        }
        if (desc == "fog") {
            imageView.setImageResource(R.drawable.fog)
        }
        if (desc == "drizzle") {
            imageView.setImageResource(R.drawable.drizzle)
        }

    }

    fun setTempDrawables(imageView: ImageView, temp: Int) {
        if (temp <= 25) {
            imageView.setImageResource(R.drawable.cold)
        } else {
            imageView.setImageResource(R.drawable.hot)
        }

    }

    fun toast(context: Context, msg: String)
    {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

}