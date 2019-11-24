package com.german.stockapp.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;


import com.german.stockapp.entity.WeightCategory;
import com.german.stockapp.entity.WorkDays;


public class DAOWeightCategory {

    SQLiteDatabase db;

    public DAOWeightCategory (SQLiteDatabase db) {this.db = db;}

        public void insert(WeightCategory obj) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", obj.getId());
            contentValues.put("title", obj.getTitle());
            contentValues.put("min_weight", obj.getMin_weight());
            contentValues.put("max_weight", obj.getMax_weight());


            db.insertOrThrow("weight_category", null, contentValues);

    }

    public void update(WeightCategory obj) {

    }

    public void delete(WeightCategory obj) {

    }

}
