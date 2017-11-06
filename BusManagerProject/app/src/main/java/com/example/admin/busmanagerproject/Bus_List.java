package com.example.admin.busmanagerproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

import Adapter.AdapterBusList;
import DatabaseAdapter.DatabaseAdapter;
import Model.*;
import Model.Bus;

public class Bus_List extends AppCompatActivity {
    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;
    ListView listBus;
    ArrayList<Bus>Buslist;
    AdapterBusList adapterBusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus__list);
        addControl();
        addEvent();
        listBus.setAdapter(adapterBusList);
    }

    private void addEvent() {
        getBusDatabaseContext();

    }

    private void addControl() {
        listBus= (ListView) findViewById(R.id.list_bus);
        Buslist=new ArrayList<>();
        adapterBusList=new AdapterBusList(Bus_List.this,R.layout.bus_item,Buslist);

    }
    public void getBusDatabaseContext(){
        database=DatabaseAdapter.initDatabase(Bus_List.this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM Bus",null);
        while (cursor.moveToNext()){
            int maXeBus=cursor.getInt(0);
            int soXeBus=cursor.getInt(1);
            String biensoxe=cursor.getString(2);

            Bus bus=new Bus(maXeBus,soXeBus,biensoxe);
            Buslist.add(bus);
        }
        adapterBusList.notifyDataSetChanged();

    }
}
