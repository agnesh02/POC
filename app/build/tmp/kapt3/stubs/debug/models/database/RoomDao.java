package models.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\'\u00a8\u0006\u000b"}, d2 = {"Lmodels/database/RoomDao;", "", "deleteData", "", "getData", "", "getData2", "", "Lmodels/database/LoginData;", "putData", "loginData", "app_debug"})
public abstract interface RoomDao {
    
    @androidx.room.Insert()
    public abstract void putData(@org.jetbrains.annotations.NotNull()
    models.database.LoginData loginData);
    
    @androidx.room.Query(value = "select status from auth_table where id=1")
    public abstract boolean getData();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from auth_table")
    public abstract java.util.List<models.database.LoginData> getData2();
    
    @androidx.room.Query(value = "delete from auth_table")
    public abstract void deleteData();
}