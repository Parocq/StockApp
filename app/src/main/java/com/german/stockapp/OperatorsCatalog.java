package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OperatorsCatalog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators_catalog);
    }

    public void ClearSearchField (View view) {
            TextView editTextSearch = new TextView(this);
            editTextSearch = (TextView) findViewById(R.id.editTextSearch);
            editTextSearch.setText("");
    }

    public void buttonSearch(View view) {
    }

    public void onAddProdClick(View view) {
        Intent intent = new Intent(this, AddOperator.class);
        startActivity(intent);
    }
}
