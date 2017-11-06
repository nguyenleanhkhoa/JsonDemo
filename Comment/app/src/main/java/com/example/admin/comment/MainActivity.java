package com.example.admin.comment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btntest;
    EditText editText;
    CardView cardView;
    ImageButton btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
        cardView.setVisibility(View.INVISIBLE);

    }
    public void addControl(){
        cardView=findViewById(R.id.cardview1);
        editText=findViewById(R.id.edtcmt);
        btntest=findViewById(R.id.btntestdemo);
        btnSend=findViewById(R.id.imgbtnsend);
    }
    public void addEvent(){
        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
//                cardView.setVisibility(View.VISIBLE);
//                editText.requestFocus();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);
//
//                cardView.setVisibility(View.INVISIBLE);
            }
        });
    }



    @Override
    public void onBackPressed() {
        finish();
    }
}
