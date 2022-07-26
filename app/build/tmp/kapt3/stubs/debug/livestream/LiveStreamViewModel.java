package livestream;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020 R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\u001a\u0010\u0018\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\fR\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\f\u00a8\u0006&"}, d2 = {"Llivestream/LiveStreamViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "inStream", "Ljava/io/BufferedInputStream;", "ip", "", "getIp", "()Ljava/lang/String;", "setIp", "(Ljava/lang/String;)V", "msg", "Landroidx/lifecycle/MutableLiveData;", "getMsg", "()Landroidx/lifecycle/MutableLiveData;", "setMsg", "(Landroidx/lifecycle/MutableLiveData;)V", "outStream", "Ljava/io/OutputStream;", "path", "getPath", "setPath", "port", "getPort", "setPort", "scheme", "url", "getUrl", "setUrl", "record", "", "Ljava/net/URL;", "startRecording", "stopRecording", "validate", "Companion", "app_debug"})
public final class LiveStreamViewModel extends androidx.lifecycle.AndroidViewModel {
    private java.lang.String scheme = "http://";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String ip = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String port = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String path = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String url = "";
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> msg;
    private java.io.BufferedInputStream inStream;
    private java.io.OutputStream outStream;
    @org.jetbrains.annotations.NotNull()
    public static final livestream.LiveStreamViewModel.Companion Companion = null;
    public static final int TIMEOUT_CONNECTION = 5000;
    public static final int TIMEOUT_SOCKET = 30000;
    
    public LiveStreamViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIp() {
        return null;
    }
    
    public final void setIp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPort() {
        return null;
    }
    
    public final void setPort(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPath() {
        return null;
    }
    
    public final void setPath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final void setUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getMsg() {
        return null;
    }
    
    public final void setMsg(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    public final void validate() {
    }
    
    public final void startRecording(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    private final void record(java.net.URL url) {
    }
    
    public final void stopRecording() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Llivestream/LiveStreamViewModel$Companion;", "", "()V", "TIMEOUT_CONNECTION", "", "TIMEOUT_SOCKET", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}