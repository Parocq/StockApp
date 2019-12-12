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
    private List<Operator> list;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private int AccessLvlOfProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators_catalog);

        Bundle bundle = getIntent().getExtras();// для перехода между активностями сохраняет данные
        AccessLvlOfProf = bundle.getInt("level");
        if (AccessLvlOfProf == 2){
            (findViewById(R.id.CreateOperatorAcc)).setEnabled(false);
            (findViewById(R.id.CreateOperatorAcc)).setVisibility(View.INVISIBLE);
        }


        db = MainActivity.db;
        DAOOperator operator = new DAOOperator(db);

        List<Operator> list = operator.SelectFIO();

        List<String> operatorsNames = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            operatorsNames.add(list.get(i).getOperatorName());
        }

        listView = findViewById(R.id.ListViewOperators);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, operatorsNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();// изменения при удалении и т.п.

    }

    @Override
    public void onResume() {
        super.onResume();

        DAOOperator operator = new DAOOperator(db);

        list = operator.SelectFIO();

        List<String> operatorsNames = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            operatorsNames.add(list.get(i).getOperatorName());
        }

        listView = findViewById(R.id.ListViewOperators);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, operatorsNames);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, AboutOperator.class);// Переход на другую активность
        intent.putExtra("level", AccessLvlOfProf);
        intent.putExtra("id", position + 1);
        startActivity(intent);
    }

    public void ClearSearchField(View view) {
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
