package models.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RoomDao {

    @Insert
    fun putData(loginData: LoginData)

    @Query("select status from auth_table where id=1")
    fun getData():Boolean

    @Query("select * from auth_table")
    fun getData2():List<LoginData>

    @Query("delete from auth_table")
    fun deleteData()

}