package repository

import models.UserData
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlin.collections.HashMap

class ProfileRepository {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseUser: FirebaseUser = auth.currentUser!!
    private var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var documentReference: DocumentReference = firestore.collection("USERS").document(firebaseUser.email!!)
    var liveUserData: MutableLiveData<UserData> = MutableLiveData()

    fun getUsernameAndEmail()
    {
        documentReference.get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val snapshot: DocumentSnapshot = it.result
                    val obj = UserData()
                    obj.username = snapshot.getString("username")
                    obj.email = auth.currentUser!!.email
                    liveUserData.postValue(obj)
                }
            }
    }

    fun getData() {
        var obj: UserData
        documentReference.get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val snapshot: DocumentSnapshot = it.result
                    obj = snapshot.toObject(UserData::class.java)!!

                    val userData = UserData()

                    userData.username = obj.username
                    userData.fullname = obj.fullname
                    userData.dob = obj.dob
                    userData.email = firebaseUser.email
                    userData.phone = obj.phone
                    userData.image_uri = obj.image_uri

                    userData.message = "ok"
                    liveUserData.postValue(userData)

                } else {
                    val userData = UserData()
                    userData.message = it.exception?.message
                    liveUserData.postValue(userData)
                }
            }
            .addOnFailureListener {
                val userData = UserData()
                userData.message = it.message
                liveUserData.postValue(userData)
            }

    }

    fun updateData(userName: String, fullname: String, dob: String, phone: String) {
        val map: HashMap<String, Any> = HashMap()
        map["username"] = userName
        map["fullname"] = fullname
        map["dob"] = dob
        map["phone"] = phone

        documentReference.update(map)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val userData = UserData()
                    userData.message = "Profile updated successfully"
                    liveUserData.postValue(userData)
                } else {
                    val userData = UserData()
                    userData.message = it.exception?.message
                    liveUserData.postValue(userData)
                }
            }
            .addOnFailureListener {
                val userData = UserData()
                userData.message = it.message
                liveUserData.postValue(userData)
            }

    }

    fun updateProfilePicture(uri: Uri) {
        val firebaseStorage: FirebaseStorage = FirebaseStorage.getInstance()
        val storageReference: StorageReference =
            firebaseStorage.reference.child("IMAGES/" + firebaseUser.email)

        storageReference.putFile(uri)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    storageReference.downloadUrl
                        .addOnSuccessListener { uri ->

                            documentReference.update("image_uri", uri.toString())
                                .addOnCompleteListener {
                                    val userData = UserData()
                                    userData.message = "Image has been uploaded successfully"
                                    liveUserData.postValue(userData)
                                }
                                .addOnFailureListener { t ->
                                    val userData = UserData()
                                    userData.message = t.message
                                    liveUserData.postValue(userData)
                                }
                        }
                } else {
                    val userData = UserData()
                    userData.message = it.exception?.message
                    liveUserData.postValue(userData)
                }
            }
            .addOnFailureListener {
                val userData = UserData()
                userData.message = it.message
                liveUserData.postValue(userData)
            }
    }


}