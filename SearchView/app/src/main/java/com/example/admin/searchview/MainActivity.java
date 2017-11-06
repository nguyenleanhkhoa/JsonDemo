package com.example.admin.searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView auto;
    ArrayList<String>tennhanvien;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        String[] ten=new String[]{"104","105","106","108","109"};
        adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,ten);
        addEvent();
    }

    private void addEvent() {

        auto.setAdapter(adapter);


    }

    private void addControl() {
        auto= (AutoCompleteTextView) findViewById(R.id.autoCompletetext);
    }
}
