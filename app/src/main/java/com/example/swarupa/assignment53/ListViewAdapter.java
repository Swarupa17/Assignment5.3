package com.example.swarupa.assignment53;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by swarupa on 06-12-2016.
 */
public class ListViewAdapter extends ArrayAdapter<Item> {
    private final  Context context;
    ArrayList<Item> itemArrayList;
    public ListViewAdapter(Context context, ArrayList<Item> itemArrayList)
    {
        super(context,R.layout.contact_list,itemArrayList);
        this.context = context;
        this.itemArrayList = itemArrayList;


    }
    public  View getView (int position, View ConvertView ,ViewGroup viewGroup)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.contact_list,viewGroup,false);
        TextView textView = (TextView)rowView.findViewById(R.id.textView);
        TextView textView1=(TextView)rowView.findViewById(R.id.textView2);
        textView.setText(itemArrayList.get(position).getName());
        textView1.setText(itemArrayList.get(position).getNumber());

        return  rowView;
    }

}
