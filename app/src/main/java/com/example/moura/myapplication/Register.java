package com.example.moura.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    NDb db;
    EditText pass;
    EditText   conpass;
    EditText users;
    Button btnregiter;
    TextView textloginr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db=new NDb(this);
        conpass=(EditText)findViewById(R.id.editText4);
        pass=(EditText)findViewById(R.id.editText3);
        users=(EditText)findViewById(R.id.editText2);
        btnregiter=(Button) findViewById(R.id.button_register);
        textloginr=(TextView) findViewById(R.id.textView_login);

        btnregiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = users.getText().toString().trim();
                String pwd= pass.getText().toString().trim();
                String pwa_con =conpass.getText().toString().trim();

                if (pwd.equals(pwa_con)){
                    long val=  db.addUser(user, pwd);
                    if(val >0) {
                        Toast.makeText(getApplicationContext(), "you have registered", Toast.LENGTH_SHORT).show();
                        Intent movetologin =new Intent(getApplicationContext(),Login.class);
                        startActivity(movetologin);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "registration Error", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(), "password is not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    }

