package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.german.stockapp.dao.DAOProduct;
import com.german.stockapp.entity.Product;

public class RedactProdInfo extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redact_prod_info);

        TextView textViewProductTitle;
        final EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8;

        Bundle bundle = getIntent().getExtras();// для перехода между активностями сохраняет данные
        int id = bundle.getInt("id_product");

        DAOProduct daoProduct = new DAOProduct(MainActivity.db);
        Product product =  daoProduct.selectWhere(id);

        textViewProductTitle = findViewById(R.id.textViewProductTitle);
        textViewProductTitle.setText(product.getTitle());//цыувкаепнргошлщдзжэх
        // + "" + product.getLocation().getShelf()
        editText1 = findViewById(R.id.editText1);
        editText1.setText(product.getDate_of_delivery());


        String OpId = Integer.toString(product.getOperator_id());
        editText2 = findViewById(R.id.editText2);
        editText2.setText(OpId);

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText2.getText().toString().isEmpty()) {
                    editText2.setBackgroundColor(Color.RED);
                } else  {
                    editText2.setBackgroundColor(0xAD08CC00);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        String AmOnSt = Integer.toString(product.getAmount());
        editText3 = findViewById(R.id.editText3);
        editText3.setText(AmOnSt);

        editText4 = findViewById(R.id.editText4);
        editText4.setText(product.getImplementation_period());

        editText5 = findViewById(R.id.editText5);
        editText5.setText(product.getWeightCategory().getTitle());

        String line = Integer.toString(product.getLocation().getLine());
        editText6 = findViewById(R.id.editText6);
        editText6.setText(line);

        String rack = Integer.toString(product.getLocation().getRack());
        editText7 = findViewById(R.id.editText7);
        editText7.setText(rack);

        String shelf = Integer.toString(product.getLocation().getShelf());
        editText8 = findViewById(R.id.editText8);
        editText8.setText(shelf);
    }
}
