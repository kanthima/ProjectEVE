

package com.example.eve.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeFormatException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class FormRecordTimeActivity extends Activity {
    //Explicit
    private TextView txtShowDate;
    private EditText edtCount, edtName, edtData;
    private String strShowDate, strCount, strName, strData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_record_time);
        //Bind Widget
        bindWidget();
        //get Time from Device
        getTimeFromDevice();




    }//onCreate



    public void clickSave(View view ){

        strCount = edtCount.getText().toString().trim();
        if (strCount.equals("")) {
            showAlert();
        }
        strName = edtName.getText().toString().trim();
        if (strName.equals("")){
            showAlert();
        }

        strData = edtData.getText().toString();
        if (strData.equals(""))
         showLog();
            confirmData();

    }//clickSave

    private void confirmData() {

          AlertDialog.Builder objAlert = new AlertDialog.Builder(this);
          objAlert.setTitle("Are You Sure?");
          objAlert.setMessage("Date =" + strShowDate + "\n" +"Name =" + strName + "\n" +
                  "Count =" + strCount + "\n" + "Data =" + strData);
          objAlert.setCancelable(false);
          objAlert.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
              }
          });
          objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  upDatatoSOLite();
              }
          });
        objAlert.show();
    }//confirmData



    public  void  clickGo (View view){
        Intent objIntent = new Intent(FormRecordTimeActivity.this,FormCount.class);
        startActivity(objIntent);

    }// clickGo


    private void upDatatoSOLite() {
        timeTABEL objtimeTABLE = new timeTABEL(this);
        long inSertData = objtimeTABLE.addNewValueToSQLite(strName,strShowDate,Integer.parseInt(strCount),strData);
        edtName.setText("");
        edtCount.setText("");
        edtData.setText("");
        Toast.makeText(FormRecordTimeActivity.this,"Add Data Finish",Toast.LENGTH_SHORT).show();

    }//upDateSQLite

    private void showLog() {
        Log.d("count", "Time = " + strShowDate);
        Log.d("count", "count = " + strCount);
        Log.d("name","name ="+ strName);
        Log.d("data","data =" + strData);
    }// show Log

    private void showAlert() {

        AlertDialog.Builder objAlert = new AlertDialog.Builder(this);
        objAlert.setIcon(R.drawable.bg10);
        objAlert.setTitle("Have Space");
        objAlert.setMessage("Please Fill in the Blank");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
            }
        });
          objAlert.show();
    }//show Alert


    private void getTimeFromDevice() {
        DateFormat objDateFormat = new SimpleDateFormat("dd/MM/yy 'at' HH:mm:ss a zzz" );

        Date objDate = new Date(); 

        strShowDate = objDateFormat.format(objDate);

        txtShowDate.setText(strShowDate);

    }//getTimeFromDevice

    private void bindWidget() {
        txtShowDate = (TextView) findViewById(R.id.txtShowDate);
        edtCount = (EditText) findViewById(R.id.edtCount);
        edtName = (EditText) findViewById(R.id.edtName);
        edtData = (EditText) findViewById(R.id.edtData);
    }//bindWidget

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form_record_time, menu);
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
    }// MainClass
}
