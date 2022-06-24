package profile

import repository.AuthenticationRepository
import repository.ProfileRepository
import android.app.Application
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

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
                Toast.makeText(getApplication(), it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getProfileData() {
        profileRepository.getData()

        profileRepository.liveUserData.observeForever {
            this.username.postValue("Welcome " + it.username)
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