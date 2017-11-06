package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RatingBar ratig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratig= (RatingBar) findViewById(R.id.ratingBar);
        ratig.isIndicator();
        ratig.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
               Toast.makeText(MainActivity.this, v+"", Toast.LENGTH_SHORT).show();
           }
       });
    }
}
