package repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010\u001a\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J!\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eR*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\'\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lrepository/WeatherRepository;", "", "()V", "forecastList", "Ljava/util/ArrayList;", "Lmodels/WeatherResponse;", "Lkotlin/collections/ArrayList;", "getForecastList", "()Ljava/util/ArrayList;", "setForecastList", "(Ljava/util/ArrayList;)V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "liveForecastList", "getLiveForecastList", "fetchCurrentData", "", "retrofitDataForCurrent", "Lretrofit2/Call;", "Lmodels/weather/WeatherData;", "application", "Landroid/app/Application;", "city", "", "fetchForecastData", "retrofitDataForForecast", "Lmodels/weather/ForecastData;", "getWeatherData", "(Ljava/lang/String;Landroid/app/Application;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class WeatherRepository {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<models.WeatherResponse> liveData = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<models.WeatherResponse> forecastList;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<models.WeatherResponse>> liveForecastList = null;
    @org.jetbrains.annotations.NotNull()
    public static final repository.WeatherRepository.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String APP_ID = "64558cdf1afc2d3a085c537c449b1770";
    
    public WeatherRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<models.WeatherResponse> getLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<models.WeatherResponse> getForecastList() {
        return null;
    }
    
    public final void setForecastList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<models.WeatherResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<models.WeatherResponse>> getLiveForecastList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
    public final java.lang.Object getWeatherData(@org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void fetchCurrentData(retrofit2.Call<models.weather.WeatherData> retrofitDataForCurrent, android.app.Application application, java.lang.String city) {
    }
    
    private final void fetchForecastData(retrofit2.Call<models.weather.ForecastData> retrofitDataForForecast, android.app.Application application) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lrepository/WeatherRepository$Companion;", "", "()V", "APP_ID", "", "BASE_URL", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}