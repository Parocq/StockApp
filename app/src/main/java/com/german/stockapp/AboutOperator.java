package com.german.stockapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.german.stockapp.dao.DAOOperator;
import com.german.stockapp.entity.Operator;

public class AboutOperator extends AppCompatActivity {

    int id;
    private int AccessLvlOfProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_operator);

        TextView textViewOperatorName, textViewFO00, textViewFO01, textViewFO02, textViewFO03, textViewOpId;

        Bundle bundle = getIntent().getExtras();// для перехода между активностями сохраняет данные
        id = bundle.getInt("id");
        AccessLvlOfProf = bundle.getInt("level");
        if (AccessLvlOfProf == 2){
            (findViewById(R.id.toChangeOperator)).setEnabled(false);
            (findViewById(R.id.toChangeOperator)).setVisibility(View.INVISIBLE);
        }

        DAOOperator daoOperator = new DAOOperator(MainActivity.db);
        Operator operator =  daoOperator.selectWhere(id);

        textViewFO00 = findViewById(R.id.textViewFO00);
        textViewFO01 = findViewById(R.id.textViewFO01);
        textViewFO02 = findViewById(R.id.textViewFO02);
        textViewFO03 = findViewById(R.id.textViewFO03);
        textViewOpId = findViewById(R.id.textViewOpId);
        textViewOperatorName = findViewById(R.id.textViewOperatorName);


        textViewOpId.setText(Integer.toString(operator.getId()));
        textViewOperatorName.setText(operator.getOperatorName());
        textViewFO00.setText(operator.getWorkDays().getDays());
        textViewFO01.setText(operator.getWorkShift().getShift());
        textViewFO02.setText(operator.getAuthorization().getLogin());
        textViewFO03.setText(operator.getAuthorization().getPass());

    }

    public void onChangeOperInfo(View view) {
        Intent intent = new Intent(this, RedactOperInfo.class);
        intent.putExtra("id_operator", id);
        startActivity(intent);
    }
}
