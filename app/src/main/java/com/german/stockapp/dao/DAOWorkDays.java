package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.WorkDays;

public class DAOWorkDays {

    SQLiteDatabase db;

    public DAOWorkDays (SQLiteDatabase db) {this.db = db;}

    public void insert(WorkDays obj) {
        ContentValues contentValues = new ContentValues();
     //   contentValues.put("id", obj.getId());
        contentValues.put("days", obj.getDays());

        db.insertOrThrow("work_days", null, contentValues);// при ошибке - выкидывает из проги

    }


    public void update(WorkDays obj) {

    }

    public void delete(WorkDays obj) {

    }


}
