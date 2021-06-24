package com.example.firstproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAvengersAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Hero> heroes;

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public MyAvengersAdapter(Context context, ArrayList<Hero> heroes) {
        this.context = context;
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        if(heroes.isEmpty())
            return 0;
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.avenger, parent, false);
        ImageView image = view.findViewById(R.id.img_avenger);
        TextView name = view.findViewById(R.id.txt_name_avenger);
        TextView team = view.findViewById(R.id.txt_team_avenger);

        Hero hero = heroes.get(position);

        name.setText(hero.getName());
        team.setText(hero.getTeam());
        image.setImageResource(hero.getImage());

        return view;
    }
}
