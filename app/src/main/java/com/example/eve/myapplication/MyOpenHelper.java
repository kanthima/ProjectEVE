package com.example.eve.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eve on 9/23/2015.
 */
public class MyOpenHelper extends SQLiteOpenHelper{
   //Explicit
    private static final String DATABASE_NAME ="my_time.db";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_TABLE = "create table timeTABLE (_id integer primary key,"+"" +
            "name string,date string,count integer,data string);";



    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }//constructor






    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(CREATE_TABLE);
    }//onCreate








    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+CREATE_TABLE);
        onCreate(db);

    }
} //main class
