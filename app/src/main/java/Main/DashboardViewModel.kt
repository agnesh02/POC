package Main

import Repository.AuthenticationRepository
import android.app.Application
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class DashboardViewModel(application: Application) : AndroidViewModel(application){

    var uname:MutableLiveData<String> = MutableLiveData()
    var email:MutableLiveData<String> = MutableLiveData()
    var authenticationRepository:AuthenticationRepository = AuthenticationRepository()

    fun getUser()
    {
        authenticationRepository.getUser()
        authenticationRepository.user.observeForever(Observer {
            uname.postValue(it)
        })
        authenticationRepository.email.observeForever(Observer {
            email.postValue(it)
        })
    }

    fun performLogout() {
        authenticationRepository.logoutUser(getApplication())
    }


}
