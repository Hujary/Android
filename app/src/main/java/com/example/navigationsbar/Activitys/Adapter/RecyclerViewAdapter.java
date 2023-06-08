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

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static List<Integer> selectedImages; // Store the positions of selected images

    public RecyclerViewAdapter() {
        selectedImages = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fehlende_karten, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        switch (position) {
            case 0:
                holder.textView.setText("Herz");

                break;
            case 1:
                holder.textView.setText("Karo");
                holder.imageView1.setBackgroundResource(R.drawable.karo_zwei);
                holder.imageView2.setBackgroundResource(R.drawable.karo_drei);
                holder.imageView3.setBackgroundResource(R.drawable.karo_vier);
                holder.imageView4.setBackgroundResource(R.drawable.karo_fuenf);
                holder.imageView5.setBackgroundResource(R.drawable.karo_sechs);
                holder.imageView6.setBackgroundResource(R.drawable.karo_sieben);
                holder.imageView7.setBackgroundResource(R.drawable.karo_acht);
                holder.imageView8.setBackgroundResource(R.drawable.karo_neun);
                holder.imageView9.setBackgroundResource(R.drawable.karo_zehn);
                holder.imageView10.setBackgroundResource(R.drawable.karo_bube);
                holder.imageView11.setBackgroundResource(R.drawable.karo_dame);
                holder.imageView12.setBackgroundResource(R.drawable.karo_koenig);
                holder.imageView13.setBackgroundResource(R.drawable.karo_ass);
                break;
            case 2:
                holder.textView.setText("Pik");
                holder.imageView1.setBackgroundResource(R.drawable.pik_zwei);
                holder.imageView2.setBackgroundResource(R.drawable.pik_drei);
                holder.imageView3.setBackgroundResource(R.drawable.pik_vier);
                holder.imageView4.setBackgroundResource(R.drawable.pik_fuenf);
                holder.imageView5.setBackgroundResource(R.drawable.pik_sechs);
                holder.imageView6.setBackgroundResource(R.drawable.pik_sieben);
                holder.imageView7.setBackgroundResource(R.drawable.pik_acht);
                holder.imageView8.setBackgroundResource(R.drawable.pik_neun);
                holder.imageView9.setBackgroundResource(R.drawable.pik_zehn);
                holder.imageView10.setBackgroundResource(R.drawable.pik_bube);
                holder.imageView11.setBackgroundResource(R.drawable.pik_dame);
                holder.imageView12.setBackgroundResource(R.drawable.pik_koenig);
                holder.imageView13.setBackgroundResource(R.drawable.pik_ass);
                break;
            case 3:
                holder.textView.setText("Kreuz");
                holder.imageView1.setBackgroundResource(R.drawable.kreuz_zwei);
                holder.imageView2.setBackgroundResource(R.drawable.kreuz_drei);
                holder.imageView3.setBackgroundResource(R.drawable.kreuz_vier);
                holder.imageView4.setBackgroundResource(R.drawable.kreuz_fuenf);
                holder.imageView5.setBackgroundResource(R.drawable.kreuz_sechs);
                holder.imageView6.setBackgroundResource(R.drawable.kreuz_sieben);
                holder.imageView7.setBackgroundResource(R.drawable.kreuz_acht);
                holder.imageView8.setBackgroundResource(R.drawable.kreuz_neun);
                holder.imageView9.setBackgroundResource(R.drawable.kreuz_zehn);
                holder.imageView10.setBackgroundResource(R.drawable.kreuz_bube);
                holder.imageView11.setBackgroundResource(R.drawable.kreuz_dame);
                holder.imageView12.setBackgroundResource(R.drawable.kreuz_koenig);
                holder.imageView13.setBackgroundResource(R.drawable.kreuz_ass);
                break;
        }

        // Apply color filter if the image is selected
        if (selectedImages.contains(position)) {
            holder.imageView1.setColorFilter(Color.parseColor("#80000000"));
        } else {
            holder.imageView1.setColorFilter(null);
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
        }

        @Override
        public void onClick(View v) {
            ImageView clickedImageView = (ImageView) v;
            int position = getAdapterPosition();

            if (clickedImageView.getColorFilter() != null) {
                // If the image is already selected, deselect it
                clickedImageView.setColorFilter(null);
                // Remove the position from the selected images list
                removeSelectedImage(position);
            } else {
                // If the image is not selected, select it
                clickedImageView.setColorFilter(Color.parseColor("#80000000"));
                // Add the position to the selected images list
                addSelectedImage(position);
            }
        }
    }

    private static void addSelectedImage(int position) {
        if (!selectedImages.contains(position)) {
            selectedImages.add(position);
        }
    }

    private static void removeSelectedImage(int position) {
        selectedImages.remove(Integer.valueOf(position));
    }
}