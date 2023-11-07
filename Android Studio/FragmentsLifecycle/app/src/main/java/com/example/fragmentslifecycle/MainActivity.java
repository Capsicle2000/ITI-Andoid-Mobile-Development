package com.example.fragmentslifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SecondFragment fragment = new SecondFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.secondfragmentContainerView, fragment)
                .commit();
    }

    @Override
    public void passData(String data){
        FirstFragment fragment = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.firstfragmentContainerView);
        FirstFragment.changeMessage(data);
    }
}