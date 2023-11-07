package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText mobileNumber;
    private EditText message;
    private Button readSharedPref;
    private Button writeSharedPref;
    private Button reset;
    private Button closeButton;
    private Button writeFile;
    private Button readFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileNumber = findViewById(R.id.mobileNumberValue);
        message = findViewById(R.id.messageValue);

        reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("");
                mobileNumber.setText("");
            }
        });

        writeFile = findViewById(R.id.file_w);
        writeFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobileNumberValue = mobileNumber.getText().toString();
                String messageValue = message.getText().toString();
                try {
                    FileOutputStream fileOutputStream = openFileOutput("data.txt", MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write(mobileNumberValue + "\n" + messageValue);
                    outputStreamWriter.close();
                    Toast.makeText(MainActivity.this, "Data saved successfully to file", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        readFile = findViewById(R.id.file_r);
        readFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileInputStream = openFileInput("data.txt");
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String mobileNumberValue = bufferedReader.readLine();
                    String messageValue = bufferedReader.readLine();
                    bufferedReader.close();
                    mobileNumber.setText(mobileNumberValue);
                    message.setText(messageValue);
                    Toast.makeText(MainActivity.this, "Data loaded successfully from file", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        writeSharedPref = findViewById(R.id.sh_w);
        writeSharedPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = message.getText().toString();
                String mobileNum = mobileNumber.getText().toString();
                writeSharedPref(text,mobileNum);
            }
        });

        readSharedPref = findViewById(R.id.sh_r);
        readSharedPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
                String text = sharedPreferences.getString("message", "");
                String mobileNum = sharedPreferences.getString("mobileNumber", "");
                message.setText(text);
                mobileNumber.setText(mobileNum);
                Toast.makeText(MainActivity.this, "Data Loaded successfully from SH_Pref.", Toast.LENGTH_SHORT).show();
            }
        });

        closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void writeSharedPref(String message, String mobileNumber) {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("message", message);
        editor.putString("mobileNumber", mobileNumber);
        editor.commit();
        Toast.makeText(MainActivity.this, "Data saved successfully to SH_Pref.", Toast.LENGTH_SHORT).show();
    }
}