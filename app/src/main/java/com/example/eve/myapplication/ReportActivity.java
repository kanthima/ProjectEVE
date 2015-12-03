package com.example.eve.myapplication;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class ReportActivity extends ListActivity{

    //Explicit
    private timeTABEL objtimeTABLE;
    private String[] strlistName;
    private int[] myTarget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        objtimeTABLE = new timeTABEL(this);

        createListView();
        setupAllArray();
    }//on create

    private void setupAllArray() {
        strlistName = objtimeTABLE.listName();
    }

    private void createListView() {

        MyAdapter objMyAdapter = new MyAdapter(ReportActivity.this,strlistName,myTarget);
        ListView objListView = (ListView) findViewById(R.id.listViewName);
        objListView.setAdapter(objMyAdapter);

    }


}// main class


