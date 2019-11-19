package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Operator;

import java.util.ArrayList;


public class DAOOperator {

    SQLiteDatabase db;

    public DAOOperator(SQLiteDatabase db) {
        this.db = db;
    }

    public void insert(Operator obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("operator_name", obj.getOperatorName());
        contentValues.put("work_days_id", obj.getWorkDaysId());
        contentValues.put("work_shift_id", obj.getWorkShiftId());

        db.insert("operator", null, contentValues);
    }

    public void update(Operator obj) {

    }

    public void delete(Operator obj) {

    }

    public ArrayList<Operator> selectAll() {//  вывод всей таблицы
        ArrayList<Operator> list = new ArrayList<>();// Operator[] list = new Operator[];
        return list;
    }
}
