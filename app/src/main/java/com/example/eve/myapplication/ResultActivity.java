package com.example.eve.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ResultActivity extends AppCompatActivity {
    //explicit
    private int countAnInt,IDAnInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Receive from intent
        receiveFormIntent();

    }//oncreate

    private void receiveFormIntent() {
        countAnInt = getIntent().getIntExtra("Count", 0);
        IDAnInt = getIntent().getIntExtra("ID", 1);


        Log.d("eve", "Count=" + Integer.toString(countAnInt));
        Log.d("eve", "ID=" + Integer.toString(IDAnInt));
    }


}//main class
