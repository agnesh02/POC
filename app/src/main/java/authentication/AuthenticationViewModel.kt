package authentication

import repository.AuthenticationRepository
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class AuthenticationViewModel(application: Application) : AndroidViewModel(application) {

    var etUsername: String = ""
    var etEmail: String = ""
    var etPass: String = ""
    var etConfirmPass: String = ""
    var checkBoxStatus: Boolean = false
    private var emailRegex: String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    var errorCode: MutableLiveData<Int> = MutableLiveData()

    private var authenticationRepository: AuthenticationRepository = AuthenticationRepository()
    private var msg: String = ""

    private fun startObservation() {
        authenticationRepository.liveRepoMessage.observeForever {
            if (it != msg)
                Toast.makeText(getApplication(), it, Toast.LENGTH_SHORT).show()
            msg = it
        }
    }

    fun onRegister() {
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

        if (!validateEmail(etEmail)) {
            errorCode.value = 2
            return
        }
        if (!validatePassword(etPass)) {
            errorCode.value = 3
            return
        }
        errorCode.value = 0
        authenticationRepository.loginUser(getApplication(), etEmail, etPass, checkBoxStatus)

        startObservation()

    }


    fun onResetPass() {
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