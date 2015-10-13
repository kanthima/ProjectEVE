package com.example.eve.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditSQLiteActivity extends AppCompatActivity {

    //Explicit
    private EditText nameEditText,dateEditText,countEditText,dataEditText;
    private  String nameString,dateString,countString,dataString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sqlite);


        //Bind Widget

        bindWidget();
    }// onCreate

    public void clickUpdateSQLite(View view){
        deleteOnData();
    }

    private void deleteOnData() {

        int intID = getIntent().getIntExtra("id",0);
        if (intID != 0) {

            SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("my_time.db",MODE_PRIVATE,null);
            Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM timeTABLE",null);
            objSqLiteDatabase.delete("timeTABLE","_id"+"="+intID,null);
            Log.d("eve","Delete id = "+Integer.toString(intID));

        }
    }

    private void bindWidget() {

        nameEditText = (EditText) findViewById(R.id.edtNameED);
        dateEditText = (EditText) findViewById(R.id.edtDataED);
        countEditText = (EditText) findViewById(R.id.edtCountED);
        dataEditText = (EditText) findViewById(R.id.edtDataED);
    }
}//Main class
