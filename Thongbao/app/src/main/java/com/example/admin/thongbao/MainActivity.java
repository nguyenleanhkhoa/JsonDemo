package com.example.admin.thongbao;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialogthongbao);
        EditText edtThongbao=dialog.findViewById(R.id.edtthongbao);
        Button btndang=dialog.findViewById(R.id.btndangthogbao);
        Button btnthoat=dialog.findViewById(R.id.btnthoat);
        dialog.show();
    }
}
