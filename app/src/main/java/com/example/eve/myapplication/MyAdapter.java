package com.example.eve.myapplication;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by eve on 11/29/2015.
 */
public class MyAdapter extends BaseAdapter {
    //Explicit
    private Context objContext;
    private String[] strNameS;
    private int[] intMytarget;
    public MyAdapter(Context context,String[] strName,int[] targetID) {

        this.objContext = context;
        this.strNameS = strName;
        this.intMytarget = targetID;


    }//consturteer
    @Override
    public int getCount() {
        return strNameS.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = objLayoutInflater.inflate(R.layout.list_view_name,parent,false);

        //Setup Text

        TextView listViewName = (TextView) view.findViewById(R.id.txtReName);
        listViewName.setText(strNameS[position]);

        //Setup Image

        ImageView listImageName = (ImageView) view.findViewById(R.id.imvName);
        listImageName.setBackgroundResource(intMytarget[position]);





        return view;
    }


}//main class
