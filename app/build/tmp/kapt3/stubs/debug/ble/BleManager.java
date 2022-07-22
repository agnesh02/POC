package ble;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006 "}, d2 = {"Lble/BleManager;", "", "()V", "ble", "Lquevedo/soares/leandro/blemadeeasy/BLE;", "getBle", "()Lquevedo/soares/leandro/blemadeeasy/BLE;", "setBle", "(Lquevedo/soares/leandro/blemadeeasy/BLE;)V", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevice", "()Landroid/bluetooth/BluetoothDevice;", "setBluetoothDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "connectionStatus", "Landroidx/lifecycle/MutableLiveData;", "", "getConnectionStatus", "()Landroidx/lifecycle/MutableLiveData;", "setConnectionStatus", "(Landroidx/lifecycle/MutableLiveData;)V", "writeStatus", "getWriteStatus", "setWriteStatus", "connectDevice", "", "createBleInstance", "disconnectDevice", "setDevice", "device", "writeData", "app_debug"})
public final class BleManager {
    @org.jetbrains.annotations.NotNull()
    public static final ble.BleManager INSTANCE = null;
    @org.jetbrains.annotations.Nullable()
    private static quevedo.soares.leandro.blemadeeasy.BLE ble;
    @org.jetbrains.annotations.Nullable()
    private static android.bluetooth.BluetoothDevice bluetoothDevice;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.String> connectionStatus;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.String> writeStatus;
    
    private BleManager() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final quevedo.soares.leandro.blemadeeasy.BLE getBle() {
        return null;
    }
    
    public final void setBle(@org.jetbrains.annotations.Nullable()
    quevedo.soares.leandro.blemadeeasy.BLE p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothDevice getBluetoothDevice() {
        return null;
    }
    
    public final void setBluetoothDevice(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getConnectionStatus() {
        return null;
    }
    
    public final void setConnectionStatus(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getWriteStatus() {
        return null;
    }
    
    public final void setWriteStatus(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    public final void createBleInstance(@org.jetbrains.annotations.NotNull()
    quevedo.soares.leandro.blemadeeasy.BLE ble) {
    }
    
    public final void setDevice(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device) {
    }
    
    public final void connectDevice() {
    }
    
    public final void disconnectDevice() {
    }
    
    public final void writeData() {
    }
}