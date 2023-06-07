package com.example.navigationsbar.Activitys.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private int[] imageIds = {
            R.drawable.herz_ass,
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fehlende_karten, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView1.setImageResource(imageIds[position]);

        switch (position) {
            case 0:
                holder.textView.setText("Herz");
                break;
            case 1:
                holder.textView.setText("Karo");
                break;
            case 2:
                holder.textView.setText("Pik");
                break;
            case 3:
                holder.textView.setText("Kreuz");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        ImageView imageView11;
        ImageView imageView12;
        ImageView imageView13;
        ImageView imageView14;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewKartenname);
            imageView1 = itemView.findViewById(R.id.imageViewSpielkarte1);
            imageView2 = itemView.findViewById(R.id.imageViewSpielkarte2);
            imageView3 = itemView.findViewById(R.id.imageViewSpielkarte3);
            imageView4 = itemView.findViewById(R.id.imageViewSpielkarte4);
            imageView5 = itemView.findViewById(R.id.imageViewSpielkarte5);
            imageView6 = itemView.findViewById(R.id.imageViewSpielkarte6);
            imageView7 = itemView.findViewById(R.id.imageViewSpielkarte7);
            imageView8 = itemView.findViewById(R.id.imageViewSpielkarte8);
            imageView9 = itemView.findViewById(R.id.imageViewSpielkarte9);
            imageView10 = itemView.findViewById(R.id.imageViewSpielkarte10);
            imageView11 = itemView.findViewById(R.id.imageViewSpielkarte11);
            imageView12 = itemView.findViewById(R.id.imageViewSpielkarte12);
            imageView13 = itemView.findViewById(R.id.imageViewSpielkarte13);
            imageView14 = itemView.findViewById(R.id.imageViewSpielkarte14);

            imageView1.setOnClickListener(this);
            imageView2.setOnClickListener(this);
            imageView3.setOnClickListener(this);
            imageView4.setOnClickListener(this);
            imageView5.setOnClickListener(this);
            imageView6.setOnClickListener(this);
            imageView7.setOnClickListener(this);
            imageView8.setOnClickListener(this);
            imageView9.setOnClickListener(this);
            imageView10.setOnClickListener(this);
            imageView11.setOnClickListener(this);
            imageView12.setOnClickListener(this);
            imageView13.setOnClickListener(this);
            imageView14.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
                // ändere die Farbe des Bildes
            imageView1.setColorFilter(Color.parseColor("#80000000")); // Dunklerer Farbton
        }
    }
}