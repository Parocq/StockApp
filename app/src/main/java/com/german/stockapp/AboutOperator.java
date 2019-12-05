package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutOperator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_operator);

        TextView textViewFO00, textViewFO01, textViewFO02, textViewFO03, textViewOpId;

        textViewFO00 = findViewById(R.id.textViewFO00);
        textViewFO01 = findViewById(R.id.textViewFO01);
        textViewFO02 = findViewById(R.id.textViewFO02);
        textViewFO03 = findViewById(R.id.textViewFO03);
        textViewOpId = findViewById(R.id.textViewOpId);


    }

    public void onChangeOperInfo(View view) {
        Intent intent = new Intent(this, RedactOperInfo.class);// Переход на другую активность
        startActivity(intent);
    }
}
