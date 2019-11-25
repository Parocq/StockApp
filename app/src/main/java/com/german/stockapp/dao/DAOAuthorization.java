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

                db.insertOrThrow("authorization", null, contentValues);// при ошибке - выкидывает из проги
        }

        public void update(Authorization obj) {

        }

        public void delete(Authorization obj) {

        }
public ArrayList<Authorization> selectAll(){
ArrayList<Authorization> list = new ArrayList<>();
  Cursor cursor = db.query(DBHelper.TABLE_AUTHORIZATION, null   ,null,null,null,null,null );
Authorization at;
if (cursor.moveToFirst()) {
do{
int id = cursor.getInt(0);
String login = cursor.getString(1);
String pass = curs
int role_id =
int op_id =
at = new Authorization (id, login, pass, role_id, op_id);
list.add(at);

} while (cursor.moveToNext);
Curso
 }
return list;
}

    }
