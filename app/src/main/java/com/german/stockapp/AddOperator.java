package com.german.stockapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.german.stockapp.dao.DAOAuthorization;
import com.german.stockapp.dao.DAOOperator;
import com.german.stockapp.dao.DAOWorkDays;
import com.german.stockapp.dao.DAOWorkShift;
import com.german.stockapp.db.DBHelper;
import com.german.stockapp.entity.Authorization;
import com.german.stockapp.entity.MD5Util;
import com.german.stockapp.entity.Operator;
import com.german.stockapp.entity.WorkDays;
import com.german.stockapp.entity.WorkShift;

import java.util.ArrayList;

public class AddOperator extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_operator);

        final EditText editText0, editText1, editText2, editText3, editText4;

        editText0 = findViewById(R.id.editText0);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        editText0.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText0.getText().toString().isEmpty()) {
                    editText0.setBackgroundColor(Color.RED);
                } else  {
                    editText0.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText1.getText().toString().isEmpty()) {
                    editText1.setBackgroundColor(Color.RED);
                } else  {
                    editText1.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText2.getText().toString().isEmpty()) {
                    editText2.setBackgroundColor(Color.RED);
                } else  {
                    editText2.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText3.getText().toString().isEmpty()) {
                    editText3.setBackgroundColor(Color.RED);
                } else  {
                    editText3.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText4.getText().toString().isEmpty()) {
                    editText4.setBackgroundColor(Color.RED);
                } else  {
                    editText4.setBackgroundColor(0xAD08CC00);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void CreateOperator(View view) {
        final EditText editText0, editText1, editText2, editText3, editText4;

        editText0 = findViewById(R.id.editText0);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        DBHelper dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        String fio = editText0.getText().toString();
        if (fio.isEmpty()){
            AlertDialog.Builder noFIO = new AlertDialog.Builder(AddOperator.this);
            noFIO.setMessage("У сотрудника должно быть имя..")
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }});

            AlertDialog alert = noFIO.create();
            alert.setTitle("Ошибка ввода");
            alert.show();
        }

        DAOWorkDays workDays = new DAOWorkDays(db);
        ArrayList<WorkDays> workdaysList = workDays.selectWD();
        int wd_id =0;
        String wd = editText1.getText().toString();
        if (wd.isEmpty()){
            AlertDialog.Builder noWD = new AlertDialog.Builder(AddOperator.this);
            noWD.setMessage("Необходимо заполнить поле рабочих дней.")
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }});

            AlertDialog alert = noWD.create();
            alert.setTitle("Ошибка ввода");
            alert.show();
        }
        int wd_check = 0;
        for (int i=0; i<workdaysList.size();i++){
            if (workdaysList.get(i).getDays().equals(editText1.getText())){
                wd_id = workdaysList.get(i).getId();
            } else {
                wd_check = 1;
            }
        }
        if (wd_check==1){
            WorkDays new_days = new WorkDays(wd);
            wd_id = workDays.addWD(new_days);
        }

        int ws_id = 0;
        String ws = editText2.getText().toString();
        DAOWorkShift workShift = new DAOWorkShift(db);
        ArrayList<WorkShift> workshiftList = workShift.selectWS();
        for (int i=0; i<workshiftList.size();i++){
            if (workshiftList.get(i).getShift().equals(editText2.getText().toString())){
                ws_id = workshiftList.get(i).getId();
                break;
            }
            }
        if (ws_id == 0) {
            AlertDialog.Builder noWS = new AlertDialog.Builder(AddOperator.this);
            noWS.setMessage("Введите существующую рабочую смену:" +
                    "1)Первая" +
                    "2)Вторая" +
                    "3)Ночная" +
                    "3)Полная")
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

            AlertDialog alert = noWS.create();
            alert.setTitle("Ошибка заполнения");
            alert.show();
            editText2.setText("");
            ws = editText2.getText().toString();
        }


        DAOAuthorization daoAuthorization = new DAOAuthorization(db);
        ArrayList<Authorization> passList = daoAuthorization.selectLogPas();
        int loginCheck= 0;
        String login = editText3.getText().toString();
        String pass = editText4.getText().toString();
        String passMD5 = MD5Util.md5Custom(pass);
        for (int i=0; i<passList.size();i++){
            if (passList.get(i).getLogin().equals(login)) {
                loginCheck = 1;
                break;
            }
            if(loginCheck == 1){
                AlertDialog.Builder noWC = new AlertDialog.Builder(AddOperator.this);
                noWC.setMessage("Данный логин уже занят!")
                        .setCancelable(false)
                        .setNegativeButton("ОК",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }});

                AlertDialog alert = noWC.create();
                alert.setTitle("Ошибка ввода");
                alert.show();
                editText3.setText("");
                editText4.setText("");
                login = editText3.getText().toString();
                pass = editText4.getText().toString();
                break;
            }
        }

        if (fio.isEmpty() || wd.isEmpty() || ws.isEmpty() || login.isEmpty() || pass.isEmpty() || login.isEmpty()) {
            AlertDialog.Builder noWC = new AlertDialog.Builder(AddOperator.this);
            noWC.setMessage("Вам необходимо заполнить все поля.")
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }});

            AlertDialog alert = noWC.create();
            alert.setTitle("Ошибка ввода");
            alert.show();
        }
        else {
            int operator_id;
            DAOOperator daoOperator = new DAOOperator(db);
            Operator operator = new Operator(fio, wd_id, ws_id);
            operator_id = daoOperator.addOperator(operator);
            Authorization authorization = new Authorization(login, passMD5,3, operator_id);
            daoAuthorization.addAuthorization(authorization);
            AlertDialog.Builder added = new AlertDialog.Builder(AddOperator.this);
            added.setMessage("Оператор успешно добавлен")
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }});

            AlertDialog alert = added.create();
            alert.show();
        }
    }
}
