package com.example.admin.busprojectchinhthuc;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import DatabaseAdapter.DatabaseAdapter;

public class InsertEmployee extends AppCompatActivity {
    public EditText edtidEm,edtadminidEm,edtdepartmEm,edtusernameEm,edtemailEm,edtpassEm,edtconfirmpassEm,edtbirthdayEm,edtaddressEm,edtphoneEm;
    public Button btncreateEm,btncancelEm;
    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_employee);
        addControl();
        addEvent();
    }

    private void addEvent() {
    }

    private void addControl() {
        edtidEm= (EditText) findViewById(R.id.edtidempl);
        edtadminidEm= (EditText) findViewById(R.id.edtadminidEmpl);
        edtdepartmEm= (EditText) findViewById(R.id.edtdepartmentidEmpl);
        edtusernameEm= (EditText) findViewById(R.id.edtusernameEmpl);
        edtemailEm= (EditText) findViewById(R.id.edtemailEmpl);
        edtpassEm= (EditText) findViewById(R.id.edtpasswordEmpl);
        edtconfirmpassEm= (EditText) findViewById(R.id.edtconfirmpassEmpl);
        edtbirthdayEm= (EditText) findViewById(R.id.edtbirthdayEmpl);
        edtaddressEm= (EditText) findViewById(R.id.edtaddressEmpl);
        edtphoneEm= (EditText) findViewById(R.id.edtphoneEmpl);
        btncreateEm= (Button) findViewById(R.id.btncreateEmpl);
        btncancelEm= (Button) findViewById(R.id.btncancelEmpl);
    }
    public void inputData(){

    }
    public void putDatatoDatabaseEmployee(){

        String idEmp=edtidEm.getText().toString();
        String adminEmp=edtadminidEm.getText().toString();
        String departEmp=edtdepartmEm.getText().toString();
        String username=edtusernameEm.getText().toString();
        String email=edtemailEm.getText().toString();
        String pass=edtpassEm.getText().toString();
        String confirmpass=edtconfirmpassEm.getText().toString();
        String birthday=edtbirthdayEm.getText().toString();
        String address=edtaddressEm.getText().toString();
        String phone=edtphoneEm.getText().toString();

        database=DatabaseAdapter.initDatabase(InsertEmployee.this, DATABASE_NAME);
        ContentValues insertEmploy=new ContentValues();
        insertEmploy.put("employer_Id",idEmp);
        insertEmploy.put("admin_Id",adminEmp);
        insertEmploy.put("department_Id",departEmp);
        insertEmploy.put("employer_Name",username);
        insertEmploy.put("employer_Email",email);
        insertEmploy.put("employer_PassWord",pass);
        insertEmploy.put("employer_Birthday",birthday);
        insertEmploy.put("employer_Address",address);
        insertEmploy.put("employer_Phone", phone);
        database.insert("Employer",null,insertEmploy);
    }
}
