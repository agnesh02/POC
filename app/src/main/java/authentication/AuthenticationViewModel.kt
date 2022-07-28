package authentication

import repository.AuthenticationRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import models.Common.toast
import models.database.Database

class AuthenticationViewModel(application: Application) : AndroidViewModel(application) {

    var etUsername: String = ""
    var etEmail: String = ""
    var etPass: String = ""
    var etConfirmPass: String = ""
    var checkBoxStatus: Boolean = false
    private var emailRegex: String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    var errorCode: MutableLiveData<Int> = MutableLiveData()
    private var db: Database? =null
    var dbData: MutableLiveData<Boolean> = MutableLiveData()

    private var authenticationRepository: AuthenticationRepository = AuthenticationRepository()
    private var msgReceived: String = ""
    var loginStatus: MutableLiveData<Boolean> = MutableLiveData()
    var pBarVisibility: MutableLiveData<Boolean> = MutableLiveData(false)


    fun checkForLogin()
    {
        viewModelScope.launch(Dispatchers.Default) {
            db = Room.databaseBuilder(getApplication(), Database::class.java, "userdb").build()
            dbData.postValue(db?.accessDao()!!.getData())
        }
    }

    private fun startObservation() {
        authenticationRepository.liveRepoMessage.observeForever {
            if (it != msgReceived) //to avoid repeated messages which might result in unmatched response
                toast(getApplication(), it)
            msgReceived = it
            pBarVisibility.postValue(false)
        }

        authenticationRepository.loginStatus.observeForever {
            loginStatus.postValue(it)
        }
    }

    fun onRegister() {
        pBarVisibility.postValue(true)

        etUsername = etUsername.trim()
        etEmail = etEmail.trim()
        etPass = etPass.trim()

        if (!validateUsername(etUsername)) {
            errorCode.value = 1
            return
        }
        if (!validateEmail(etEmail)) {
            errorCode.value = 2
            return
        }
        if (!validatePassword(etPass)) {
            errorCode.value = 3
            return
        }
        if (!comparePassword(etPass, etConfirmPass)) {
            errorCode.value = 4
            return
        }

        errorCode.value = 0
        authenticationRepository.registerUser(etUsername, etEmail, etPass)

        startObservation()

    }

    fun onLogin() {

        etEmail = etEmail.trim()
        etPass = etPass.trim()

        if (!validateEmail(etEmail)) {
            errorCode.value = 2
            return
        }
        if (!validatePassword(etPass)) {
            errorCode.value = 3
            return
        }
        errorCode.value = 0
        pBarVisibility.postValue(true)
        authenticationRepository.loginUser(getApplication(), etEmail, etPass, checkBoxStatus)

        startObservation()

    }

    fun onResetPass() {
        etEmail = etEmail.trim()
        if (!validateEmail(etEmail)) {
            errorCode.value = 2
            return
        }
        errorCode.value = 0
        authenticationRepository.resetPassword(etEmail)

        startObservation()
    }

    private fun validateUsername(username: String): Boolean {
        if (username.isEmpty() || username == "") {
            return false
        }
        return true
    }

    private fun validateEmail(email: String): Boolean {
        if (email.isEmpty() || email == "" || !email.matches(emailRegex.toRegex())) {
            return false
        }
        return true
    }

    private fun validatePassword(password: String): Boolean {
        if (password.isEmpty() || password == "" || password.length < 6 || password.length > 10) {
            return false
        }
        return true
    }

    private fun comparePassword(password: String, confirmPassword: String): Boolean {
        if (password != confirmPassword) {
            return false
        }
        return true
    }

}