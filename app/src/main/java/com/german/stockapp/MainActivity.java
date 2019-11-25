package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.german.stockapp.dao.DAOAuthorization;
import com.german.stockapp.dao.DAOLocation;
import com.german.stockapp.dao.DAOOperator;
import com.german.stockapp.dao.DAOProduct;
import com.german.stockapp.dao.DAORoles;
import com.german.stockapp.dao.DAOWeightCategory;
import com.german.stockapp.dao.DAOWorkDays;
import com.german.stockapp.dao.DAOWorkShift;
import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Authorization;
import com.german.stockapp.entity.Location;
import com.german.stockapp.entity.Operator;
import com.german.stockapp.entity.Product;
import com.german.stockapp.entity.Roles;
import com.german.stockapp.entity.WeightCategory;
import com.german.stockapp.entity.WorkDays;
import com.german.stockapp.entity.WorkShift;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    EditText editTextLogin, editText1Password;// обозначаем что у нас будут использоваться поля ввода
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLogin = findViewById(R.id.editTextLogin);//писваиваем переменным соответсвующие поля ввода
        editText1Password = findViewById(R.id.editTextPassword);//

        DBHelper dbHelper = new DBHelper(this);   //
        db = dbHelper.getWritableDatabase();// вернет экземпляр БД доступный для чтения и редактирования
    }



    public void onClick(View view) {
        String textLogin = editTextLogin.getText().toString();// В переменные записывваем значения из TextEdit
        String textPassword = editTextLogin.getText().toString();//

        DBHelper dbHelper = new DBHelper(this);// копируем экземпляр для чтения и редактирования
        db = dbHelper.getWritableDatabase();//



        Cursor cursor = db.query(DBHelper.TABLE_AUTHORIZATION, null   ,null,null,null,null,null );
        if (cursor.moveToFirst()) { // длает первую запись курсор активной и проверяет, если ли вообще записи
            int idINDEX = cursor.getColumnIndex(DBHelper.AUTHORIZATION_ID);//получаем порядковые номера столбцов с помощью курсора КоламнИндекс
            int loginINDEX = cursor.getColumnIndex(DBHelper.AUTHORIZATION_LOGIN);
            int passINDEX = cursor.getColumnIndex(DBHelper.AUTHORIZATION_PASS);
                do {
                    if (textLogin == cursor.getString(cursor.getColumnIndex(DBHelper.AUTHORIZATION_LOGIN))
                            && textPassword == cursor.getString(cursor.getColumnIndex(DBHelper.AUTHORIZATION_PASS))) {
                        Intent intent = new Intent(this, AccessLevel.class);// Переход на другую активность
                        startActivity(intent);//
                    } else finish();

                } while (cursor.moveToNext()); // перебираем все, пока не доберемся до последней
            } else
                Log.d("mLog", "0 rows");
        cursor.close();




//        String textLogin = editTextLogin.getText().toString();
//        String textPassword = editTextLogin.getText().toString();
//        //String text2 = Integer.parseInt(editTextLogin.getText().toString());// parse - перевод в INT
//        //int text3 = Integer.parseInt(editText.getText().toString());
//
//        DAOAuthorization daoAuthorization = new DAOAuthorization(db);
//       // DAOAuthorization.insert(new Operator(text1, text2, text3));

Authorization authorization;
        ArrayList<Authorization> list = authorization.selectAll();

for(int i = 0; i < list.size; i++){
if(list.get(i).getLogin().equals(textLogin) && list.get(i).getPass().equals){
}
}
    }
}
