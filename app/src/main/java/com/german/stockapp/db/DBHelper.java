package com.german.stockapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String NAME_DATABASE = "stock";//константа имени базы данных
    public static final int DATABASE_VERSION=1;//задаем версию бд(чтобы работал он апгрейд если будем воодить)
    public static final  String TABLE_AUTHORIZATION = "authorization";// Константа имени таблицы?

    public static final String AUTHORIZATION_ID = "id";
    public static final String AUTHORIZATION_LOGIN = "login";
    public static final String AUTHORIZATION_PASS = "pass";
  //  public static final String AUTHORIZATION_ROLES_ID = "roles_id";
  //  public static final String AUTHORIZATION_OPERATOR_ID = "operator_id";



    public DBHelper(@Nullable Context context) { super(context, NAME_DATABASE, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE work_shift(id INTEGER PRIMARY KEY," +
                "shift TEXT);");


        db.execSQL("CREATE TABLE work_days(id INTEGER PRIMARY KEY," +
                "days TEXT);");


        db.execSQL("CREATE TABLE roles(id INTEGER PRIMARY KEY," +
                    "role_name TEXT);");


        db.execSQL("CREATE TABLE location(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "line INTEGER," +
                "rack INTEGER," +
                "shelf INTEGER);");


        db.execSQL("CREATE TABLE weight_category (id INTEGER PRIMARY KEY," +
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("drop table if exists " + );
    }
}
