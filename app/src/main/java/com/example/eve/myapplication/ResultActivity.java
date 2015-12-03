package com.example.eve.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class ResultActivity extends AppCompatActivity {
    //explicit
    private int countAnInt,IDAnInt;
    private EditText StartTimeEditText;
    private ListView resultListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bindWidget();

        //Receive from intent
        receiveFormIntent();

        //Create listview
       // createListView();

    }//oncreate

    private void bindWidget() {
        StartTimeEditText = (EditText) findViewById(R.id.editText);
        resultListView = (ListView) findViewById(R.id.listView2);

    }

    public void ClickCalculate(View view) {

        String strStartTime = StartTimeEditText.getText().toString().trim();
        int intStartTime = Integer.parseInt(strStartTime);

        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("my_time.db", MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM timeTABLE", null);
        objCursor.moveToFirst();
        objCursor.moveToPosition(IDAnInt - 1);

        String[] strAdder = new String[countAnInt];

        String[] resultStrings = new String[countAnInt];
        String strColumn = null;
        for (int i = 0; i < resultStrings.length; i++) {

            strColumn = "Count" + Integer.toString(i + 1);
            strAdder[i] = objCursor.getString(objCursor.getColumnIndex(strColumn));

            resultStrings[i] = "ครั้งที่ " + Integer.toString(i + 1) + " ==> " +
                    Integer.toString(intStartTime + Integer.parseInt(strAdder[i]));
            intStartTime = intStartTime + Integer.parseInt(strAdder[i]);

        }//for

        //Create List View
        ResultAdapter objResultAdapter = new ResultAdapter(ResultActivity.this, resultStrings);
        resultListView.setAdapter(objResultAdapter);

    }//Click Calculate



    private void receiveFormIntent() {
        countAnInt = getIntent().getIntExtra("Count", 0);
        IDAnInt = getIntent().getIntExtra("ID", 1);


        Log.d("eve", "Count=" + Integer.toString(countAnInt));
        Log.d("eve", "ID=" + Integer.toString(IDAnInt));
    }


}//main class
