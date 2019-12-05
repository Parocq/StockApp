package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.german.stockapp.dao.DAOProduct;
import com.german.stockapp.entity.Product;

public class AboutProd extends AppCompatActivity {

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_prod);

        TextView textViewProductTitle, textViewF01, textViewF02, textViewF03, textViewF04, textViewF05, textViewF07, textViewF08, textViewF09;

        Bundle bundle = getIntent().getExtras();// для перехода между активностями сохраняет данные
        id = bundle.getInt("id_product");

        DAOProduct daoProduct = new DAOProduct(MainActivity.db);
        Product product =  daoProduct.selectWhere(id);

        textViewProductTitle = findViewById(R.id.textViewOperatorName);
        textViewProductTitle.setText(product.getTitle());//цыувкаепнргошлщдзжэх
                                                            // + "" + product.getLocation().getShelf()
        textViewF01 = findViewById(R.id.textViewF01);
        textViewF01.setText(product.getDate_of_delivery());

        String OpId = Integer.toString(product.getOperator_id());
        textViewF02 = findViewById(R.id.textViewF02);
        textViewF02.setText(OpId);

        String AmOnSt = Integer.toString(product.getAmount());
        textViewF03 = findViewById(R.id.textViewF03);
        textViewF03.setText(AmOnSt);

        textViewF04 = findViewById(R.id.textViewF04);
        textViewF04.setText(product.getImplementation_period());

        textViewF05 = findViewById(R.id.textViewF05);
        textViewF05.setText(product.getWeightCategory().getTitle());

        String line = Integer.toString(product.getLocation().getLine());
        textViewF07 = findViewById(R.id.textViewF07);
        textViewF07.setText(line);

        String rack = Integer.toString(product.getLocation().getRack());
        textViewF08 = findViewById(R.id.textViewF08);
        textViewF08.setText(rack);

        String shelf = Integer.toString(product.getLocation().getShelf());
        textViewF09 = findViewById(R.id.textViewF09);
        textViewF09.setText(shelf);
    }

    public void onDelProdButClick(View view) {
    }

    public void onChangeProdClick(View v) {
        Intent intent = new Intent(this, RedactProdInfo.class);// Переход на другую активность
        intent.putExtra("id_product", id);
        startActivity(intent);
    }
}
