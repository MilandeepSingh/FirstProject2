package com.example.firstproject;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder>{

    Context context;
    ArrayList<Festival> festivals;
    AlertDialog.Builder builder;

    MyRecycleAdapter(Context context, ArrayList<Festival> festivals) {
        this.context = context;
        this.festivals = festivals;
    }

    @NonNull
    @Override
    public MyRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleAdapter.ViewHolder holder, int position) {
        Festival festival = festivals.get(position);
        holder.img.setImageResource(festival.image);
        holder.fname.setText(festival.getName());
        holder.forigin.setText(festival.getOrigin());
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, festival.getName()+" "+festival.getOrigin(), Toast.LENGTH_SHORT).show();
            }
        });
        builder = new AlertDialog.Builder(context);
        //addItem(position, holder);
        holder.delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setCancelable(false);
                builder.setMessage("Are you sure to delete this item?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        festivals.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, festivals.size());

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                        Toast.makeText(context, "You chose no action...", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.setMessage("Are you sure?");
                alertDialog.show();
            }

        });

    }

    @Override
    public int getItemCount() {
        return festivals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fname, forigin;
        public ImageView img;
        public View view;
        public Button delbtn;

        View getView(){
            return view;
        }
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            img = itemView.findViewById(R.id.img_list_item);
            fname = (TextView) itemView.findViewById(R.id.txt_name_list_item);
            forigin = (TextView) itemView.findViewById(R.id.txt_origin_list_item);
            delbtn = (Button) itemView.findViewById(R.id.btn_delete_list_item);
        }
    }
}
