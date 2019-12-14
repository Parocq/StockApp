package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
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
    private int AccessLvlOfProf;
//    private String searchFor;
//    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_catagol);

        db = MainActivity.db;
        DAOProduct product = new DAOProduct(db);

        Bundle bundle = getIntent().getExtras();// для перехода между активностями сохраняет данные
        AccessLvlOfProf = bundle.getInt("level");

        if (AccessLvlOfProf == 3) {
            (findViewById(R.id.AddNewProduct)).setEnabled(false);
            (findViewById(R.id.AddNewProduct)).setVisibility(View.INVISIBLE);
        }

        list = product.selectTitle();
        List<String> productsTitles = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            productsTitles.add(list.get(i).getTitle());
        }

        listView = findViewById(R.id.ListViewEl);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productsTitles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();
    }


    public void buttonSearch(View view) {
        EditText editTextSearchTxt;
        String searchFor;
        DAOProduct daoProduct = new DAOProduct(db);
        editTextSearchTxt = findViewById(R.id.editTextSearch);
        searchFor = editTextSearchTxt.getText().toString();
        list = daoProduct.selectTitleLike(searchFor);
        List<String> productsSearched = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            productsSearched.add(list.get(i).getTitle());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productsSearched);
        listView.setAdapter(adapter);
    }

    public void ClearSearchFild(View view) {
        TextView editTextSearch = new TextView(this);
        editTextSearch = (TextView) findViewById(R.id.editTextSearch);
        editTextSearch.setText("");
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
        intent.putExtra("level", AccessLvlOfProf);
        startActivity(intent);
    }

    public void onAddProdClick(View view) {
        Intent intent = new Intent(this, AddingProduct.class);// Переход на другую активность
        startActivity(intent);
    }

    public void onSortClick(View view) {
        DAOProduct daoProduct = new DAOProduct(db);
        int selected;
        Spinner spinner = findViewById(R.id.spinnerSort);
        selected = Integer.valueOf(spinner.getSelectedItemPosition());
        switch (selected) {
            case 1:
                list = daoProduct.sortByID1();
            case 2:
                list = daoProduct.sortByID2();
            case 3:
                list = daoProduct.sortByName1();
            case 4:
                list = daoProduct.sortByName2();
        }
        List<String> sortedProducts = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            sortedProducts.add(list.get(i).getTitle());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sortedProducts);
        listView.setAdapter(adapter);
    }

}

