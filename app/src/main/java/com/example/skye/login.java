package com.example.skye;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.skye.database.DBHelper;
import  com.example.skye.admin.*;

public class login extends AppCompatActivity {
    EditText userLogin, userPassword,userrole;
    public boolean isfieldsvalidated=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userLogin = findViewById(R.id.loginemailtxt);
        userPassword = findViewById(R.id.loginpwdtxt);
    }

    // user adding  db
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void checkUser(View view) {
        Log.d("workflow", "check user addItem  method  Called");
        isfieldsvalidated = CheckAllFields(); // check text field empty validation

        if (isfieldsvalidated) {
            DBHelper dbHelper = new DBHelper(this);// calling db helper class
            String email = userLogin.toString().trim();
            String password = userPassword.toString().trim();

            Cursor cursor = dbHelper.getData("select * from User ");
           // String userEmail =  cursor.getString(1);

            int cursorCount = cursor.getCount();
            if (email == "chanuth@gmail.com" && password == "123") {
                Intent accountsIntent = new Intent(this,AdminMainActivity.class);
                //accountsIntent.putExtra("USEREMAIL", userEmail);
                startActivity(accountsIntent);
            } else if(cursorCount > 0){
                Intent accountsIntent = new Intent(this,MainActivity.class);
             //   accountsIntent.putExtra("USEREMAIL", userEmail);
                startActivity(accountsIntent);
            }else{
                Toast.makeText(this, "Please enter the valid information", Toast.LENGTH_SHORT).show();
            }



        }
    }

    // form validation
    private boolean CheckAllFields() {
        Log.d("workflow", "Add Item CheckAllFields  method  Called");
        if (userLogin.length() == 0) {
            userLogin.setError("This field is required");
            return false;
        }

        if (userPassword.length() == 0) {
            userPassword.setError("This field is required");
            return false;
        }

        return true;

    }
    public void register(View view) {
        Log.d("workflow", "goto viewItem activity");
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
}