package com.example.admin.expandlelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }
    public void addControl(){
        expandableListView= (ExpandableListView) findViewById(R.id.expanded);
    }
    public void addEvent(){
        expandleAdapter adapter= new expandleAdapter(MainActivity.this);
        expandableListView.setAdapter(adapter);
    }
}
