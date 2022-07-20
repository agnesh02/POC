package repository

import main.SideMenuActivity
import models.UserData
import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import authentication.AuthenticationActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import models.database.Database
import models.database.LoginData

@OptIn(DelicateCoroutinesApi::class)
class AuthenticationRepository {

    private lateinit var auth: FirebaseAuth
    private var firebaseUser: FirebaseUser?=null
    var user: MutableLiveData<String> = MutableLiveData()
    var email: MutableLiveData<String> = MutableLiveData()
    private var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    var loginStatus: MutableLiveData<Boolean> = MutableLiveData()
    var liveRepoMessage: MutableLiveData<String> = MutableLiveData()

    init {
        GlobalScope.launch(Dispatchers.Default) {
            auth = FirebaseAuth.getInstance()
            while (firebaseUser==null)
            {
                firebaseUser = auth.currentUser
            }
        }
    }

    fun getUser() {

        GlobalScope.launch {
            user.postValue(firebaseUser?.displayName)
            email.postValue(firebaseUser?.email)
        }
    }

    fun registerUser(username: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    updateProfile(email)
                    updateUsername(username)
                } else {
                    liveRepoMessage.value = it.exception?.message
                    return@addOnCompleteListener
                }
            }
            .addOnFailureListener {
                liveRepoMessage.value = it.message
                return@addOnFailureListener
            }
    }

    fun updateUsername(username: String) {
        val profileChangeRequest: UserProfileChangeRequest = UserProfileChangeRequest.Builder()
            .setDisplayName(username)
            .build()

        firebaseUser?.updateProfile(profileChangeRequest)
            ?.addOnCompleteListener {
                if (it.isSuccessful) {
                    liveRepoMessage.value = "User registered successfully"
                } else {
                    liveRepoMessage.value = it.exception?.message
                    return@addOnCompleteListener
                }
            }
            ?.addOnFailureListener {
                liveRepoMessage.value = it.message
                return@addOnFailureListener
            }
    }

    private fun updateProfile(email: String) {
        val userData = UserData("", "", "", "")

        firestore.collection("USERS").document(email)
            .set(userData)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    //
                } else {
                    liveRepoMessage.value = it.exception?.message
                    return@addOnCompleteListener
                }
            }
            .addOnFailureListener {
                liveRepoMessage.value = it.message
                return@addOnFailureListener
            }
    }

    fun loginUser(application: Application, email: String, password: String, save: Boolean) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {

                    if(save)
                    {
                        GlobalScope.launch(Dispatchers.Default) {
                            val db = Room.databaseBuilder(application.applicationContext,Database::class.java,"userdb").build()
                            val loginDataObj = LoginData(1,true)
                            db.accessDao().putData(loginDataObj)
                        }
                    }

                    val i = Intent(application.applicationContext, SideMenuActivity::class.java)
                    i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(application.applicationContext, i, Bundle())
                    loginStatus.value = true

                } else {
                    liveRepoMessage.value = it.exception?.message
                    loginStatus.value = false
                    return@addOnCompleteListener
                }
            }
            .addOnFailureListener {
                liveRepoMessage.value = it.message
                loginStatus.value = false
                return@addOnFailureListener
            }
    }

    fun resetPassword(email: String) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    liveRepoMessage.value =
                        "Password reset link has been sent to the provided email address"
                } else {
                    liveRepoMessage.value = it.exception?.message
                    return@addOnCompleteListener
                }
            }
            .addOnFailureListener {
                liveRepoMessage.value = it.message
                return@addOnFailureListener
            }
    }

    fun logoutUser(application: Application) {
        auth.signOut()
        GlobalScope.launch {
            val db = Room.databaseBuilder(application.applicationContext,Database::class.java,"userdb").build()
            db.accessDao().deleteData()
        }
        val i = Intent(application.applicationContext, AuthenticationActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        i.putExtra("STATUS",false)
        startActivity(application.applicationContext, i, Bundle())

    }

}