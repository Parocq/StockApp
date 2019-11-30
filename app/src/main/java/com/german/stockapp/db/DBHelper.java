package com.german.stockapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.german.stockapp.dao.DAOAuthorization;
import com.german.stockapp.dao.DAOLocation;
import com.german.stockapp.dao.DAOOperator;
import com.german.stockapp.dao.DAOProduct;
import com.german.stockapp.dao.DAORoles;
import com.german.stockapp.dao.DAOWeightCategory;
import com.german.stockapp.dao.DAOWorkDays;
import com.german.stockapp.dao.DAOWorkShift;
import com.german.stockapp.entity.Authorization;
import com.german.stockapp.entity.Location;
import com.german.stockapp.entity.Operator;
import com.german.stockapp.entity.Product;
import com.german.stockapp.entity.Roles;
import com.german.stockapp.entity.WeightCategory;
import com.german.stockapp.entity.WorkDays;
import com.german.stockapp.entity.WorkShift;

public class DBHelper extends SQLiteOpenHelper {

    public static final String NAME_DATABASE = "stock";//константа имени базы данных
    public static final int DATABASE_VERSION=1;//задаем версию бд(чтобы работал он апгрейд если будем воодить)
    public static final  String TABLE_AUTHORIZATION = "authorization";// Константа имени таблицы?
    public static final String TABLE_PRODUCTS = "product";

    public static final String PRODUCTS_TITLE = "title";

    public static final String AUTHORIZATION_ID = "id";
    public static final String AUTHORIZATION_LOGIN = "login";
    public static final String AUTHORIZATION_PASS = "pass";
  //  public static final String AUTHORIZATION_ROLES_ID = "roles_id";
  //  public static final String AUTHORIZATION_OPERATOR_ID = "operator_id";



    public DBHelper(@Nullable Context context) { super(context, NAME_DATABASE, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE work_shift(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "shift TEXT);");

        db.execSQL("CREATE TABLE work_days(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "days TEXT);");

        db.execSQL("CREATE TABLE roles(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "role_name TEXT);");

        db.execSQL("CREATE TABLE location(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "line INTEGER," +
                "rack INTEGER," +
                "shelf INTEGER);");

        db.execSQL("CREATE TABLE weight_category (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "min_weight REAL," +
                "max_weight REAL);");

        db.execSQL("CREATE TABLE operator(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "operator_name TEXT," +
                "work_days_id INTEGER REFERENCES work_days(id)," +
                "work_shift_id INTEGER REFERENCES work_shift(id));");

        db.execSQL("CREATE TABLE authorization(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "login TEXT," +
                "pass TEXT," +
                "roles_id INTEGER REFERENCES roles(id)," +
                "operator_id INTEGER REFERENCES operator(id));");

        db.execSQL("CREATE TABLE product(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "date_of_delivery TEXT," +
                "operator_id INTEGER REFERENCES operator(id)," +
                "amount INTEGER," +
                "implementation_period TEXT," +
                "location_id INTEGER REFERENCES location(id)," +
                "weight_category_id INTEGER REFERENCES weight_category(id));");

        // Work_shift data
        DAOWorkShift daoWorkShift = new DAOWorkShift(db);
        daoWorkShift.insert(new WorkShift( "Первая"));
        daoWorkShift.insert(new WorkShift( "Вторая"));

        //Work_days data
        DAOWorkDays daoWorkDays = new DAOWorkDays(db);
        daoWorkDays.insert(new WorkDays( "Понедельник, среда, пятница"));
        daoWorkDays.insert(new WorkDays( "Вторник, четверг, суббота"));
        daoWorkDays.insert(new WorkDays( "Среда, воскресенье"));
        daoWorkDays.insert(new WorkDays("Понедельник, четверг"));

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

        // Weight_category DATA
        DAOWeightCategory daoWeightCategory = new DAOWeightCategory(db);
        daoWeightCategory.insert(new WeightCategory( "Лёгкий", 0,300));
        daoWeightCategory.insert(new WeightCategory( "Средний", 301,1000));
        daoWeightCategory.insert(new WeightCategory( "Тяжёлый", 1001,10000));

        // Authorization data
        DAOAuthorization daoAuthorization = new DAOAuthorization(db);
        daoAuthorization.insert(new Authorization("operatorMisha@sklad.by", "qwerty1", 3, 1));
        daoAuthorization.insert(new Authorization("SuperGruschik@sklad.by", "qwerty2", 3, 2));
        daoAuthorization.insert(new Authorization("IloveSlonov@sklad.by", "qwerty3", 3, 3));
        daoAuthorization.insert(new Authorization("VladIs12@sklad.by", "qwerty4", 3, 4));
        daoAuthorization.insert(new Authorization("ImOkay002@sklad.by", "qwerty5", 3, 5));
        daoAuthorization.insert(new Authorization("iKILLyouDONT@sklad.by", "qwerty6", 3, 6));
        daoAuthorization.insert(new Authorization("login", "pass", 3, 7));

        daoAuthorization.insert(new Authorization("ManManager1995@sklad.by", "HardPass211", 1));//поменял местами ID роли
        daoAuthorization.insert(new Authorization("SomeBodyOnesToldME@sklad.by", "HereWeH0V", 2));//относительно MySQL, не забудь
        daoAuthorization.insert(new Authorization("ReachBOYZ@skald.by", "TryToHack007", 2));//заменить записку

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("drop table if exists " + );
    }
}
