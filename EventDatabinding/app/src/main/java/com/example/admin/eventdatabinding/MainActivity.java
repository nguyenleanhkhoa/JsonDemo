package com.example.admin.eventdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.admin.eventdatabinding.databinding.ActivityMainBinding;

import model.Temperature;

public class MainActivity extends AppCompatActivity implements MainActivityContact.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding= DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        MainActivityPresenter presenter=new MainActivityPresenter((MainActivityContact.View) MainActivity.this);

        Temperature temperature=new Temperature("");

        binding.setPresenters(presenter);
        binding.setTemp(temperature);
    }

    @Override
    public void showData(Temperature temperature) {
        Toast.makeText(this, temperature.getCelsius()+"", Toast.LENGTH_SHORT).show();
    }
}
