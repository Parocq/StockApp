package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Location;

import java.util.ArrayList;

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
        db.execSQL("insert INTO location(line, rack, shelf)" +
                "VALUES (\"" + location.getLine() + "\",\"" +
                location.getRack() + "\",\"" +
                location.getShelf() + "\")");
        Cursor cursor = db.rawQuery("SELECT max(_id) FROM location", null);
        cursor.moveToFirst();
        int id = cursor.getInt(0);
        cursor.close();
        return id;
    }

    public ArrayList<Location> selectAll(){
        ArrayList<Location> list = new ArrayList<>();
        Cursor  cursor = db.rawQuery("select * from location" ,null);
        Location loc;
        if (cursor.moveToFirst()) {
            do{
                int _id = cursor.getInt(0);
                int line = cursor.getInt(1);
                int rack = cursor.getInt(2);
                int shelf = cursor.getInt(3);
                loc = new Location (_id, line , rack, shelf);
                list.add(loc);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }


    public void update(Location obj) {

    }

    public void delete(Location obj) {

    }


}
