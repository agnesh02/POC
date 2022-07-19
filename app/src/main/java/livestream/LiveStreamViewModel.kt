package livestream

import android.app.Application
import android.os.Environment
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.net.URL
import java.net.URLConnection

class LiveStreamViewModel(application: Application) : AndroidViewModel(application) {

    private var scheme = "http://"
    var ip: String = ""
    var port: String = ""
    var path: String = ""
    var url: String = ""
    var msg:MutableLiveData<String> = MutableLiveData()

    companion object {
        const val TIMEOUT_CONNECTION = 5000//5sec
        const val TIMEOUT_SOCKET = 30000//30sec
    }

    fun validate()
    {
        if(path=="" || path.isEmpty())
            msg.postValue("Enter a valid PATH")
        if(port=="" || port.isEmpty())
            msg.postValue("Enter a valid PORT")
        if(ip=="" || ip.isEmpty())
            msg.postValue("Enter a valid IP")

        else
        {
            url = "$scheme$ip:$port/$path"
            if(!android.util.Patterns.WEB_URL.matcher(url).matches())
                msg.postValue("Check if all the fields are valid")
            else
                msg.postValue("Loaded successfully")
        }
    }

    fun startRecording(url: String)
    {
        val startTime = System.currentTimeMillis()
        val urlLink = URL(url)
        viewModelScope.launch(Dispatchers.IO) {
            record(urlLink, startTime)
        }

    }

    private fun record(url: URL, startTime:Long)
    {
        val urlConnection: URLConnection = url.openConnection()
        urlConnection.readTimeout = TIMEOUT_CONNECTION
        urlConnection.connectTimeout = TIMEOUT_SOCKET

        try {
            val inputStream = urlConnection.getInputStream()
            val inStream = BufferedInputStream(inputStream, 1024 * 5)
            val outStream = FileOutputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/reclive2.mp4")
            val buff = ByteArray(1024 * 5)
            //Read bytes (and store them) until there is nothing more to read(-1)
            var len: Int?
            while ((inStream.read(buff).also { len = it }) != -1) {
                outStream.write(buff, 0, len!!)
            }

            outStream.flush()
            outStream.close()
            inStream.close()
            msg.postValue("completed in " + ((System.currentTimeMillis() - startTime) / 1000) + " sec")
        }
        catch (e: Exception)
        {
            msg.postValue(e.message)
        }


    }




}
