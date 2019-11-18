package com.german.stockapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static String NAME_DATABASE = "stock";

    public DBHelper(@Nullable Context context) {
        super(context, NAME_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.rawQuery("CREATE TABLE operator(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "operator_name TEXT," +
                "work_days_id INTEGER," +
                "work_shift_id INTEGER);", null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
