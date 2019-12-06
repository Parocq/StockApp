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

        final EditText editText0, editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8;

        Bundle bundle = getIntent().getExtras();// для перехода между активностями сохраняет данные
        int id = bundle.getInt("id_product");

        DAOProduct daoProduct = new DAOProduct(MainActivity.db);
        Product product =  daoProduct.selectWhere(id);

        editText0 = findViewById(R.id.editText0);
        editText0.setText(product.getTitle());//цыувкаепнргошлщдзжэх

        editText1 = findViewById(R.id.editText1);
        editText1.setText(product.getDate_of_delivery());


        String OpId = Integer.toString(product.getOperator_id());
        editText2 = findViewById(R.id.editText2);
        editText2.setText(OpId);

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


        editText0.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText0.getText().toString().isEmpty()) {
                    editText0.setBackgroundColor(Color.RED);
                } else  {
                    editText0.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText1.getText().toString().isEmpty()) {
                    editText1.setBackgroundColor(Color.RED);
                } else  {
                    editText1.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

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

        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText3.getText().toString().isEmpty()) {
                    editText3.setBackgroundColor(Color.RED);
                } else  {
                    editText3.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText4.getText().toString().isEmpty()) {
                    editText4.setBackgroundColor(Color.RED);
                } else  {
                    editText4.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText5.getText().toString().isEmpty()) {
                    editText5.setBackgroundColor(Color.RED);
                } else  {
                    editText5.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText6.getText().toString().isEmpty()) {
                    editText6.setBackgroundColor(Color.RED);
                } else  {
                    editText6.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText7.getText().toString().isEmpty()) {
                    editText7.setBackgroundColor(Color.RED);
                } else  {
                    editText7.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText8.getText().toString().isEmpty()) {
                    editText8.setBackgroundColor(Color.RED);
                } else  {
                    editText8.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
