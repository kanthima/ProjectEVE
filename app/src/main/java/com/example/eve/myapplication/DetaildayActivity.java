package com.example.eve.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class DetaildayActivity extends AppCompatActivity {

    //Explicit
    private TextView dateTextView;
    private ListView dateListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailday);

        //BindWidget
        bindWidter();

        showDate();
    }//onCreate

    private void showDate() {

        String strDate = getIntent().getStringExtra("Date");
        dateTextView.setText(strDate);
    }


    private void bindWidter() {
        dateTextView = (TextView) findViewById(R.id.txtShowDateDetail);
        dateListView = (ListView) findViewById(R.id.listView);
    }

    public void clickBack(View view) {
        finish();
    }

    public void clickHome(View view) {
        Intent objIntent = new Intent(DetaildayActivity.this, MainActivity.class);
        startActivity(objIntent);
    }

}//MainClass
