package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.german.stockapp.dao.DAOProduct;
import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Product;

public class AboutProd extends AppCompatActivity {

    int id;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_prod);

        TextView textViewProductTitle, textView3, textViewF01, textViewF02, textViewF03, textViewF04, textViewF05, textViewF07, textViewF08, textViewF09;

        Bundle bundle = getIntent().getExtras();// для перехода между активностями сохраняет данные
        id = bundle.getInt("id_product");

        DAOProduct daoProduct = new DAOProduct(MainActivity.db);
        Product product =  daoProduct.selectWhere(id);

        textView3 = findViewById(R.id.textView3);
        textView3.setText(Integer.toString(id));

        textViewProductTitle = findViewById(R.id.textViewOperatorName);
        textViewProductTitle.setText(product.getTitle());

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
        DBHelper dbHelper = new DBHelper(this);// копируем экземпляр для чтения и редактирования
        db = dbHelper.getWritableDatabase();//

        DAOProduct daoProduct = new DAOProduct(db);
        daoProduct.deleteByID(id);

       // db.delete("product", "_id = "+ id +"", null );

        Intent intent = new Intent(this, ProductsCatagol.class);// Переход на другую активность
        startActivity(intent);
//        Intent intent = new Intent(this, ProductsCatagol.class);
//        startActivityForResult(intent, 1)
        }

    public void onChangeProdClick(View v) {
        Intent intent = new Intent(this, RedactProdInfo.class);// Переход на другую активность
        intent.putExtra("id_product", id);
        startActivity(intent);
    }
}
