package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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


        // Products data
        DAOProduct daoProduct = new DAOProduct(db);
        daoProduct.insert(new Product("Вилки", "2019-02-01 9:34:09", 1, 300, "2020-10-01", 1,2));
        daoProduct.insert(new Product("Ложки", "2015-03-01 9:34:09", 1, 300, "2022-03-01", 2,2));
        daoProduct.insert(new Product("Ножи", "2017-04-01 9:34:09", 2, 300, "2019-01-20", 3,2));
        daoProduct.insert(new Product("Плиты", "2018-10-01 9:34:09", 3, 20, "2020-02-21", 4,3));
        daoProduct.insert(new Product("Морозильники", "2017-01-01 9:34:09", 1, 4, "2020-04-12", 5,3));
        daoProduct.insert(new Product("Кружки", "2014-02-01 9:34:09", 5, 100, "2029-05-03", 6,2));
        daoProduct.insert(new Product("Полотенца", "2019-07-01 9:34:09", 6, 200, "2023-06-29", 7,1));
        daoProduct.insert(new Product("Тарелки", "2019-10-11 9:34:09", 4, 100, "2020-07-11", 8,2));
        daoProduct.insert(new Product("Кастрюли", "2018-07-01 9:34:09", 5, 80, "2020-08-26", 9,2));
        daoProduct.insert(new Product("Губки", "2018-05-01 9:34:09", 2, 300, "2022-11-07", 10,1));


        // Weight_category DATA
        DAOWeightCategory daoWeightCategory = new DAOWeightCategory(db);
        daoWeightCategory.insert(new WeightCategory(1, "Лёгкий", 0,300));
        daoWeightCategory.insert(new WeightCategory(2, "Средний", 301,1000));
        daoWeightCategory.insert(new WeightCategory(3, "Тяжёлый", 1001,10000));


        // Work_shift data
        DAOWorkShift daoWorkShift = new DAOWorkShift(db);
        daoWorkShift.insert(new WorkShift(1, "Первая"));
        daoWorkShift.insert(new WorkShift(2, "Вторая"));

        //Work_days data
        DAOWorkDays daoWorkDays = new DAOWorkDays(db);
        daoWorkDays.insert(new WorkDays(1, "Понедельник, среда, пятница"));
        daoWorkDays.insert(new WorkDays(2, "Вторник, четверг, суббота"));
        daoWorkDays.insert(new WorkDays(3, "Среда, воскресенье"));
        daoWorkDays.insert(new WorkDays(3, "Понедельник, четверг"));
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
