package authentication;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016H\u0002J\u0006\u00105\u001a\u000201J\u0006\u00106\u001a\u000201J\u0006\u00107\u001a\u000201J\b\u00108\u001a\u000201H\u0002J\u0010\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0016H\u0002J\u0010\u0010;\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0016H\u0002J\u0010\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010&\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001d\"\u0004\b(\u0010\u001fR \u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014R\u000e\u0010,\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014\u00a8\u0006>"}, d2 = {"Lauthentication/AuthenticationViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "authenticationRepository", "Lrepository/AuthenticationRepository;", "checkBoxStatus", "", "getCheckBoxStatus", "()Z", "setCheckBoxStatus", "(Z)V", "db", "Lmodels/database/Database;", "dbData", "Landroidx/lifecycle/MutableLiveData;", "getDbData", "()Landroidx/lifecycle/MutableLiveData;", "setDbData", "(Landroidx/lifecycle/MutableLiveData;)V", "emailRegex", "", "errorCode", "", "getErrorCode", "setErrorCode", "etConfirmPass", "getEtConfirmPass", "()Ljava/lang/String;", "setEtConfirmPass", "(Ljava/lang/String;)V", "etEmail", "getEtEmail", "setEtEmail", "etPass", "getEtPass", "setEtPass", "etUsername", "getEtUsername", "setEtUsername", "loginStatus", "getLoginStatus", "setLoginStatus", "msg", "pBarVisibility", "getPBarVisibility", "setPBarVisibility", "checkForLogin", "", "comparePassword", "password", "confirmPassword", "onLogin", "onRegister", "onResetPass", "startObservation", "validateEmail", "email", "validatePassword", "validateUsername", "username", "app_debug"})
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
    private models.database.Database db;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> dbData;
    private repository.AuthenticationRepository authenticationRepository;
    private java.lang.String msg = "";
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> loginStatus;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> pBarVisibility;
    
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
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getDbData() {
        return null;
    }
    
    public final void setDbData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getLoginStatus() {
        return null;
    }
    
    public final void setLoginStatus(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getPBarVisibility() {
        return null;
    }
    
    public final void setPBarVisibility(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    public final void checkForLogin() {
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