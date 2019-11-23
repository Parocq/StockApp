package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.german.stockapp.dao.DAOAuthorization;
import com.german.stockapp.dao.DAOLocation;
import com.german.stockapp.dao.DAOOperator;
import com.german.stockapp.dao.DAORoles;
import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Authorization;
import com.german.stockapp.entity.Location;
import com.german.stockapp.entity.Operator;
import com.german.stockapp.entity.Roles;

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

        // Authorization data
        DAOAuthorization daoAuthorization = new DAOAuthorization(db);
        daoAuthorization.insert(new Authorization("operatorMisha@sklad.by", "qwerty1", 3, 1));
        daoAuthorization.insert(new Authorization("SuperGruschik@sklad.by", "qwerty2", 3, 2));
        daoAuthorization.insert(new Authorization("IloveSlonov@sklad.by", "qwerty3", 3, 3));
        daoAuthorization.insert(new Authorization("VladIs12@sklad.by", "qwerty4", 3, 4));
        daoAuthorization.insert(new Authorization("ImOkay002@sklad.by", "qwerty5", 3, 5));
        daoAuthorization.insert(new Authorization("iKILLyouDONT@sklad.by", "qwerty6", 3, 6));

        daoAuthorization.insert(new Authorization("ManManager1995@sklad.by", "HardPass211", 1));//поменял местами ID роли
        daoAuthorization.insert(new Authorization("SomeBodyOnesToldME@sklad.by", "HereWeH0V", 2));//относительно MySQL, не забудь
        daoAuthorization.insert(new Authorization("ReachBOYZ@skald.by", "TryToHack007", 2));//заменить записку

        // Roles data
        DAORoles daoRoles = new DAORoles(db);
        daoRoles.insert(new Roles(1, "Director"));
        daoRoles.insert(new Roles(2, "Manager"));
        daoRoles.insert(new Roles(3, "Operator"));

        // Location data
        DAOLocation daoLocation = new DAOLocation(db);
        daoLocation.insert(new Location(1,1,1));
        daoLocation.insert(new Location(1,1,2));
        daoLocation.insert(new Location(1,1,3));
        daoLocation.insert(new Location(1,2,1));
        daoLocation.insert(new Location(1,2,2));
        daoLocation.insert(new Location(1,2,3));
        daoLocation.insert(new Location(1,3,1));
        daoLocation.insert(new Location(1,3,2));
        daoLocation.insert(new Location(1,3,3));
        daoLocation.insert(new Location(2,1,1));
        daoLocation.insert(new Location(2,1,2));
        daoLocation.insert(new Location(2,1,3));
        daoLocation.insert(new Location(2,2,1));
        daoLocation.insert(new Location(2,2,2));
        daoLocation.insert(new Location(2,2,3));
        daoLocation.insert(new Location(2,3,1));
        daoLocation.insert(new Location(2,3,2));
        daoLocation.insert(new Location(2,3,3));

        // Operators data
        DAOOperator daoOperator = new DAOOperator(db);
        daoOperator.insert(new Operator("Misha Shimanovich", 1, 1));
        daoOperator.insert(new Operator("Lesha German", 2, 1));
        daoOperator.insert(new Operator("Artyr Olshevski", 3, 1));
        daoOperator.insert(new Operator("Sania Starostil", 4, 1));
        daoOperator.insert(new Operator("Vasya Dotsky", 2, 2));
        daoOperator.insert(new Operator("Kirill Tereshen", 1, 2));
    }



    public void onClick(View view) {// Заполнение при нажатии
        String textLogin = editTextLogin.getText().toString();
        String textPassword = editTextLogin.getText().toString();
        //String text2 = Integer.parseInt(editTextLogin.getText().toString());// parse - перевод в INT
        //int text3 = Integer.parseInt(editText.getText().toString());

        DAOAuthorization daoAuthorization = new DAOAuthorization(db);
       // DAOAuthorization.insert(new Operator(text1, text2, text3));
    }
}
