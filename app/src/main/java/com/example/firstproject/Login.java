package com.example.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    TextView txtName;
    EditText edtName, edtPasswd;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edt_name);
        edtPasswd = findViewById(R.id.edt_passwd);
        btnSubmit = findViewById(R.id.btn_submit);
        txtName = findViewById(R.id.txt_output);

        Intent intent = getIntent();
        edtName.setText(intent.getStringExtra("usr_name"));
        edtPasswd.setText(intent.getStringExtra("usr_passwd"));

        Log.d("Signing in", "Sign up by "+edtName.getText().toString());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(getApplicationContext(),v);
                popupMenu.inflate(R.menu.menu_items);
                popupMenu.setOnMenuItemClickListener(Login.this);
                popupMenu.show();
                /*String name = edtName.getText().toString();
                String passwd = edtPasswd.getText().toString();
                Toast.makeText(getApplicationContext(), name+" "+passwd, Toast.LENGTH_SHORT).show();
                txtName.setText("Name: "+name+"\nPassword: "+passwd);
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                intent.putExtra("username", name);
                intent.putExtra("password", passwd);
                startActivity(intent);*/
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_add:
                Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_delete:
                Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
                return true;

            default:
                Toast.makeText(getApplicationContext(), "Default", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_delete:
                Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
                return true;

            default:
                Toast.makeText(getApplicationContext(), "Default", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}