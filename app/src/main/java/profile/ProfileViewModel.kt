package profile

import repository.AuthenticationRepository
import repository.ProfileRepository
import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import models.Common.toast

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private var profileRepository: ProfileRepository = ProfileRepository()
    var fullName: MutableLiveData<String> = MutableLiveData()
    var dob: MutableLiveData<String> = MutableLiveData()
    var email: MutableLiveData<String> = MutableLiveData()
    var phone: MutableLiveData<String> = MutableLiveData()
    var username: MutableLiveData<String> = MutableLiveData()
    var uri: MutableLiveData<String> = MutableLiveData()
    var msg: MutableLiveData<String> = MutableLiveData()


    private fun startObservation() {
        profileRepository.liveUserData.observeForever {
            msg.postValue(it.message)
            if (it.message != "ok") {
                toast(getApplication(), it.message.toString())
            }
        }
    }

    fun getProfileData() {
        profileRepository.getData()

        profileRepository.liveUserData.observeForever {
            this.username.postValue(it.username)
        }
        profileRepository.liveUserData.observeForever {
            this.fullName.postValue(it.fullname)
        }
        profileRepository.liveUserData.observeForever {
            this.dob.postValue(it.dob)
        }
        profileRepository.liveUserData.observeForever {
            this.email.postValue(it.email)
        }
        profileRepository.liveUserData.observeForever {
            this.phone.postValue(it.phone)
        }
        profileRepository.liveUserData.observeForever {
            this.uri.postValue(it.image_uri)
        }

        startObservation()

    }

    fun updateProfileData() {
        if (username != profileRepository.liveUserData) {
            val authenticationRepository = AuthenticationRepository()
            authenticationRepository.updateUsername(username.value.toString())
        }
        profileRepository.updateData(
            fullName.value.toString(),
            dob.value.toString(),
            phone.value.toString()
        )
        startObservation()
    }


    fun uploadProfilePicture(uri: Uri) {
        msg.postValue("in progress")
        profileRepository.updateProfilePicture(uri)
        startObservation()
    }

}