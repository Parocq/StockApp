package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Authorization;
import com.german.stockapp.dao.DAOAuthorization;
import com.german.stockapp.entity.MD5Util;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextLogin, editText1Password;
    static SQLiteDatabase db;

    int AccessLvlOfProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLogin = findViewById(R.id.editTextLogin);
        editText1Password = findViewById(R.id.editText1Password);

        DBHelper dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
    }

    public void onBackPressed (){
        super.onBackPressed();
        finish();
    }


    public void onAuthorizationClick(View view) {
        String textLogin = editTextLogin.getText().toString();
        String textPassword = editText1Password.getText().toString();//
        String textPasswordMD5 = MD5Util.md5Custom(textPassword);

        DBHelper dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();


        Cursor cursor = db.query(DBHelper.TABLE_AUTHORIZATION, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            DAOAuthorization authorization = new DAOAuthorization(db);
            ArrayList<Authorization> list = authorization.selectAll();

            TextView textIncorrect = new TextView(this);
            textIncorrect = (TextView) findViewById(R.id.textIncorrect);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getLogin().equals(textLogin) && list.get(i).getPass().equals(textPasswordMD5)) {
                    AccessLvlOfProf = list.get(i).getRoles_id();// получаем роль
                    Intent intent = new Intent(this, AccessLevel.class);// Переход на другую активность
                    intent.putExtra("level", AccessLvlOfProf);
                    startActivity(intent);
                    finish();
                } else {
                    textIncorrect.setText("Login or password are incorrect");
                }
            }
        } else cursor.close();
    }
}


