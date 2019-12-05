package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.german.stockapp.dao.DAORoles;


public class AccessLevel extends AppCompatActivity {

    private int AccessLvlOfProf;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_level);

        db = MainActivity.db;

        DAORoles roles = new DAORoles(db);

        Bundle bundle = getIntent().getExtras();// для перехода между активностями сохраняет данные
        AccessLvlOfProf = bundle.getInt("level");
        String role_name= roles.selectTitleById(AccessLvlOfProf);

        TextView TextView2;
        TextView2 = findViewById(R.id.textView2);
        TextView2.setText(role_name);


        if (AccessLvlOfProf == 3){
            (findViewById(R.id.buttonToOperators)).setEnabled(false);
            (findViewById(R.id.buttonToOperators)).setVisibility(View.INVISIBLE);
        }

    }

    public void onUnClick(View view){
        Intent intent = new Intent(this, MainActivity.class);// Переход на другую активность
        startActivity(intent);
    }

    public void onProductsCatagol(View view) {
        Intent intent = new Intent(this, ProductsCatagol.class);// Переход на другую активность
        startActivity(intent);

    }

    public void onOperatorsCatalog(View view) {
        Intent intent = new Intent(this, OperatorsCatalog.class);// Переход на другую активность
        startActivity(intent);
    }
}
