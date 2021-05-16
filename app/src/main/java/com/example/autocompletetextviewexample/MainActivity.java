package com.example.autocompletetextviewexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //private static final String[] COUNTRIES = new String[]{"Afghanistan", "Albania", "Algria", "Angol", "India", "Pakistan", "Philippines"};
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] countries = getResources().getStringArray(R.array.countries);

        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        AutoCompleteTextView editText = findViewById(R.id.ac1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

        editText.setAdapter(adapter);
        editText.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // fetch the user selected value
        String item = parent.getItemAtPosition(position).toString();
        // create Toast with user selected value
        Toast.makeText(MainActivity.this, "Selected Item is: \t" + item, Toast.LENGTH_LONG).show();
        // set user selected value to the TextView
        tvDisplay.setText(item);
    }
}