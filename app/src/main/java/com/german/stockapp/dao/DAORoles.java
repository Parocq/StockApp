package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Roles;

public class DAORoles {

    SQLiteDatabase db;

    public DAORoles (SQLiteDatabase db) {this.db = db;}

    public void insert(Roles obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", obj.getId());
        contentValues.put("role_name", obj.getRole_name());

        db.insertOrThrow("Authorization", null, contentValues);
    }

    public void update(Roles obj) {

    }

    public void delete(Roles obj) {

    }

}
