package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Operator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this);   //
        SQLiteDatabase db = dbHelper.getWritableDatabase();// создание базы данных

        
    }
}
