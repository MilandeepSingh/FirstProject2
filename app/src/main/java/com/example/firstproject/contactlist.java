package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class contactlist extends AppCompatActivity {

    String[] contacts = {"Aryan", "Pushpender", "Jaskaran", "Sameer", "Customer Care", "Gurpreet"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactlist);

        ListView listView = findViewById(R.id.list_contactlist);

        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_item, R.id.txt_listItem, contacts);
        MyContactAdapter myContactAdapter = new MyContactAdapter(this, R.layout.contact, contacts);


        listView.setAdapter(myContactAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), myContactAdapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}