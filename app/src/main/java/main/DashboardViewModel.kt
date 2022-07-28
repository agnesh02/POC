package main

import repository.AuthenticationRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import repository.ProfileRepository

class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    var uname: MutableLiveData<String> = MutableLiveData()
    var email: MutableLiveData<String> = MutableLiveData()
    private var authenticationRepository: AuthenticationRepository = AuthenticationRepository()
    private var profileRepository: ProfileRepository = ProfileRepository()

    fun getUsernameAndEmail()
    {
        profileRepository.getUsernameAndEmail()
        profileRepository.liveUserData.observeForever {
            uname.postValue(it.username)
            email.postValue(it.email)
        }
    }

    fun performLogout() {
        authenticationRepository.logoutUser(getApplication())
    }


}
