package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.german.stockapp.dao.DAOProduct;
import com.german.stockapp.entity.Product;

public class AboutProd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_prod);

        TextView textView3, textViewProductTitle;

        Bundle bundle = getIntent().getExtras();// глянь что там
        int id = bundle.getInt("id_product");

        String Proverka = Integer.toString(id);
        textView3 = findViewById(R.id.textView3);
        textView3.setText(Proverka);

/////////////////////////////////////////////////////////////////////////////////

        DAOProduct daoProduct = new DAOProduct(MainActivity.db);
        Product product =  daoProduct.selectWhere(id);

        textViewProductTitle = findViewById(R.id.textViewProductTitle);
        textViewProductTitle.setText(product.getTitle() + "" + product.getLocation().getShelf());//цыувкаепнргошлщдзжэх

    }
}
