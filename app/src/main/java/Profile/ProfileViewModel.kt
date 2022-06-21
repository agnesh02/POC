package Profile

import Repository.AuthenticationRepository
import Repository.ProfileRepository
import android.app.Application
import android.app.ProgressDialog
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class ProfileViewModel(application: Application) : AndroidViewModel(application){

    private var profileRepository: ProfileRepository = ProfileRepository()
    var full_name:MutableLiveData<String> = MutableLiveData()
    var dob:MutableLiveData<String> = MutableLiveData()
    var email:MutableLiveData<String> = MutableLiveData()
    var phone:MutableLiveData<String> = MutableLiveData()
    var username:MutableLiveData<String> = MutableLiveData()
    var uri:MutableLiveData<String> = MutableLiveData()
    var msg:MutableLiveData<String> = MutableLiveData()


    private fun startObservation()
    {
        profileRepository.liveRepoMessage.observeForever( Observer {
            msg.postValue(it)
            if(it!="ok")
            {
                Toast.makeText(getApplication(),it,Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getProfileData()
    {
        profileRepository.getData()

        profileRepository.liveUsername.observeForever(Observer {
            this.username.postValue(it)
        })
        profileRepository.liveName.observeForever(Observer {
            this.full_name.postValue(it)
        })
        profileRepository.liveDob.observeForever(Observer {
            this.dob.postValue(it)
        })
        profileRepository.liveEmail.observeForever(Observer {
            this.email.postValue(it)
        })
        profileRepository.livePhone.observeForever(Observer {
            this.phone.postValue(it)
        })
        profileRepository.liveUri.observeForever(Observer {
            this.uri.postValue(it)
        })


        startObservation()

    }

    fun updateProfileData()
    {
        if(username != profileRepository.liveUsername)
        {
            var authenticationRepository:AuthenticationRepository = AuthenticationRepository()
            authenticationRepository.updateUsername(username.value.toString())
        }
        profileRepository.updateData(full_name.value.toString(), dob.value.toString(), phone.value.toString())
        startObservation()
    }


    fun uploadProfilePicture(uri:Uri)
    {
        msg.postValue("in progress")
        profileRepository.updateProfilePicture(uri)
        startObservation()
    }

}