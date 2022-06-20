package Repository

import Profile.ProfileViewModel
import Utilities.UserData
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.firebase.ui.auth.data.model.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.HashMap

class ProfileRepository {

    var auth:FirebaseAuth = FirebaseAuth.getInstance()
    var firebaseUser:FirebaseUser = auth.currentUser!!
    var firestore:FirebaseFirestore = FirebaseFirestore.getInstance()
    var documentReference: DocumentReference = firestore.collection("USERS").document(firebaseUser.email!!)

    var liveUsername:MutableLiveData<String> = MutableLiveData()
    var liveName:MutableLiveData<String> = MutableLiveData()
    var liveDob:MutableLiveData<String> = MutableLiveData()
    var liveEmail:MutableLiveData<String> = MutableLiveData()
    var livePhone:MutableLiveData<String> = MutableLiveData()

    var liveRepoMessage:MutableLiveData<String> = MutableLiveData()


    fun getData()
    {
        var obj = UserData()

        documentReference.get()
            .addOnCompleteListener(OnCompleteListener {
                if(it.isSuccessful)
                {
                    var snapshot:DocumentSnapshot = it.result
                    obj = snapshot.toObject(UserData::class.java)!!

                    liveUsername.postValue(firebaseUser.displayName)
                    liveName.postValue(obj.fullname)
                    liveDob.postValue(obj.dob)
                    liveEmail.postValue(firebaseUser.email)
                    livePhone.postValue(obj.phone)

                    liveRepoMessage.postValue("ok")
                }
                else
                {
                    liveRepoMessage.postValue(it.exception?.message)
                }
            })
            .addOnFailureListener(OnFailureListener {
                liveRepoMessage.postValue(it.message)
            })

    }

    fun updateData(fullname:String, dob:String, phone:String)
    {
        var map:HashMap<String,Any> = HashMap()
        map.put("fullname",fullname)
        map.put("dob",dob)
        map.put("phone",phone)

        documentReference.update(map)
            .addOnCompleteListener(OnCompleteListener {
                if(it.isSuccessful)
                {
                    liveRepoMessage.postValue("Profile updated successfully")
                }
                else
                {
                    liveRepoMessage.postValue(it.exception?.message)
                }
            })
            .addOnFailureListener(OnFailureListener {
                liveRepoMessage.postValue(it.message)
            })

    }



}