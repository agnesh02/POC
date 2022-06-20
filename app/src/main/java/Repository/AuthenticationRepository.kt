package Repository

import Main.SideMenuActivity
import Utilities.UserData
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore

class AuthenticationRepository {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseUser:FirebaseUser = auth.currentUser!!
    private var firestore:FirebaseFirestore = FirebaseFirestore.getInstance()

    var loginStatus:MutableLiveData<Boolean> = MutableLiveData()
    var liveRepoMessage:MutableLiveData<String> = MutableLiveData()


    fun registerUser(username: String, email:String, password:String)
    {
        auth.createUserWithEmailAndPassword(email,password)
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

    fun updateUsername(username: String)
    {
        var profileChangeRequest: UserProfileChangeRequest = UserProfileChangeRequest.Builder()
            .setDisplayName(username)
            .build()

        firebaseUser.updateProfile(profileChangeRequest)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    liveRepoMessage.value = "User registered successfully"
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

    private fun updateProfile(email: String)
    {
        val userData = UserData("","","","")

        firestore.collection("USERS").document(email)
            .set(userData)
            .addOnCompleteListener {
                if (it.isSuccessful) {

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

    fun loginUser(application: Application,email:String, password:String)
    {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful)
                {
                    liveRepoMessage.postValue("Hi, "+firebaseUser.displayName)
                    var i = Intent(application.applicationContext,SideMenuActivity::class.java)
                    i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(application.applicationContext,i, Bundle())
                    loginStatus.value = true
                }
                else
                {
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

    fun resetPassword(email: String)
    {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    liveRepoMessage.value =  "Password reset link has been sent to the provided email address"
                } else {
                    liveRepoMessage.value =  it.exception?.message
                    return@addOnCompleteListener
                }
            }
            .addOnFailureListener {
                liveRepoMessage.value =  it.message
                return@addOnFailureListener
            }
    }

}