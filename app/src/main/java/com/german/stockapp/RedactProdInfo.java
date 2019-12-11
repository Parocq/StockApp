package com.german.stockapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

import java.util.ArrayList;

public class RedactProdInfo extends AppCompatActivity{

    SQLiteDatabase db;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redact_prod_info);

        final EditText editText0, editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8;

        Bundle bundle = getIntent().getExtras();// для перехода между активностями сохраняет данные
        id = bundle.getInt("id_product");

        DAOProduct daoProduct = new DAOProduct(MainActivity.db);
        Product product =  daoProduct.selectWhere(id);

        editText0 = findViewById(R.id.editText0);
        editText0.setText(product.getTitle());

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

    public void SubmitProdRedact(View view) {

        final EditText editText0, editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8;

        int location_id = 0, weight_categoty_id=0, locCheck=0;

        editText0 = findViewById(R.id.editText0);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);// weight_cat
        editText6 = findViewById(R.id.editText6);// line
        editText7 = findViewById(R.id.editText7);// rack
        editText8 = findViewById(R.id.editText8);// shelf

        DBHelper dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        String WK_name = editText5.getText().toString();
        if(WK_name.equals("Лёгкий")){
            weight_categoty_id = 1;
        } else if (WK_name.equals("Легкий")){
            weight_categoty_id = 1;
        } else if (WK_name.equals("Средний")) {
            weight_categoty_id = 2;
        } else if (WK_name.equals("Тяжелый")) {
            weight_categoty_id = 3;
        } else {
            AlertDialog.Builder noWC = new AlertDialog.Builder(RedactProdInfo.this);
            noWC.setMessage("Введите существующую весовую категорию:" +
                    "1)Лёгкий" +
                    "2)Средний" +
                    "3)Тяжёлый")
                    .setCancelable(false)
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }});

            AlertDialog alert = noWC.create();
            alert.setTitle("Ошибка заполнения");
            alert.show();
            editText5.setText("0");
        }

        DAOLocation daoLocation = new DAOLocation(db);
        ArrayList<Location> locationList = daoLocation.selectAll();

        int line = Integer.parseInt(editText6.getText().toString());
        int rack = Integer.parseInt(editText7.getText().toString());
        int shelf = Integer.parseInt(editText8.getText().toString());

        for (int i = 0; i < locationList.size(); i++) {
            if (locationList.get(i).getLine()== line &&
                    locationList.get(i).getRack() == rack &&
                    locationList.get(i).getShelf() == shelf)
            {
                location_id = locationList.get(i).getId();
                break;
            } else {
                locCheck = 1;
            }
        }
        if (locCheck == 1){
            Location location = new Location(line,rack,shelf);
            location_id = daoLocation.addLocation(location);
        }

        if (editText2.getText().toString().isEmpty()){
            editText2.setText("0");
        }

        if (editText3.getText().toString().isEmpty()){
            editText3.setText("0");
        }

        if (editText6.getText().toString().isEmpty()){
            editText6.setText("0");
        }

        if (editText7.getText().toString().isEmpty()){
            editText7.setText("0");
        }

        if (editText8.getText().toString().isEmpty()){
            editText8.setText("0");
        }

        if (editText0.getText().toString().isEmpty() || editText1.getText().toString().isEmpty() ||
                Integer.parseInt(editText2.getText().toString()) == 0 ||
                Integer.parseInt(editText3.getText().toString()) == 0 ||
                editText4.getText().toString().isEmpty() ||
                Integer.parseInt(editText6.getText().toString()) == 0 ||
                Integer.parseInt(editText7.getText().toString()) == 0 ||
                Integer.parseInt(editText8.getText().toString()) == 0)
        {
            AlertDialog.Builder retry = new AlertDialog.Builder(RedactProdInfo.this);
            retry.setMessage("Проверьте правильность введенных данных.")
                    .setCancelable(false)
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }});
            AlertDialog alert = retry.create();
            alert.setTitle("Ошибка заполнения");
            alert.show();

            if (Integer.parseInt(editText2.getText().toString()) == 0){
                editText2.setText("");
            }
            if (Integer.parseInt(editText3.getText().toString()) == 0){
                editText3.setText("");
            }
            if (Integer.parseInt(editText6.getText().toString()) == 0){
                editText6.setText("");
            }
            if (Integer.parseInt(editText7.getText().toString()) == 0){
                editText7.setText("");
            }
            if (Integer.parseInt(editText8.getText().toString()) == 0){
                editText8.setText("");
            }

        } else {
            Product product = new Product(editText0.getText().toString(), editText1.getText().toString(),
                    Integer.parseInt(editText2.getText().toString()),Integer.parseInt(editText3.getText().toString()),
                    editText4.getText().toString(),
                    location_id,// location_id
                    weight_categoty_id);//weight_category
            DAOProduct daoProduct = new DAOProduct(db);
            daoProduct.redactProd(product, id);

            AlertDialog.Builder retry = new AlertDialog.Builder(RedactProdInfo.this);
            retry.setMessage("Информация о товаре отредактирована.")
                    .setCancelable(false)
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }});
            AlertDialog alert = retry.create();
            alert.setTitle("Успех!");
            alert.show();
        }

    }
}
