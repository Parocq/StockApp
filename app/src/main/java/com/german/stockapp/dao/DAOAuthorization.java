package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.AboutOperator;
import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Authorization;

import java.util.ArrayList;

public class DAOAuthorization {

        SQLiteDatabase db;

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

        public ArrayList<Authorization> selectLogPas(){
                ArrayList<Authorization> list = new ArrayList<>();
                Cursor  cursor = db.rawQuery("select login, pass from authorization" ,null);
                Authorization at;
                if (cursor.moveToFirst()) {
                        do{
                                String login = cursor.getString(0);
                                String pass = cursor.getString(1);
                                at = new Authorization (login, pass);
                                list.add(at);
                        } while (cursor.moveToNext());
                        cursor.close();
                }
                return list;
        }

        public void addAuthorization(Authorization authorization) {
                db.execSQL("insert INTO authorization(login,pass,roles_id,operator_id)" +
                        "VALUES (\"" + authorization.getLogin() + "\",\"" +
                        authorization.getPass() + "\",\"" +
                        authorization.getRoles_id() + "\",\"" +
                        authorization.getOperator_id() + "\")");
//                Cursor cursor = db.rawQuery("SELECT max(_id) FROM authorization", null);
//                cursor.moveToFirst();
//                int id = cursor.getInt(0);
//                cursor.close();
//                return id;
        }

        public void redactAuthorization (Authorization authorization, int id) {
                db.execSQL("UPDATE authorization SET login = \"" + authorization.getLogin() + "\"," +
                        "pass = \"" + authorization.getPass() + "\"where operator_id = \"" + id + "\";\"");
        }
        }




//        public Authorization(String login, String pass, int roles_id, int operator_id) {
//                this.login = login;
//                this.pass = pass;
//                this.roles_id = roles_id;
//                this.operator_id = operator_id;
//        }
