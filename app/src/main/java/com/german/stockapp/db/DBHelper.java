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
import com.german.stockapp.entity.MD5Util;
import com.german.stockapp.entity.Operator;
import com.german.stockapp.entity.Product;
import com.german.stockapp.entity.Roles;
import com.german.stockapp.entity.WeightCategory;
import com.german.stockapp.entity.WorkDays;
import com.german.stockapp.entity.WorkShift;

public class DBHelper extends SQLiteOpenHelper {

    public static final String NAME_DATABASE = "stock";//константа имени базы данных
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_AUTHORIZATION = "authorization";// Константа имени таблицы?


    public DBHelper(@Nullable Context context) {
        super(context, NAME_DATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE work_shift(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "shift TEXT);");

        db.execSQL("CREATE TABLE work_days(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "days TEXT);");

        db.execSQL("CREATE TABLE roles(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "role_name TEXT);");

        db.execSQL("CREATE TABLE location(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "line INTEGER," +
                "rack INTEGER," +
                "shelf INTEGER);");

        db.execSQL("CREATE TABLE weight_category (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "min_weight REAL," +
                "max_weight REAL);");

        db.execSQL("CREATE TABLE operator(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "operator_name TEXT," +
                "work_days_id INTEGER," +
                "work_shift_id INTEGER," +
                "FOREIGN KEY (work_days_id)  REFERENCES work_days(id)  ON DELETE CASCADE ON UPDATE CASCADE," +
                "FOREIGN KEY (work_shift_id)  REFERENCES work_shift(id)  ON DELETE CASCADE ON UPDATE CASCADE );");

        db.execSQL("CREATE TABLE authorization(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "login TEXT," +
                "pass TEXT," +
                "roles_id INTEGER," +
                "operator_id INTEGER," +
                "FOREIGN KEY (roles_id)  REFERENCES roles(id)  ON DELETE CASCADE ON UPDATE CASCADE," +
                "FOREIGN KEY (operator_id) REFERENCES operator(id)  ON DELETE CASCADE ON UPDATE CASCADE);");

        db.execSQL("CREATE TABLE product(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "date_of_delivery TEXT," +
                "operator_id INTEGER ," +
                "amount INTEGER," +
                "implementation_period TEXT," +
                "location_id INTEGER," +
                "weight_category_id INTEGER," +
                "FOREIGN KEY (operator_id) REFERENCES operator(id) ON DELETE CASCADE ON UPDATE CASCADE," +
                "FOREIGN KEY (location_id) REFERENCES location(id) ON DELETE CASCADE ON UPDATE CASCADE," +
                "FOREIGN KEY (weight_category_id) REFERENCES weight_category(id)  ON DELETE CASCADE ON UPDATE CASCADE);");

        // Work_shift data
        DAOWorkShift daoWorkShift = new DAOWorkShift(db);
        daoWorkShift.insert(new WorkShift("Первая"));
        daoWorkShift.insert(new WorkShift("Вторая"));
        daoWorkShift.insert(new WorkShift("Полная"));
        daoWorkShift.insert(new WorkShift("Ночная"));

        //Work_days data
        DAOWorkDays daoWorkDays = new DAOWorkDays(db);
        daoWorkDays.insert(new WorkDays("Понедельник, среда, пятница"));
        daoWorkDays.insert(new WorkDays("Вторник, четверг, суббота"));
        daoWorkDays.insert(new WorkDays("Среда, воскресенье"));
        daoWorkDays.insert(new WorkDays("Понедельник, четверг"));

        // Roles data
        DAORoles daoRoles = new DAORoles(db);
        daoRoles.insert(new Roles(1, "Директор"));
        daoRoles.insert(new Roles(2, "Мэнеджер"));
        daoRoles.insert(new Roles(3, "Оператор"));

        // Location data
        DAOLocation daoLocation = new DAOLocation(db);
        daoLocation.insert(new Location(1, 1, 1));
        daoLocation.insert(new Location(1, 1, 2));
        daoLocation.insert(new Location(1, 1, 3));
        daoLocation.insert(new Location(1, 2, 1));
        daoLocation.insert(new Location(1, 2, 2));
        daoLocation.insert(new Location(1, 2, 3));
        daoLocation.insert(new Location(1, 3, 1));
        daoLocation.insert(new Location(1, 3, 2));
        daoLocation.insert(new Location(1, 3, 3));
        daoLocation.insert(new Location(2, 1, 1));
        daoLocation.insert(new Location(2, 1, 2));
        daoLocation.insert(new Location(2, 1, 3));
        daoLocation.insert(new Location(2, 2, 1));
        daoLocation.insert(new Location(2, 2, 2));
        daoLocation.insert(new Location(2, 2, 3));
        daoLocation.insert(new Location(2, 3, 1));
        daoLocation.insert(new Location(2, 3, 2));
        daoLocation.insert(new Location(2, 3, 3));

        // Weight_category DATA
        DAOWeightCategory daoWeightCategory = new DAOWeightCategory(db);
        daoWeightCategory.insert(new WeightCategory("Лёгкий", 0, 300));
        daoWeightCategory.insert(new WeightCategory("Средний", 301, 1000));
        daoWeightCategory.insert(new WeightCategory("Тяжёлый", 1001, 10000));

        // Authorization data
        DAOAuthorization daoAuthorization = new DAOAuthorization(db);
        String Q,W,E,R,T,Y,U,I,O,P;
        Q = MD5Util.md5Custom("операторМиша");
        W = MD5Util.md5Custom("qwerty2");
        E = MD5Util.md5Custom("qwerty3");
        R = MD5Util.md5Custom("qwerty4");
        T = MD5Util.md5Custom("qwerty5");
        Y = MD5Util.md5Custom("qwerty6");
        U = MD5Util.md5Custom("оператора");
        I = MD5Util.md5Custom("администратора");
        O = MD5Util.md5Custom("HereWeH0V");
        P = MD5Util.md5Custom("менеджера");
        daoAuthorization.insert(new Authorization("операторМиша", Q, 3, 1));
        daoAuthorization.insert(new Authorization("SuperGruschik@sklad.by", W, 3, 2));
        daoAuthorization.insert(new Authorization("IloveSlonov@sklad.by", E, 3, 3));
        daoAuthorization.insert(new Authorization("VladIs12@sklad.by", R, 3, 4));
        daoAuthorization.insert(new Authorization("ImOkay002@sklad.by", T, 3, 5));
        daoAuthorization.insert(new Authorization("iKILLyouDONT@sklad.by",Y, 3, 6));
        daoAuthorization.insert(new Authorization("доступ", U, 3, 7));

        daoAuthorization.insert(new Authorization("доступ", I, 1));//поменял местами ID роли
        daoAuthorization.insert(new Authorization("SomeBodyOnesToldME@sklad.by", O, 2));//относительно MySQL, не забудь
        daoAuthorization.insert(new Authorization("доступ", P, 2));//заменить записку

        // Operators data
        DAOOperator daoOperator = new DAOOperator(db);
        daoOperator.insert(new Operator("Misha Shimanovich", 1, 1));
        daoOperator.insert(new Operator("Lesha German", 2, 1));
        daoOperator.insert(new Operator("Artyr Olshevski", 3, 1));
        daoOperator.insert(new Operator("Sania Starostil", 4, 1));
        daoOperator.insert(new Operator("Vasya Dotsky", 2, 2));
        daoOperator.insert(new Operator("Kirill Tereshen", 1, 2));
        daoOperator.insert(new Operator("Тестовый Аккаун", 1, 2));

        // Products data
        DAOProduct daoProduct = new DAOProduct(db);
        daoProduct.insert(new Product("Вилки", "2019-02-01 9:34:09", 1, 300, "2020-10-01", 1, 2));
        daoProduct.insert(new Product("Ложки", "2015-03-01 9:34:09", 1, 300, "2022-03-01", 2, 2));
        daoProduct.insert(new Product("Ножи", "2017-04-01 9:34:09", 2, 300, "2019-01-20", 3, 2));
        daoProduct.insert(new Product("Плиты", "2018-10-01 9:34:09", 3, 20, "2020-02-21", 4, 3));
        daoProduct.insert(new Product("Морозильники", "2017-01-01 9:34:09", 1, 4, "2020-04-12", 5, 3));
        daoProduct.insert(new Product("Кружки", "2014-02-01 9:34:09", 5, 100, "2029-05-03", 6, 2));
        daoProduct.insert(new Product("Полотенца", "2019-07-01 9:34:09", 6, 200, "2023-06-29", 7, 1));
        daoProduct.insert(new Product("Тарелки", "2019-10-11 9:34:09", 4, 100, "2020-07-11", 8, 2));
        daoProduct.insert(new Product("Кастрюли", "2018-07-01 9:34:09", 5, 80, "2020-08-26", 9, 2));
        daoProduct.insert(new Product("Губки", "2018-05-01 9:34:09", 2, 300, "2022-11-07", 10, 1));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // db.execSQL("drop table if exists " + );.
    }
}
