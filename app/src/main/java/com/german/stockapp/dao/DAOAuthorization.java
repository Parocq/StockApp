package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Authorization;

public class DAOAuthorization {

        SQLiteDatabase db;

        public DAOAuthorization (SQLiteDatabase db) {this.db = db;}

        public void insert(Authorization obj) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("login", obj.getLogin());
                contentValues.put("pass", obj.getPass());
                contentValues.put("roles_id", obj.getRoles_id());
                contentValues.put("operator_id", obj.getOperator_id());

                db.insertOrThrow("Authorization", null, contentValues);// при ошибке - выкидывает из проги
        }

        public void update(Authorization obj) {

        }

        public void delete(Authorization obj) {

        }


    }
