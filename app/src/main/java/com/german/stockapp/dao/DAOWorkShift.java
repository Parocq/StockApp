package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.WorkShift;

import java.util.ArrayList;

public class DAOWorkShift {

    SQLiteDatabase db;

    public DAOWorkShift (SQLiteDatabase db) {this.db = db;}

    public void insert(WorkShift obj) {
        ContentValues contentValues = new ContentValues();
      //  contentValues.put("id", obj.getId());
        contentValues.put("shift", obj.getShift());

        db.insertOrThrow("work_shift", null, contentValues);
    }

    public ArrayList<WorkShift> selectWS(){
        ArrayList<WorkShift> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select _id, shift from work_shift" ,null);
        WorkShift ws;
        if (cursor.moveToFirst()) {
            do{
                int _id =cursor.getInt(0);
                String work_s = cursor.getString(1);
                ws = new WorkShift (_id, work_s);
                list.add(ws);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    public int addWS(WorkShift workShift) {
        db.execSQL("insert INTO work_shift(shift)" +
                "VALUES (\"" + workShift.getShift() + "\"\"" +
                "\"\"" +
                "\")");
        Cursor cursor = db.rawQuery("SELECT max(_id) FROM work_shift", null);
        cursor.moveToFirst();
        int id = cursor.getInt(0);
        cursor.close();
        return id;
    }

    public void update(WorkShift obj) {

    }

    public void delete(WorkShift obj) {

    }


}
