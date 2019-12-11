package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Authorization;
import com.german.stockapp.entity.Operator;
import com.german.stockapp.entity.Product;
import com.german.stockapp.entity.WorkDays;
import com.german.stockapp.entity.WorkShift;

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

    public Operator selectWhere(int id) {
        Cursor cursor = db.rawQuery("SELECT o._id, o.operator_name, wd.days, ws.shift, a.login, a.pass from operator o\n" +
                "INNER JOIN work_days wd on wd._id=o.work_days_id INNER JOIN work_shift ws ON\n" +
                "ws._id=o.work_shift_id INNER JOIN authorization a on a.operator_id = o._id where o._id = " + id + ";", null);

        Operator op = null;
        if (cursor.moveToFirst()) {
            do {
                int _id = cursor.getInt(0);
                String operator_name = cursor.getString(1);

                String days = cursor.getString(2);
                WorkDays workDays = new WorkDays(days);

                String shift = cursor.getString(3);
                WorkShift workShift = new WorkShift(shift);

                String login = cursor.getString(4);
                String pass = cursor.getString(5);
                Authorization authorization = new Authorization(login, pass);

                op = new Operator(_id, operator_name, workShift,workDays, authorization);

            } while (cursor.moveToNext());
            cursor.close();
        }
        return op;
    }

    public int addOperator(Operator operator) {
        db.execSQL("insert INTO operator(operator_name,work_days_id,work_shift_id)" +
                "VALUES (\"" + operator.getOperatorName() + "\",\"" +
                        operator.getWorkDaysId() + "\",\"" +
                        operator.getWorkShiftId() + "\")");

        Cursor cursor = db.rawQuery("SELECT max(_id) FROM operator", null);
        cursor.moveToFirst();
        int id = cursor.getInt(0);
        cursor.close();
        return id;
    }

//    CREATE TABLE operator(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
//            "operator_name TEXT," +
//            "work_days_id INTEGER," +
//            "work_shift_id INTEGER," +

    public void redactOperator (Operator operator, int id) {
        db.execSQL("UPDATE operator SET operator_name = \"" + operator.getOperatorName() + "\"," +
                "work_days_id = \"" + operator.getWorkDaysId() + "\"," +
                "work_shift_id = \"" + operator.getWorkShiftId() + "\"where _id = \"" + id + "\";\"");
    }
}
