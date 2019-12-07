package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Location;

public class DAOLocation {

    SQLiteDatabase db;

    public DAOLocation(SQLiteDatabase db) {
        this.db = db;
    }

    public void insert(Location obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("line", obj.getLine());
        contentValues.put("rack", obj.getRack());
        contentValues.put("shelf", obj.getShelf());

        db.insertOrThrow("Location", null, contentValues);// при ошибке - выкидывает из проги

    }

    public int addLocation(Location location) {
        db.execSQL("insert INTO location(line, rack, shelf)\n" +
                "VALUES (\"" + location.getLine() + "\",\"" +
                location.getRack() + "\",\"" +
                location.getShelf() + "\")");
        Cursor cursor = db.rawQuery("SELECT max(_id) FROM location", null);
        cursor.moveToFirst();
        int id = cursor.getInt(0);
        db.close();
        cursor.close();
        return id;
    }

    public void update(Location obj) {

    }

    public void delete(Location obj) {

    }


}
