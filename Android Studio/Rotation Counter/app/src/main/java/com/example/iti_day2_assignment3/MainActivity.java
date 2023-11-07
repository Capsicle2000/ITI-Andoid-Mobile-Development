package com.example.iti_day2_assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterTextView;
    private Button resetButton;

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counterTextView);
        resetButton = findViewById(R.id.resetButton);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter");
            Log.d("MainActivity", "Counter restored from savedInstanceState: " + counter++);
        } else {
            counter = 0;
            Log.d("MainActivity", "Counter not restored from savedInstanceState, setting to 0");
        }

        counterTextView.setText(String.valueOf(counter));

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                counterTextView.setText(String.valueOf(counter));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("counter", counter);
    }
}