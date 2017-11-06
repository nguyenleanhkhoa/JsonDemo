package com.example.admin.busmanagerproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.AdapterNotification;
import DatabaseAdapter.DatabaseAdapter;
import Model.Employer;
import Model.Notification;

public class MainActivity extends AppCompatActivity {
    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;


    ListView listView;
    ArrayList<Notification> listnotificaition;
    AdapterNotification adapternoti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControl();
        AddEvent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //getDataBaseContext();

        getDatabaseNotification();
        listView.setAdapter(adapternoti);
        Intent intent=new Intent(MainActivity.this,Bus_List.class);
        startActivity(intent);
    }

    private void AddEvent() {
        listnotificaition=new ArrayList<>();
        adapternoti=new AdapterNotification(MainActivity.this,R.layout.item_annoucement,listnotificaition);
    }

    private void AddControl() {
        listView= (ListView) findViewById(R.id.listthongbao);
    }

    public int GetEmployer(int id,String password){
        int employer_id=0;
        try{
            database=DatabaseAdapter.initDatabase(MainActivity.this,DATABASE_NAME);
            Cursor cursor1 = database.rawQuery("SELECT * " +
                    "FROM Employer " +
                    "WHERE employer_Id = "+id
                    +" AND employer_Password = "+password,null);
            if(cursor1!=null){
                while(cursor1.moveToNext()){
                    employer_id=cursor1.getInt(0);
                }
                return employer_id;
            }
        }catch (Exception ex){
            return 0;
        }

        return employer_id;
    }
    public void getDataBaseEmployer(){
        database=DatabaseAdapter.initDatabase(MainActivity.this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM Employer WHERE admin_Id=1",null);
        while(cursor.moveToNext()){
            int em_Id=cursor.getInt(0);
            String em_pass=cursor.getString(1);
            String em_name=cursor.getString(2);
            String em_birth=cursor.getString(3);
            String em_phone=cursor.getString(4);
            String em_email=cursor.getString(5);
            String em_address=cursor.getString(6);
            int em_departmentId=cursor.getInt(7);
            int Admin_id=cursor.getInt(8);
            Employer employer=new Employer(em_Id,em_name,em_pass,em_birth,em_phone,em_email,em_address,em_departmentId,Admin_id);


        }

    }
    public void getDatabaseNotification(){
        database=DatabaseAdapter.initDatabase(MainActivity.this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM Notification ",null);
        while (cursor.moveToNext()){
            int sothongbao=cursor.getInt(0);
            String datethongbao=cursor.getString(1);
            String noidungthongbao=cursor.getString(2);
            int admin_id=cursor.getInt(3);
            Notification noti=new Notification(sothongbao,datethongbao,noidungthongbao,admin_id);
            listnotificaition.add(noti);
            adapternoti.notifyDataSetChanged();
     }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
