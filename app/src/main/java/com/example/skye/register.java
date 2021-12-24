package com.example.skye;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.skye.database.DBHelper;

public class register extends AppCompatActivity {

    // connect xml part views
    EditText userEmail, userpwd, userCpwd, userrole;
    Button mBtnList;
    public boolean isfieldsvalidated=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userEmail = findViewById(R.id.useremail);
        userpwd = findViewById(R.id.userpwd);
        userCpwd = findViewById(R.id.userCpwd);
        userrole = findViewById(R.id.userrole);
    }

    // items adding  db
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addUser(View view) {
        Log.d("workflow", "Add Item addItem  method  Called");
        isfieldsvalidated = CheckAllFields(); // check text field empty validation

        if (isfieldsvalidated) {
            DBHelper dbHelper = new DBHelper(this);// calling db helper class

            long val;
            val = dbHelper.addUser(userEmail.getText().toString(),
                    userpwd.getText().toString());
            if(val > 0){
                Toast.makeText(this, "User Added Succesfully", Toast.LENGTH_SHORT).show();
                userEmail.setText("");userpwd.setText("");userrole.setText("");
                Intent loginIntent = new Intent(this, login.class);
                startActivity(loginIntent);
            }else{
                Toast.makeText(this, "User Added UnSuccesfully", Toast.LENGTH_SHORT).show();
                userEmail.setText("");userpwd.setText("");userrole.setText("");
            }

            Log.i("BTN Click", "Add Item Confirmation button clicked");
        }
    }

    // form validation
    private boolean CheckAllFields() {
        Log.d("workflow", "Add Item CheckAllFields  method  Called");
        if (userEmail.length() == 0) {
            userEmail.setError("This field is required");
            return false;
        }
//        if(!userpwd.equals(userCpwd)){
//            userCpwd.setError("Password Not matching");
//            return false;
//        }

        if (userpwd.length() == 0) {
            userpwd.setError("This field is required");
            return false;
        }

        return true;

    }
    public void login(View view) {
        Log.d("workflow", "goto viewItem activity");
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}

