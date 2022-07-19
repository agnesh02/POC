package main

import repository.AuthenticationRepository
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import models.Common.toast

class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    var uname: MutableLiveData<String> = MutableLiveData()
    var email: MutableLiveData<String> = MutableLiveData()
    private var authenticationRepository: AuthenticationRepository = AuthenticationRepository()

    fun getUser() {
        authenticationRepository.getUser()
        authenticationRepository.user.observeForever {
            uname.postValue(it)
        }
        authenticationRepository.email.observeForever {
            email.postValue(it)
        }
    }

    fun performLogout() {
        authenticationRepository.logoutUser(getApplication())
    }


}
