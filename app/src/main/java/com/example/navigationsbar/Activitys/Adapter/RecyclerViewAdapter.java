package com.example.navigationsbar.Activitys.Adapter;

import android.graphics.Color;
import android.util.Log;
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
    private int[] imageIdsHerz = {
            R.drawable.herz_zwei,
            R.drawable.herz_drei,
            R.drawable.herz_vier,
            R.drawable.herz_fuenf,
            R.drawable.herz_sechs,
            R.drawable.herz_sieben,
            R.drawable.herz_acht,
            R.drawable.herz_neun,
            R.drawable.herz_zehn,
            R.drawable.herz_bube,
            R.drawable.herz_dame,
            R.drawable.herz_koenig,
            R.drawable.herz_ass,
    };

    private int[] imageIdsKaro = {
            R.drawable.karo_zwei,
            R.drawable.karo_drei,
            R.drawable.karo_vier,
            R.drawable.karo_fuenf,
            R.drawable.karo_sechs,
            R.drawable.karo_sieben,
            R.drawable.karo_acht,
            R.drawable.karo_neun,
            R.drawable.karo_zehn,
            R.drawable.karo_bube,
            R.drawable.karo_dame,
            R.drawable.karo_koenig,
            R.drawable.karo_ass,
    };

    private int[] imageIdsPik = {
            R.drawable.pik_zwei,
            R.drawable.pik_drei,
            R.drawable.pik_vier,
            R.drawable.pik_fuenf,
            R.drawable.pik_sechs,
            R.drawable.pik_sieben,
            R.drawable.pik_acht,
            R.drawable.pik_neun,
            R.drawable.pik_zehn,
            R.drawable.pik_bube,
            R.drawable.pik_dame,
            R.drawable.pik_koenig,
            R.drawable.pik_ass,
    };

    private int[] imageIdsKreuz = {
            R.drawable.kreuz_zwei,
            R.drawable.kreuz_drei,
            R.drawable.kreuz_vier,
            R.drawable.kreuz_fuenf,
            R.drawable.kreuz_sechs,
            R.drawable.kreuz_sieben,
            R.drawable.kreuz_acht,
            R.drawable.kreuz_neun,
            R.drawable.kreuz_zehn,
            R.drawable.kreuz_bube,
            R.drawable.kreuz_dame,
            R.drawable.kreuz_koenig,
            R.drawable.kreuz_ass,
    };

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
                holder.imageView1.setImageResource(imageIdsHerz[0]);
                holder.imageView2.setImageResource(imageIdsHerz[1]);
                holder.imageView3.setImageResource(imageIdsHerz[2]);
                holder.imageView4.setImageResource(imageIdsHerz[3]);
                holder.imageView5.setImageResource(imageIdsHerz[4]);
                holder.imageView6.setImageResource(imageIdsHerz[5]);
                holder.imageView7.setImageResource(imageIdsHerz[6]);
                holder.imageView8.setImageResource(imageIdsHerz[7]);
                holder.imageView9.setImageResource(imageIdsHerz[8]);
                holder.imageView10.setImageResource(imageIdsHerz[9]);
                holder.imageView11.setImageResource(imageIdsHerz[10]);
                holder.imageView12.setImageResource(imageIdsHerz[11]);
                holder.imageView13.setImageResource(imageIdsHerz[12]);

                    // Apply color filter if the image is selected
                if (selectedImages.contains(position)) {
                    holder.imageView1.setColorFilter(Color.parseColor("#80000000"));
                } else {
                    holder.imageView1.setColorFilter(null);
                }
                break;

            case 1:
                holder.textView.setText("Karo");
                holder.imageView1.setImageResource(imageIdsKaro[0]);
                holder.imageView2.setImageResource(imageIdsKaro[1]);
                holder.imageView3.setImageResource(imageIdsKaro[2]);
                holder.imageView4.setImageResource(imageIdsKaro[3]);
                holder.imageView5.setImageResource(imageIdsKaro[4]);
                holder.imageView6.setImageResource(imageIdsKaro[5]);
                holder.imageView7.setImageResource(imageIdsKaro[6]);
                holder.imageView8.setImageResource(imageIdsKaro[7]);
                holder.imageView9.setImageResource(imageIdsKaro[8]);
                holder.imageView10.setImageResource(imageIdsKaro[9]);
                holder.imageView11.setImageResource(imageIdsKaro[10]);
                holder.imageView12.setImageResource(imageIdsKaro[11]);
                holder.imageView13.setImageResource(imageIdsKaro[12]);

                // Apply color filter if the image is selected
                if (selectedImages.contains(position)) {
                    holder.imageView1.setColorFilter(Color.parseColor("#80000000"));

                } else {
                    holder.imageView1.setColorFilter(null);
                }
                break;

            case 2:
                holder.textView.setText("Pik");
                holder.imageView1.setImageResource(imageIdsPik[0]);
                holder.imageView2.setImageResource(imageIdsPik[1]);
                holder.imageView3.setImageResource(imageIdsPik[2]);
                holder.imageView4.setImageResource(imageIdsPik[3]);
                holder.imageView5.setImageResource(imageIdsPik[4]);
                holder.imageView6.setImageResource(imageIdsPik[5]);
                holder.imageView7.setImageResource(imageIdsPik[6]);
                holder.imageView8.setImageResource(imageIdsPik[7]);
                holder.imageView9.setImageResource(imageIdsPik[8]);
                holder.imageView10.setImageResource(imageIdsPik[9]);
                holder.imageView11.setImageResource(imageIdsPik[10]);
                holder.imageView12.setImageResource(imageIdsPik[11]);
                holder.imageView13.setImageResource(imageIdsPik[12]);

                // Apply color filter if the image is selected
                if (selectedImages.contains(position)) {
                    holder.imageView1.setColorFilter(Color.parseColor("#80000000"));

                } else {
                    holder.imageView1.setColorFilter(null);
                }
                break;
            case 3:
                    // Change the pictures for Case 3
                holder.textView.setText("Kreuz");
                holder.imageView1.setImageResource(imageIdsKreuz[0]);
                holder.imageView2.setImageResource(imageIdsKreuz[1]);
                holder.imageView3.setImageResource(imageIdsKreuz[2]);
                holder.imageView4.setImageResource(imageIdsKreuz[3]);
                holder.imageView5.setImageResource(imageIdsKreuz[4]);
                holder.imageView6.setImageResource(imageIdsKreuz[5]);
                holder.imageView7.setImageResource(imageIdsKreuz[6]);
                holder.imageView8.setImageResource(imageIdsKreuz[7]);
                holder.imageView9.setImageResource(imageIdsKreuz[8]);
                holder.imageView10.setImageResource(imageIdsKreuz[9]);
                holder.imageView11.setImageResource(imageIdsKreuz[10]);
                holder.imageView12.setImageResource(imageIdsKreuz[11]);
                holder.imageView13.setImageResource(imageIdsKreuz[12]);

                    // Apply color filter if the image is selected
                if (selectedImages.contains(position)) {
                    holder.imageView1.setColorFilter(Color.parseColor("#80000000"));

                } else {
                    holder.imageView1.setColorFilter(null);
                }
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

        private void addSelectedImage(int position) {
            if (!selectedImages.contains(position)) {
                selectedImages.add(position);
            }
        }

        private void removeSelectedImage(int position) {
            selectedImages.remove(Integer.valueOf(position));
        }

        @Override
        public void onClick(View v) {
            ImageView clickedImageView = (ImageView) v;
            int position = getAdapterPosition();

            //System.out.println(selectedImages);

            if (clickedImageView.getColorFilter() != null) {
                clickedImageView.setColorFilter(null);
                removeSelectedImage(position);
            } else {
                clickedImageView.setColorFilter(Color.parseColor("#80000000"));
                addSelectedImage(position);
            }
        }
    }
}