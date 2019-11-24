package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Location;

public class DAOLocation {

        SQLiteDatabase db;

        public DAOLocation (SQLiteDatabase db) {this.db = db;}

        public void insert(Location obj) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("line", obj.getLine());
                contentValues.put("rack", obj.getRack());
                contentValues.put("shelf", obj.getShelf());

                db.insertOrThrow("Location", null, contentValues);// при ошибке - выкидывает из проги

        }

        public void update(Location obj) {

        }

        public void delete(Location obj) {

        }


    }
