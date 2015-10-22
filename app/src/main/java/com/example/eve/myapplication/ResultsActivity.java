package com.example.eve.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);





    }

    public void clickHome(View view) {
        Intent objIntent = new Intent(ResultsActivity.this, MainActivity.class);
        startActivity(objIntent);
    }

}//Main Class
