package com.example.eve.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by eve on 12/3/2015.
 */
public class ResultAdapter extends BaseAdapter{
    private Context objContext;
    private  String[] resultString;

    public ResultAdapter(Context objContext, String[] resultString) {
        this.objContext = objContext;
        this.resultString = resultString;
    }//constructor

    @Override
    public int getCount() {
        return resultString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View View, ViewGroup viewGroup) {
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.result_listview, viewGroup, false);

        TextView resultTextView = (TextView) objView1.findViewById(R.id.txtShowResult);
        resultTextView.setText(resultString[i]);


        return objView1;
    }
}//main class
