package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import java.util.ArrayList;

public class Portfolio extends AppCompatActivity {

    GridView gridView;
    ArrayList<Pic> pictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        GridView gridView = findViewById(R.id.gridview_portfolio);

        pictures = new ArrayList<Pic>();

        pictures.add(new Pic(R.drawable.diwali, "Diwali"));
        pictures.add(new Pic(R.drawable.blackwidow, "Black Widow"));
        pictures.add(new Pic(R.drawable.visakhi, "Visakhi"));
        pictures.add(new Pic(R.drawable.thor, "Thor"));
        pictures.add(new Pic(R.drawable.onam, "Onam"));
        pictures.add(new Pic(R.drawable.hulk, "Hulk"));
        pictures.add(new Pic(R.drawable.halloween, "Halloween"));

        MyPortfolioAdapter myPortfolioAdapter = new MyPortfolioAdapter(this, pictures);
        gridView.setAdapter(myPortfolioAdapter);



    }
}