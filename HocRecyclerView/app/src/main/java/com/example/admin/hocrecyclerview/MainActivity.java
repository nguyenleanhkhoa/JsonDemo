package com.example.admin.hocrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ArrayList<Student>hocsinh=new ArrayList<>();
        RecycleAdapter recycleAdapter=new RecycleAdapter(hocsinh,MainActivity.this);
        hocsinh.add(new Student("nguyen le anh khoa","14dth09"));
        hocsinh.add(new Student("Ngo dinh Khanh Nguyen","14dth05"));
        recyclerView.setAdapter(recycleAdapter);
    }
}
