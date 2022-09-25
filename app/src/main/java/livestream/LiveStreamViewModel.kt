package livestream

import android.app.Application
import android.os.Environment
import androidx.lifecycle.*
import com.firebase.ui.auth.AuthUI.getApplicationContext
import com.orhanobut.logger.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.net.URL
import java.net.URLConnection
import java.util.*

class LiveStreamViewModel(application: Application) : AndroidViewModel(application) {

    private var scheme = "http://"
    var ip: String = ""
    var port: String = ""
    var path: String = ""
    var url: String = ""
    var msg:MutableLiveData<String> = MutableLiveData()
    private var inStream: BufferedInputStream?=null
    private var outStream: OutputStream?=null

    companion object {
        const val TIMEOUT_CONNECTION = 5000//5sec
        const val TIMEOUT_SOCKET = 30000//30sec
    }

    fun validate()
    {
        path = path.trim()
        port = port.trim()
        ip = ip.trim()

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
        val urlLink = URL(url)
        viewModelScope.launch(Dispatchers.Default) {
            record(urlLink)
        }
    }

    private fun record(url: URL)
    {
        val urlConnection: URLConnection = url.openConnection()
        urlConnection.readTimeout = TIMEOUT_CONNECTION
        urlConnection.connectTimeout = TIMEOUT_SOCKET

        try {
            val inputStream = urlConnection.getInputStream()
            inStream = BufferedInputStream(inputStream, 1024 * 5)

            val rootPath = getApplicationContext().getExternalFilesDir("");
            Logger.d(rootPath)
            val filePath = "POC-Recordings"
            val fileName = Calendar.getInstance().time.toString()
            val folder = File(rootPath,filePath)
            if(!folder.exists())
                folder.mkdir()

            outStream = FileOutputStream(folder.toString()+"/rec-"+fileName.lowercase()+".mp4")
            val buff = ByteArray(1024 * 5)
            //Read bytes (and store them) until there is nothing more to read(-1)
            var len: Int?
            while ((inStream?.read(buff).also { len = it }) != -1) {
                outStream?.write(buff, 0, len!!)
            }
        }
        catch (e: Exception)
        {
            //msg.postValue(e.message)
        }

    }

    fun stopRecording() {
        outStream?.flush()
        outStream?.close()
        inStream?.close()
        msg.postValue("Recording stopped and saved to /storage/emulated/0/Android/data/com.example.poc/files/POC-Recordings")
    }


}
