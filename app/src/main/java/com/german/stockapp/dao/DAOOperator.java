package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Operator;
import com.german.stockapp.entity.Product;

import java.util.ArrayList;
import java.util.List;


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

        db.insertOrThrow("operator", null, contentValues);// при ошибке - выкидывает из проги
    }

    public void update(Operator obj) {

    }

    public void delete(Operator obj) {

    }

    public ArrayList<Operator> selectAll() {//  вывод всей таблицы
        ArrayList<Operator> list = new ArrayList<>();// Operator[] list = new Operator[];
        return list;
    }

    public List<Operator> SelectFIO() {
        ArrayList<Operator> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select _id, operator_name from operator", null);
        Operator op;
        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(1);

                op = new Operator(title);
                list.add(op);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }
}
