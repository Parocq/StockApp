package com.german.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class AddOperator extends AppCompatActivity {

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
    }
}
