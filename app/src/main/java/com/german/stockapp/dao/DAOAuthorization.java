package com.german.stockapp.dao;
//commit
//commit from PC
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.AboutOperator;
import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Authorization;

import java.util.ArrayList;

public class DAOAuthorization {

        SQLiteDatabase db;

        public DAOAuthorization() {
        }

        public DAOAuthorization (SQLiteDatabase db) {this.db = db;}

        public void insert(Authorization obj) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("login", obj.getLogin());
                contentValues.put("pass", obj.getPass());
                contentValues.put("roles_id", obj.getRoles_id());
                contentValues.put("operator_id", obj.getOperator_id());

                db.insertOrThrow("authorization", null, contentValues);// при ошибке - выкидывает из проги
        }

        public void update(Authorization obj) {

        }

        public void delete(Authorization obj) {

        }

        public ArrayList<Authorization> selectAll(){
                ArrayList<Authorization> list = new ArrayList<>();
                Cursor  cursor = db.rawQuery("select * from authorization" ,null);
                Authorization at;
                if (cursor.moveToFirst()) {
                do{
                        int id = cursor.getInt(0);
                        String login = cursor.getString(1);
                        String pass = cursor.getString(2);
                        int role_id = cursor.getInt(3);
                        int operator_id = cursor.getInt(4);
                        at = new Authorization (id, login, pass, role_id, operator_id);
                        list.add(at);
                } while (cursor.moveToNext());
                cursor.close();
                }
                return list;
                }
        }
