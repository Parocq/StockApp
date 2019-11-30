package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Product;

import java.util.ArrayList;

public class DAOProduct {

        SQLiteDatabase db;

        public DAOProduct (SQLiteDatabase db) {this.db = db;}


        public void insert(Product obj) {

                ContentValues contentValues = new ContentValues();
                contentValues.put("title", obj.getTitle());
                contentValues.put("date_of_delivery", obj.getDate_of_delivery());// Гугли про дату и время SQLite
                contentValues.put("operator_id", obj.getOperator_id());
                contentValues.put("amount", obj.getAmount());
                contentValues.put("implementation_period", obj.getImplementation_period());
                contentValues.put("location_id", obj.getLocationId());
                contentValues.put("weight_category_id", obj.getWeightCategoryId());

                db.insertOrThrow("product", null, contentValues);

        }

        public void update(Product obj) {

        }

        public void delete(Product obj) {

        }

        public ArrayList<Product> selectTitle(){
                ArrayList<Product> list = new ArrayList<>();
                Cursor cursor = db.rawQuery("select id, title from product" ,null);
                Product pr;
                if (cursor.moveToFirst()) {
                        do{
                                //int id = cursor.getInt(0);
                                String title = cursor.getString(0);

                                pr = new Product (title);
                                list.add(pr);
                        } while (cursor.moveToNext());
                        cursor.close();
                }
                return list;
        }
}


