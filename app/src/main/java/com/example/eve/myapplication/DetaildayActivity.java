package com.example.eve.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DetaildayActivity extends AppCompatActivity {

    //Explicit
    private TextView dateTextView;
    private ListView dateListView;
    private String strDate,TAG="eve";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailday);

        //BindWidget
        bindWidter();

        showDate();

        //Create List Dailyplan

        createListDailyPlan();
    }//onCreate

    private void createListDailyPlan() {

        String[]strName =null;
        String[] strCount = null;


        try {
            SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("my_time.db",MODE_PRIVATE,null);
            Cursor objcursor = objSqLiteDatabase.rawQuery("SELECT * FROM timeTABLE WHERE date = " + "'" + strDate + "'",null);
            objcursor.moveToFirst();
            strName=new String[objcursor.getCount()];
            strCount=new String[objcursor.getCount()];
            Log.d(TAG,"จำนวน Cursor ==> "+ Integer.toString(objcursor.getCount()));

        }catch (Exception e){
            Toast.makeText(DetaildayActivity.this,"วันนี้ไม่มีงานอะไร",Toast.LENGTH_LONG).show();
        }

    }//Create List Dailyplan

    private void showDate() {

        strDate = getIntent().getStringExtra("Date");
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
