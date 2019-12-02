package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutProd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_prod);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id_product");

        String Proverka = Integer.toString(id);

        TextView textView3 = new TextView(this);
        textView3 = (TextView) findViewById(R.id.textView3);

        textView3.setText(Proverka);
    }
}
