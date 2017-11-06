package com.example.admin.hocdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.hocdatabinding.databinding.ActivityMainBinding;

import model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding= DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        User user=new User("anh","khoa");
        binding.setUser(user);

    }
}
