package ble;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\b\u0010\'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020 H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R0\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00150\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011\u00a8\u0006)"}, d2 = {"Lble/BleViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "buttonText", "Landroidx/lifecycle/MutableLiveData;", "", "getButtonText", "()Landroidx/lifecycle/MutableLiveData;", "setButtonText", "(Landroidx/lifecycle/MutableLiveData;)V", "deviceList", "Ljava/util/ArrayList;", "Landroid/bluetooth/BluetoothDevice;", "Lkotlin/collections/ArrayList;", "getDeviceList", "()Ljava/util/ArrayList;", "setDeviceList", "(Ljava/util/ArrayList;)V", "leScanCallback", "Landroid/bluetooth/le/ScanCallback;", "liveDevicesList", "getLiveDevicesList", "setLiveDevicesList", "checkBleAdapterState", "", "ble", "Lquevedo/soares/leandro/blemadeeasy/BLE;", "checkLocationPermission", "initializeBLE", "requestPermission", "scanState", "startScanning", "stopScanning", "app_debug"})
public final class BleViewModel extends androidx.lifecycle.AndroidViewModel {
    private android.bluetooth.BluetoothManager bluetoothManager;
    private android.bluetooth.BluetoothAdapter bluetoothAdapter;
    private android.bluetooth.le.BluetoothLeScanner bluetoothLeScanner;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> buttonText;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.ArrayList<android.bluetooth.BluetoothDevice>> liveDevicesList;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<android.bluetooth.BluetoothDevice> deviceList;
    private final android.bluetooth.le.ScanCallback leScanCallback = null;
    
    public BleViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getButtonText() {
        return null;
    }
    
    public final void setButtonText(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<android.bluetooth.BluetoothDevice>> getLiveDevicesList() {
        return null;
    }
    
    public final void setLiveDevicesList(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.ArrayList<android.bluetooth.BluetoothDevice>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<android.bluetooth.BluetoothDevice> getDeviceList() {
        return null;
    }
    
    public final void setDeviceList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<android.bluetooth.BluetoothDevice> p0) {
    }
    
    private final void requestPermission(quevedo.soares.leandro.blemadeeasy.BLE ble) {
    }
    
    private final void checkBleAdapterState(quevedo.soares.leandro.blemadeeasy.BLE ble) {
    }
    
    private final void checkLocationPermission(quevedo.soares.leandro.blemadeeasy.BLE ble) {
    }
    
    private final void initializeBLE() {
    }
    
    public final void scanState(@org.jetbrains.annotations.NotNull()
    quevedo.soares.leandro.blemadeeasy.BLE ble) {
    }
    
    private final void startScanning() {
    }
    
    private final void stopScanning() {
    }
}