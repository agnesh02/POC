package repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lrepository/ProfileRepository;", "", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "documentReference", "Lcom/google/firebase/firestore/DocumentReference;", "firebaseUser", "Lcom/google/firebase/auth/FirebaseUser;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "liveUserData", "Landroidx/lifecycle/MutableLiveData;", "Lmodels/UserData;", "getLiveUserData", "()Landroidx/lifecycle/MutableLiveData;", "setLiveUserData", "(Landroidx/lifecycle/MutableLiveData;)V", "getData", "", "updateData", "fullname", "", "dob", "phone", "updateProfilePicture", "uri", "Landroid/net/Uri;", "app_debug"})
public final class ProfileRepository {
    private com.google.firebase.auth.FirebaseAuth auth;
    private com.google.firebase.auth.FirebaseUser firebaseUser;
    private com.google.firebase.firestore.FirebaseFirestore firestore;
    private com.google.firebase.firestore.DocumentReference documentReference;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<models.UserData> liveUserData;
    
    public ProfileRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<models.UserData> getLiveUserData() {
        return null;
    }
    
    public final void setLiveUserData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<models.UserData> p0) {
    }
    
    public final void getData() {
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull()
    java.lang.String fullname, @org.jetbrains.annotations.NotNull()
    java.lang.String dob, @org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
    }
    
    public final void updateProfilePicture(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
}