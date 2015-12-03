package com.example.eve.myapplication;

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

        String[] resultStrings = new String[countAnInt];
        for (int i = 0; i < resultStrings.length; i++) {
            resultStrings[i] = "ครั้งที่ " + Integer.toString(i + 1) + " ==> " + Integer.toString(intStartTime + 2);
        }

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
