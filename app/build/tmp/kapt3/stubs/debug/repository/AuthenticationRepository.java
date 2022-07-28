package repository;

import java.lang.System;

@kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bJ\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f\u00a8\u0006!"}, d2 = {"Lrepository/AuthenticationRepository;", "", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "firebaseUser", "Lcom/google/firebase/auth/FirebaseUser;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "liveRepoMessage", "Landroidx/lifecycle/MutableLiveData;", "", "getLiveRepoMessage", "()Landroidx/lifecycle/MutableLiveData;", "setLiveRepoMessage", "(Landroidx/lifecycle/MutableLiveData;)V", "loginStatus", "", "getLoginStatus", "setLoginStatus", "isVerified", "loginUser", "", "application", "Landroid/app/Application;", "email", "password", "save", "logoutUser", "registerUser", "username", "resetPassword", "setProfile", "app_debug"})
public final class AuthenticationRepository {
    private com.google.firebase.auth.FirebaseAuth auth;
    private com.google.firebase.auth.FirebaseUser firebaseUser;
    private com.google.firebase.firestore.FirebaseFirestore firestore;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> loginStatus;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> liveRepoMessage;
    
    public AuthenticationRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getLoginStatus() {
        return null;
    }
    
    public final void setLoginStatus(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getLiveRepoMessage() {
        return null;
    }
    
    public final void setLiveRepoMessage(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    public final void registerUser(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final void setProfile(java.lang.String email, java.lang.String username) {
    }
    
    private final boolean isVerified() {
        return false;
    }
    
    public final void loginUser(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, boolean save) {
    }
    
    public final void resetPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void logoutUser(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
    }
}