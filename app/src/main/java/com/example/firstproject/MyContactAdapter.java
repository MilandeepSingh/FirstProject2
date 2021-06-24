package com.example.firstproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyContactAdapter extends BaseAdapter {
    Context context;
    String[] contacts;
    int layoutId;

    public MyContactAdapter(Context context, int layoutId, String[] contacts) {
        this.context = context;
        this.contacts = contacts;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return contacts.length;
    }

    @Override
    public Object getItem(int position) {
        return contacts[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutId, parent, false);
        ImageView imageView = view.findViewById(R.id.img_contact);
        TextView textView = view.findViewById(R.id.txt_contact);
        textView.setText(contacts[position]);
        return view;
    }
}
