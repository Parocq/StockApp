package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.german.stockapp.dao.DAOOperator;
import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Operator;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText1, editText2;// обозначаем что у нас будут использоваться поля ввода
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText2);//писваиваем переменным соответсвующие поля ввода
        editText1 = findViewById(R.id.editText3);//
        editText2 = findViewById(R.id.editText4);//

        DBHelper dbHelper = new DBHelper(this);   //
        db = dbHelper.getWritableDatabase();// создание базы данных


        DAOOperator daoOperator = new DAOOperator(db);
        daoOperator.insert(new Operator("test", 1, 1));

    }

    public void onClick(View view) {// Заполнение при нажатии
        String text1 = editText.getText().toString();
        int text2 = Integer.parseInt(editText1.getText().toString());// parse - перевод в INT
        int text3 = Integer.parseInt(editText2.getText().toString());


        DAOOperator daoOperator = new DAOOperator(db);
        daoOperator.insert(new Operator(text1, text2, text3));
    }
}
