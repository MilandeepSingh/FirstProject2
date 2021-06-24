package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Festivals extends AppCompatActivity {

    EditText name, origin;
    Button add_btn;
    ArrayList<Festival> festivals;
    RecyclerView recyclerView;
    MyRecycleAdapter myRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festivals);

        name = findViewById(R.id.edt_name_festivals);
        origin = findViewById(R.id.edt_origin_festivals);
        add_btn = findViewById(R.id.btn_add_festivals);
        recyclerView = findViewById(R.id.recycler_View_festivals);

        festivals = new ArrayList<>();

        festivals.add(new Festival(R.drawable.diwali,"Diwali", "India"));
        festivals.add(new Festival(R.drawable.halloween, "Halloween", "America"));
        festivals.add(new Festival(R.drawable.visakhi,"Visakhi", "Punjabi"));
        festivals.add(new Festival(R.drawable.onam, "Onam", "Kerala"));

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = name.getText().toString();
                String forigin = origin.getText().toString();
                if(fname.isEmpty() || forigin.isEmpty())
                    Toast.makeText(getApplicationContext(), "No field can be empty", Toast.LENGTH_SHORT).show();
                else{
                    festivals.add(new Festival(fname, forigin));
                    myRecycleAdapter.notifyDataSetChanged();
                }
            }
        });

        myRecycleAdapter = new MyRecycleAdapter(this, festivals);
        recyclerView.setHasFixedSize(true);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.setAdapter(myRecycleAdapter);
    }
}