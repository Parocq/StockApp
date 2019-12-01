package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.german.stockapp.dao.DAOProduct;
import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Product;


import java.util.ArrayList;
import java.util.List;


public class ProductsCatagol extends AppCompatActivity {

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_catagol);



//        Cursor cursor = db.query(DBHelper.TABLE_PRODUCTS, null, null, null, null, null, null);
//        if (cursor.moveToFirst()) { // дeлает первую запись курсор активной и проверяет, если ли вообще записи
//
//            DAOProduct product = new DAOProduct(db);
//
//            List<Product> list = product.selectTitle();
//            List<String> productsTitles = new ArrayList<>();
//
//
//            for(Product pr: list){
//                productsTitles.add(pr.getTitle());
//            }
//
////            String [] productsTitles = {};
//
//            ListView listView = (ListView) findViewById(R.id.ListViewEl);
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productsTitles);
//            listView.setAdapter(adapter);
//            cursor.close();
//
//
//        }
    }

    public void ClearSearchFild(View view) {
        TextView editTextSearch = new TextView(this);
        editTextSearch = (TextView) findViewById(R.id.editTextSearch);

        editTextSearch.setText("");
    }

    public void buttonSearch(View view) {
    }


}
