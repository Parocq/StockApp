package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.WorkDays;

import java.util.ArrayList;

public class DAOWorkDays {

    SQLiteDatabase db;

    public DAOWorkDays (SQLiteDatabase db) {this.db = db;}

    public void insert(WorkDays obj) {
        ContentValues contentValues = new ContentValues();
     //   contentValues.put("id", obj.getId());
        contentValues.put("days", obj.getDays());

        db.insertOrThrow("work_days", null, contentValues);// при ошибке - выкидывает из проги

    }

    public ArrayList<WorkDays> selectWD(){
        ArrayList<WorkDays> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select _id, days from work_days" ,null);
        WorkDays wd;
        if (cursor.moveToFirst()) {
            do{
                int _id =cursor.getInt(0);
                String work_d = cursor.getString(1);
                wd = new WorkDays (_id, work_d);
                list.add(wd);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    public int addWD(WorkDays workDay) {
        db.execSQL("insert INTO work_days(days)" +
                "VALUES (\"" + workDay.getDays() + "\"\"" +
                 "\"\"" +
                 "\")");
        Cursor cursor = db.rawQuery("SELECT max(_id) FROM work_days", null);
        cursor.moveToFirst();
        int id = cursor.getInt(0);
        cursor.close();
        return id;
    }


    public void update(WorkDays obj) {

    }

    public void delete(WorkDays obj) {

    }


}
