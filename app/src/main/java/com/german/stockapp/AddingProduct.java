package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.german.stockapp.dao.DAOLocation;
import com.german.stockapp.dao.DAOProduct;
import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Location;
import com.german.stockapp.entity.Product;

public class AddingProduct extends AppCompatActivity {

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_product);


        final EditText editText0, editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8;

        editText0 = findViewById(R.id.editText0);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText7);
        editText8 = findViewById(R.id.editText8);

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

    public void onAddProduct(View view) {

        final EditText editText0, editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8;

        int id;

        DBHelper dbHelper = new DBHelper(this);// копируем экземпляр для чтения и редактирования
        db = dbHelper.getWritableDatabase();//

        editText0 = findViewById(R.id.editText0);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);

        editText6 = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText7);
        editText8 = findViewById(R.id.editText8);

        Location location = new Location(Integer.parseInt(editText6.getText().toString()),
                Integer.parseInt(editText7.getText().toString()),Integer.parseInt(editText8.getText().toString()));
        DAOLocation daoLocation = new DAOLocation(db);

        id = daoLocation.addLocation(location);

        Product product = new Product(editText0.getText().toString(), editText1.getText().toString(),
                Integer.parseInt(editText2.getText().toString()),Integer.parseInt(editText3.getText().toString()),
                editText4.getText().toString(),id, Integer.parseInt(editText5.getText().toString()));

        DAOProduct daoProduct = new DAOProduct(db);
        daoProduct.AddProduct(product);
    }
}
