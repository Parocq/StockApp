package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.WorkShift;

public class DAOWorkShift {

    SQLiteDatabase db;

    public DAOWorkShift (SQLiteDatabase db) {this.db = db;}

    public void insert(WorkShift obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", obj.getId());
        contentValues.put("shift", obj.getShift());

        db.insertOrThrow("work_shift", null, contentValues);
    }

    public void update(WorkShift obj) {

    }

    public void delete(WorkShift obj) {

    }


}
