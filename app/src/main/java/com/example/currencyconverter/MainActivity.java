package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    String[] items = { "United States - Dollar", "Vietnam - Dong", "Japan - Yen", "Korea - Won",
            "Malaysia - Ringgit", "Philippines - Peso", "United Kingdom - Pound" };
    double[] ratio = {1, 23177, 134.42, 1279.32, 4.40, 53.05, 0.8118};
    Spinner fromSpinner;
    Spinner toSpinner;
    Button convert;
    EditText amount;
    EditText result;
    int from;
    int to;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        toSpinner = (Spinner) findViewById(R.id.toSpinner);
        convert = (Button) findViewById(R.id.button);
        amount = (EditText) findViewById(R.id.amountEditText);
        result = (EditText) findViewById(R.id.resultText);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,items);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                from = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                to = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        }
        );

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(amount.getText().toString());
                a = a/ratio[from]*ratio[to];
                a = Math.round(a*10000)/10000.0000d;
                result.setText(Double.toString(a));
            }
        });

    }


}