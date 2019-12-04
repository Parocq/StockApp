package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Authorization;
import com.german.stockapp.entity.Roles;

import java.util.ArrayList;

public class DAORoles {

    SQLiteDatabase db;

    public DAORoles (SQLiteDatabase db) {this.db = db;}

    public void insert(Roles obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("role_name", obj.getRole_name());

        db.insertOrThrow("roles", null, contentValues);
    }

    public void update(Roles obj) {

    }

    public void delete(Roles obj) {

    }

    public String selectTitleById(int id){
        //ArrayList<Roles> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from roles where _id = "+ id +";" ,null);
        //Roles ro;
        String role_name=null;
        if (cursor.moveToFirst()) {
            do{
                //int _id = cursor.getInt(0);
                role_name = cursor.getString(1);
//                ro = new Roles (_id, role_name);
//                list.add(ro);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return role_name;
    }
}
