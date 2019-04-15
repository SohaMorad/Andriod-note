package com.example.moura.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText txtuser;
    EditText txtpass;
    Button btnlogin;
    TextView txtlogin;
    NDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new NDb(this);
        txtuser=(EditText)findViewById(R.id.editText);
        txtpass=(EditText)findViewById(R.id.editText1);
        btnlogin=(Button) findViewById(R.id.button);
        txtlogin =(TextView)findViewById(R.id.text_rege);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =txtuser.getText().toString().trim();
                String pwd =txtpass.getText().toString().trim();
                Boolean res =db.checkUser(user,pwd);

                if(res == true) {
                    Toast.makeText(Login.this, " Login sucsseful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MyNotes.class);
                    startActivity(intent);

                }
                else

                    Toast.makeText(Login.this, " Error log in", Toast.LENGTH_SHORT).show();



            }
        });


        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerintent =new Intent(Login.this,Register.class);
                startActivity(registerintent);
            }
        });
    }


}




