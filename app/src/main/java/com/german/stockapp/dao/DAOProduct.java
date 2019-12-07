package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.german.stockapp.entity.Location;
import com.german.stockapp.entity.Operator;
import com.german.stockapp.entity.Product;
import com.german.stockapp.entity.WeightCategory;

import java.util.ArrayList;

public class DAOProduct {

    SQLiteDatabase db;

    public DAOProduct(SQLiteDatabase db) {
        this.db = db;
    }


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


    public void AddProduct(Product product){
        db.execSQL("insert INTO product(title, date_of_delivery, operator_id," +
                " amount, implementation_period,location_id, weight_category_id)" +
                "VALUES (\"" + product.getTitle() + "\",\"" +
                product.getDate_of_delivery() + "\",\"" +
                product.getOperator_id() + "\",\"" +
                product.getAmount() + "\",\"" +
                product.getImplementation_period() + "\",\"" +
                product.getLocationId() + "\",\"" +
                product.getWeightCategoryId() + "\")");
    }


    public ArrayList<Product> selectTitle() {
        ArrayList<Product> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select _id, title from product", null);
        Product pr;
        if (cursor.moveToFirst()) {
            do {
//                                int id = cursor.getInt(0);
                String title = cursor.getString(1);

                pr = new Product(title);
                list.add(pr);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    public Product selectWhere(int id) {

        Cursor cursor = db.rawQuery("select * from product p inner join location l on p.location_id=l._id INNER JOIN operator o on p.operator_id = o.\"_id\" \n" +
                "        inner join weight_category w on p.weight_category_id = w._id where p._id = " + id + ";", null);

        Product pr = null;
        if (cursor.moveToFirst()) {
            do {
                int _id = cursor.getInt(0);
                String title = cursor.getString(1);
                String date_of_delivery = cursor.getString(2);
                int operator_id = cursor.getInt(3);

                String operator_name =  cursor.getString(13);
                Operator operator = new Operator(operator_name);

                int amount = cursor.getInt(4);
                String implementation_period = cursor.getString(5);
                int location_id = cursor.getInt(6);

                int line = cursor.getInt(9);
                int rack = cursor.getInt(10);
                int shelf = cursor.getInt(11);
                Location location = new Location(line, rack, shelf);

                int weight_category_id = cursor.getInt(7);

                String wk_title = cursor.getString(17);
                double wk_min_weight = cursor.getInt(18);
                double wk_max_weight = cursor.getInt(19);
                WeightCategory weightCategory = new WeightCategory(wk_title, wk_max_weight, wk_min_weight);

                pr = new Product(_id, title,date_of_delivery,operator_id,amount,implementation_period, location_id, weight_category_id, location, weightCategory, operator);

            } while (cursor.moveToNext());
            cursor.close();
        }
        return pr;
    }
}


