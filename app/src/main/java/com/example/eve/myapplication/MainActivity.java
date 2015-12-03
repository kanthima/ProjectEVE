package com.example.eve.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
   //Explicit
    private timeTABEL objtimeTABLE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connected Database
        connectedDatabase();
        //Tester Update
       // testerUpdate();




    }//onCreate




    public void clickHistory(View view){
        Intent objIntent = new Intent(MainActivity.this,History.class);
        startActivity(objIntent);

    }//clickHistory

    public void clickAdd (View view){
        
        // Show Intent
        Intent objIntent = new Intent(MainActivity.this,FormRecordTimeActivity.class);
        startActivity(objIntent);

    }// clicAdd

    public void clickCalender(View view ) {

        Intent objIntent = new Intent(MainActivity.this, CalandaActivity.class);
        startActivity(objIntent);

    }//click Calender

    public void clickReport(View view) {
        Intent objIntent = new Intent(MainActivity.this, ReportActivity.class);
        startActivity(objIntent);
    }//click report


    private void testerUpdate() {
        objtimeTABLE.addNewValueToSQLite("test","30/09/58",3,"sub culture");
    }//tesrterUpdate


    private void connectedDatabase() {
        objtimeTABLE = new timeTABEL(this);
    }//connectedDatabase

    
}//Main Class
