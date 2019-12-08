package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.german.stockapp.dao.DAOProduct;
import com.german.stockapp.entity.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductsCatagol extends AppCompatActivity implements ListView.OnItemClickListener {

    SQLiteDatabase db;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private List<Product> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_catagol);

        db = MainActivity.db;
        DAOProduct product = new DAOProduct(db);

        list = product.selectTitle();
        List<String> productsTitles = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            productsTitles.add(list.get(i).getTitle());
        }

        listView = findViewById(R.id.ListViewEl);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productsTitles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();// изменения при удалении и т.п.
    }

    public void ClearSearchFild(View view) {
        TextView editTextSearch = new TextView(this);
        editTextSearch = (TextView) findViewById(R.id.editTextSearch);
        editTextSearch.setText("");
    }

    public void buttonSearch(View view) {
    }

    @Override
    public void onResume() {
        super.onResume();

        DAOProduct product = new DAOProduct(db);

        List<Product> list = product.selectTitle();

        List<String> productsTitles = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            productsTitles.add(list.get(i).getTitle());
        }

        listView = findViewById(R.id.ListViewEl);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productsTitles);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, AboutProd.class);// Переход на другую активность
        intent.putExtra("id_product", list.get(position).getId());
        startActivity(intent);
    }

    public void onAddProdClick(View view) {
        Intent intent = new Intent(this, AddingProduct.class);// Переход на другую активность
        startActivity(intent);
    }
}
