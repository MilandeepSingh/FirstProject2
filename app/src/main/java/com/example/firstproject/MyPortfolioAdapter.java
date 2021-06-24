package com.example.firstproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyPortfolioAdapter extends BaseAdapter {

    Context context;
    ArrayList<Pic> pictures;

    public MyPortfolioAdapter(Context context, ArrayList<Pic> pictures) {
        this.context = context;
        this.pictures = pictures;
    }

    @Override
    public int getCount() {
        return pictures.size();
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
        View view = layoutInflater.inflate(R.layout.photo, parent, false);
        ImageView imageView = view.findViewById(R.id.img_photo);
        TextView textView = view.findViewById(R.id.txt_photo);
        int image = pictures.get(position).getImage();
        String name = pictures.get(position).getName();

        imageView.setImageResource(image);
        textView.setText(name);
        return view;
    }
}
