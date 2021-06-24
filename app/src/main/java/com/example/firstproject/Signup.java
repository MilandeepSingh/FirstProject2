package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText edtName, edtPasswd, edtPasswd2;
    Button btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edtName = findViewById(R.id.edt_name_signup);
        edtPasswd = findViewById(R.id.edt_passwd_signup);

        edtPasswd2 =findViewById(R.id.edt_passwd2_signup);
        btnSignup = (Button) findViewById(R.id.btn_signup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, passwd, passwd2;
                name = edtName.getText().toString();
                passwd = edtPasswd.getText().toString();
                passwd2 = edtPasswd2.getText().toString();
                if(passwd.equals(passwd2)) {
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    intent.putExtra("usr_name", name);
                    intent.putExtra("usr_passwd", passwd);
                    startActivity(intent);
                }
                else Toast.makeText(Signup.this, "Both passwords are not same...", Toast.LENGTH_SHORT).show();
            }
        });
        /*
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");

        Toast.makeText(this, "name received: "+name, Toast.LENGTH_SHORT).show();*/
    }
    public void checkmate(View view) {
        Button btnSubmit = findViewById(R.id.btn_signup);
        if(btnSubmit.isEnabled())
        btnSubmit.setEnabled(false);
        else btnSubmit.setEnabled(true);
    }
}