package com.example.admin.busprojectchinhthuc;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import Adapter.AdapterEmployer;
import DatabaseAdapter.DatabaseAdapter;
import Model.Employer;

public class Employer_List extends AppCompatActivity {
    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;
    ListView listView;
    ArrayList<Employer>Employ_list;
    AdapterEmployer adapterEmployer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer__list);
        Addcontrol();
        AddEvent();
        listView.setAdapter(adapterEmployer);
    }

    private void AddEvent() {
        getEmployeeDatacontext();
    }

    private void Addcontrol() {
        listView= (ListView) findViewById(R.id.listEmployer);
        Employ_list=new ArrayList<>();
        adapterEmployer=new AdapterEmployer(Employer_List.this,R.layout.item_employer,Employ_list);

    }
    public void getEmployeeDatacontext(){
        database=DatabaseAdapter.initDatabase(Employer_List.this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM Employer",null);
        while(cursor.moveToNext()){
            int idemp=cursor.getInt(0);
            String pass=cursor.getString(1);
            String name=cursor.getString(2);
            String birthday=cursor.getString(3);
            String phone=cursor.getString(4);
            String email=cursor.getString(5);
            String address=cursor.getString(6);
            int departid=cursor.getInt(7);
            int adminid=cursor.getInt(8);
            Employer employ=new Employer(idemp,name,pass,birthday,phone,email,address,departid,adminid);
            Employ_list.add(employ);

        }
        adapterEmployer.notifyDataSetChanged();
    }
}
