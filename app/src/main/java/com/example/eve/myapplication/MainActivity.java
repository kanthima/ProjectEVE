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

    private void testerUpdate() {
        objtimeTABLE.addNewValueToSQLite("test","30/09/58",3,"sub culture");
    }//tesrterUpdate


    private void connectedDatabase() {
        objtimeTABLE = new timeTABEL(this);
    }//connectedDatabase

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}//Main Class
