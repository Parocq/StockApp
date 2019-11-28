package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AccessLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_level);
    }

    public void onUnClick(View view){
        Intent intent = new Intent(this, MainActivity.class);// Переход на другую активность
        startActivity(intent);
    }

    public void onProductsCatagol(View view) {
        Intent intent = new Intent(this, ProductsCatagol.class);// Переход на другую активность
        startActivity(intent);
    }
}
