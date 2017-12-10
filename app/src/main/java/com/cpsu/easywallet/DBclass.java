package com.cpsu.easywallet;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class DBclass extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "examFinal.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "wallet";
    public static final String COL_ID = "_id";
    public static final String COL_TYPE = "type";
    public static final String COL_TITLE = "name";
    public static final String COL_AMOUNT = "amount";

    public DBclass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTable = "CREATE TABLE %s (" +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT," +
                "%s TEXT," +
                "%s TEXT)";
        sqlCreateTable = String.format(sqlCreateTable, TABLE_NAME, COL_ID, COL_TYPE, COL_TITLE, COL_AMOUNT);
        db.execSQL(sqlCreateTable);

        ContentValues cv = new ContentValues();

        cv.put(DBclass.COL_TYPE, "income");
        cv.put(DBclass.COL_TITLE, "Lotto 1M");
        cv.put(DBclass.COL_AMOUNT, "1000000");
        db.insert(DBclass.TABLE_NAME, null, cv);

        cv.put(DBclass.COL_TYPE, "income");
        cv.put(DBclass.COL_TITLE, "Lotto 1M");
        cv.put(DBclass.COL_AMOUNT, "1000000");
        db.insert(DBclass.TABLE_NAME, null, cv);

        cv.put(DBclass.COL_TYPE, "income");
        cv.put(DBclass.COL_TITLE, "Lotto 1M");
        cv.put(DBclass.COL_AMOUNT, "1000000");
        db.insert(DBclass.TABLE_NAME, null, cv);

        cv.put(DBclass.COL_TYPE, "income");
        cv.put(DBclass.COL_TITLE, "Lotto 1M");
        cv.put(DBclass.COL_AMOUNT, "1000000");
        db.insert(DBclass.TABLE_NAME, null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
