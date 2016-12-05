package com.example.swarupa.assignment53;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this,generateData());
        listView.setAdapter(listViewAdapter);
        registerForContextMenu(listView);
    }

    private ArrayList<Item> generateData() {
       ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("ss","764386538765"));
        items.add(new Item("s1","76438653365"));
        items.add(new Item("s2","7643865433875"));
        return  items;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle()=="Call"){
            Toast.makeText(getApplicationContext(),"Calling Code",Toast.LENGTH_LONG).show();
        }
        else if (item.getTitle()=="SMS")
        {
            Toast.makeText(getApplicationContext(),"Sending Sms Code",Toast.LENGTH_LONG).show();
        }
        else
          return false;
        return true;
    }
}
