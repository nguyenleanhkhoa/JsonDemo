package com.example.admin.recyclerview;

import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.recyclerview.product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerV;
    ArrayList<product>prod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addControl();
        addEvent();
    }

    private void addEvent() {
        recyclerV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
       prod=new ArrayList<>();
        product pro1=new product();
        pro1.setTenSP("Ten 1");
        pro1.setHinh(R.drawable.1);
    }

    private void addControl() {
        recyclerV= (RecyclerView) findViewById(R.id.recyclerView1);
    }
}
