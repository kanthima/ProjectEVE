package com.example.eve.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SaveHrActivity extends AppCompatActivity {


    //Explicit
    private TextView nameTextView, countTextView;
    private EditText hrEditText;
    private String nameString,countString,hrString;
    private int timesAnInt = 1,intCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_hr);

        receiveCount();

        bindWidget();

        showView();


    } //main method

    private void receiveCount() {
        String strCount = getIntent().getStringExtra("Count");
        intCount = Integer.parseInt(strCount);
    }

    private void showView() {

        nameString = getIntent().getStringExtra("Name");
        nameTextView.setText("ชื่อเชื้อ =" +nameString);


        countTextView.setText("ครั้งที่ = "+ Integer.toString(timesAnInt));


    }

    private void bindWidget() {

        nameTextView = (TextView) findViewById(R.id.txtSaveName);
        countTextView = (TextView) findViewById(R.id.txtSaveTime);
        hrEditText = (EditText) findViewById(R.id.edtSaveHr);

    }

    public void clickSaveButton(View view) {

        if (timesAnInt <intCount) {
            timesAnInt += 1;
            showView();


            //Update NewHr to SQLite

            updateNewHr();
        } else {

            Intent objIntent = new Intent(SaveHrActivity.this, ResultActivity.class);
            startActivity(objIntent);

        }

    }

    private void updateNewHr() {

        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("my_time.db",MODE_PRIVATE,null);

        objSqLiteDatabase.execSQL("UPDATE timeTABLE SET Count1='test' WHERE _id=1");

        timeTABEL objTimeTABEL = new timeTABEL(this);
        String strID = objTimeTABEL.searchID(nameString);
        Log.d("eve", "ID ==>" + strID);

    }//update new hr


}//mainclass
