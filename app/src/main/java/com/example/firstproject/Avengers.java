package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Avengers extends AppCompatActivity {

    ArrayList<Hero> heroes;
    ListView listView;
    EditText name, team;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avengers);

        listView = findViewById(R.id.list_avengers);
        name = findViewById(R.id.edt_name_avengers);
        team = findViewById(R.id.edt_team_avengers);
        btnAdd = findViewById(R.id.btn_add_avengers);

        heroes = new ArrayList();

        heroes.add(new Hero(R.drawable.blackwidow, "Black Widow", "Avengers"));
        heroes.add(new Hero(R.drawable.hulk, "Hulk", "Avengers"));
        heroes.add(new Hero(R.drawable.ironman, "Ironman", "Avengers"));
        heroes.add(new Hero(R.drawable.thor, "Thor", "Avengers"));

        MyAvengersAdapter myAvengersAdapter = new MyAvengersAdapter(this, heroes);
        listView.setAdapter(myAvengersAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Hero name: "+heroes.get(position).getName()+"\nTeam: "+heroes.get(position).getTeam(), Toast.LENGTH_SHORT).show();


            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heroName = name.getText().toString();
                String heroTeam = team.getText().toString();
                if(heroName.isEmpty() || heroTeam.isEmpty())
                    Toast.makeText(getApplicationContext(), "No field can be empty", Toast.LENGTH_SHORT).show();
                else {
                    heroes.add(new Hero(R.drawable.avengers_common, heroName, heroTeam));
                    myAvengersAdapter.setHeroes(heroes);
                    listView.setAdapter(myAvengersAdapter);
                }
            }
        });

    }
}