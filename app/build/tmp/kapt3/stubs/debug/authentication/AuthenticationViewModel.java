package authentication;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010\'\u001a\u00020\u000eH\u0002J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020)J\b\u0010,\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010/\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u000e\u0010$\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lauthentication/AuthenticationViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "authenticationRepository", "Lrepository/AuthenticationRepository;", "checkBoxStatus", "", "getCheckBoxStatus", "()Z", "setCheckBoxStatus", "(Z)V", "emailRegex", "", "errorCode", "Landroidx/lifecycle/MutableLiveData;", "", "getErrorCode", "()Landroidx/lifecycle/MutableLiveData;", "setErrorCode", "(Landroidx/lifecycle/MutableLiveData;)V", "etConfirmPass", "getEtConfirmPass", "()Ljava/lang/String;", "setEtConfirmPass", "(Ljava/lang/String;)V", "etEmail", "getEtEmail", "setEtEmail", "etPass", "getEtPass", "setEtPass", "etUsername", "getEtUsername", "setEtUsername", "msg", "comparePassword", "password", "confirmPassword", "onLogin", "", "onRegister", "onResetPass", "startObservation", "validateEmail", "email", "validatePassword", "validateUsername", "username", "app_debug"})
public final class AuthenticationViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String etUsername = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String etEmail = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String etPass = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String etConfirmPass = "";
    private boolean checkBoxStatus = false;
    private java.lang.String emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> errorCode;
    private repository.AuthenticationRepository authenticationRepository;
    private java.lang.String msg = "";
    
    public AuthenticationViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEtUsername() {
        return null;
    }
    
    public final void setEtUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEtEmail() {
        return null;
    }
    
    public final void setEtEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEtPass() {
        return null;
    }
    
    public final void setEtPass(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEtConfirmPass() {
        return null;
    }
    
    public final void setEtConfirmPass(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getCheckBoxStatus() {
        return false;
    }
    
    public final void setCheckBoxStatus(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getErrorCode() {
        return null;
    }
    
    public final void setErrorCode(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    private final void startObservation() {
    }
    
    public final void onRegister() {
    }
    
    public final void onLogin() {
    }
    
    public final void onResetPass() {
    }
    
    private final boolean validateUsername(java.lang.String username) {
        return false;
    }
    
    private final boolean validateEmail(java.lang.String email) {
        return false;
    }
    
    private final boolean validatePassword(java.lang.String password) {
        return false;
    }
    
    private final boolean comparePassword(java.lang.String password, java.lang.String confirmPassword) {
        return false;
    }
}