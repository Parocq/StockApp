package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.german.stockapp.dao.DAOOperator;
import com.german.stockapp.entity.Operator;

import java.util.ArrayList;
import java.util.List;

public class OperatorsCatalog extends AppCompatActivity implements ListView.OnItemClickListener {

        SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators_catalog);

        db = MainActivity.db;
        DAOOperator operator = new DAOOperator(db);

        List<Operator> list = operator.SelectFIO();

        List<String> operatorsNames = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            operatorsNames.add(list.get(i).getOperatorName());
        }

        ListView listView = findViewById(R.id.ListViewOperators);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, operatorsNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, AboutOperator.class);// Переход на другую активность
        intent.putExtra("id_operator", position+1);
        startActivity(intent);
    }

    public void ClearSearchField (View view) {
            TextView editTextSearch = new TextView(this);
            editTextSearch = (TextView) findViewById(R.id.editTextSearch);
            editTextSearch.setText("");
    }

    public void buttonSearch(View view) {
    }

    public void onAddOpperClick(View view) {
        Intent intent = new Intent(this, AddOperator.class);
        startActivity(intent);
    }
}
