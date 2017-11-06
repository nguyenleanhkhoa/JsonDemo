package com.example.admin.busprojectchinhthuc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DatabaseAdapter.DatabaseAdapter;

public class Login extends AppCompatActivity {
    Button btnSignIn,btnSignUp;
    EditText edtUserMail, editUserPassword;

    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(this, ""+GetEmployer(123,"123456"), Toast.LENGTH_SHORT).show();
        initialize();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }
        });

    }
    public int GetEmployer(int id,String password){
        int employer_id=0;
        try{
            database=DatabaseAdapter.initDatabase(Login.this,DATABASE_NAME);
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
    private void initialize(){

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        edtUserMail = (EditText) findViewById(R.id.txtUserEmail);
        editUserPassword = (EditText) findViewById(R.id.txtPassword);
    }

    private void SignIn(){

        database=DatabaseAdapter.initDatabase(Login.this,DATABASE_NAME);
        if(edtUserMail.length() == 0 || editUserPassword.length() == 0){
            Toast.makeText(this, "Hãy điền đủ email và mật khẩu", Toast.LENGTH_SHORT).show();
        }
        else {
            String email = edtUserMail.getText().toString();
            String password = editUserPassword.getText().toString();

            Cursor cursorAdmin = database.rawQuery("SELECT admin_Email, admin_Password FROM Admin " +
                    "WHERE admin_Email like '" + email+"'" +
                    " AND admin_Password = " + password, null);

            Cursor cursorEmployer = database.rawQuery("SELECT employer_Email, employer_Password FROM Employer " +
                    "WHERE employer_Email like '" + email+"'" +
                    " AND employer_Password = " + password, null);

            while (cursorAdmin.moveToNext()) {

                if (cursorAdmin.getString(cursorAdmin.getColumnIndex("admin_Email")) != null) {

                    Toast.makeText(this, "admin", Toast.LENGTH_SHORT).show();
                }
            }

            while (cursorEmployer.moveToNext()) {

                if (cursorEmployer.getString(cursorEmployer.getColumnIndex("employer_Email")) != null) {

                    Intent intent=new Intent(this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "Employer", Toast.LENGTH_SHORT).show();

                }
            }

        }
    }
}
