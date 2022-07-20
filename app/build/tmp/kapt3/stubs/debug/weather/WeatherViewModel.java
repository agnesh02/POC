package weather;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010%\u001a\u00020&J\u0010\u0010\'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0007H\u0002R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lweather/WeatherViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "citiesList", "", "", "[Ljava/lang/String;", "cityAdapter", "Landroid/widget/ArrayAdapter;", "getCityAdapter", "()Landroid/widget/ArrayAdapter;", "setCityAdapter", "(Landroid/widget/ArrayAdapter;)V", "cityName", "getCityName", "()Ljava/lang/String;", "setCityName", "(Ljava/lang/String;)V", "liveWeatherData", "Landroidx/lifecycle/MutableLiveData;", "Lmodels/WeatherResponse;", "getLiveWeatherData", "()Landroidx/lifecycle/MutableLiveData;", "setLiveWeatherData", "(Landroidx/lifecycle/MutableLiveData;)V", "pBarVisibility", "", "getPBarVisibility", "setPBarVisibility", "weatherAdapter", "Lweather/WeatherAdapter;", "getWeatherAdapter", "setWeatherAdapter", "weatherRepository", "Lrepository/WeatherRepository;", "fetchWeatherData", "", "validate", "s", "app_debug"})
public final class WeatherViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cityName = "";
    private java.lang.String[] citiesList;
    @org.jetbrains.annotations.NotNull()
    private android.widget.ArrayAdapter<java.lang.String> cityAdapter;
    private repository.WeatherRepository weatherRepository;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<models.WeatherResponse> liveWeatherData;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<weather.WeatherAdapter> weatherAdapter;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> pBarVisibility;
    
    public WeatherViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCityName() {
        return null;
    }
    
    public final void setCityName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ArrayAdapter<java.lang.String> getCityAdapter() {
        return null;
    }
    
    public final void setCityAdapter(@org.jetbrains.annotations.NotNull()
    android.widget.ArrayAdapter<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<models.WeatherResponse> getLiveWeatherData() {
        return null;
    }
    
    public final void setLiveWeatherData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<models.WeatherResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<weather.WeatherAdapter> getWeatherAdapter() {
        return null;
    }
    
    public final void setWeatherAdapter(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<weather.WeatherAdapter> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getPBarVisibility() {
        return null;
    }
    
    public final void setPBarVisibility(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    private final boolean validate(java.lang.String s) {
        return false;
    }
    
    public final void fetchWeatherData() {
    }
}