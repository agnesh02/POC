package models.database;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDao_Impl implements RoomDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LoginData> __insertionAdapterOfLoginData;

  private final SharedSQLiteStatement __preparedStmtOfDeleteData;

  public RoomDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLoginData = new EntityInsertionAdapter<LoginData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `auth_table` (`id`,`status`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoginData value) {
        stmt.bindLong(1, value.getId());
        final int _tmp = value.getStatus() ? 1 : 0;
        stmt.bindLong(2, _tmp);
      }
    };
    this.__preparedStmtOfDeleteData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from auth_table";
        return _query;
      }
    };
  }

  @Override
  public void putData(final LoginData arg0) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLoginData.insert(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteData() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteData.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteData.release(_stmt);
    }
  }

  @Override
  public boolean getData() {
    final String _sql = "select status from auth_table where id=1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<LoginData> getData2() {
    final String _sql = "select * from auth_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<LoginData> _result = new ArrayList<LoginData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LoginData _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final boolean _tmpStatus;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfStatus);
        _tmpStatus = _tmp != 0;
        _item = new LoginData(_tmpId,_tmpStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
