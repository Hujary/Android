package com.example.navigationsbar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.navigationsbar.Items.Spielkarten.SpielKarten;
import com.example.navigationsbar.R;
import java.util.List;

public class DetailedCardListAdapter extends RecyclerView.Adapter<DetailedCardListAdapter.BestSellerViewHolder> {

    private List<SpielKarten> spielKartenList;

    public DetailedCardListAdapter(List<SpielKarten> spielKartenList) {
        this.spielKartenList = spielKartenList;
    }

    @NonNull
    @Override
    public BestSellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playcards_small, parent, false);
        return new BestSellerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellerViewHolder holder, int position) {
        SpielKarten spielKarte = spielKartenList.get(position);
        holder.mImageview.setImageResource(spielKarte.getImage());
    }

    @Override
    public int getItemCount() {
        return spielKartenList.size();
    }

    public class BestSellerViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageview;

        public BestSellerViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageview = itemView.findViewById(R.id.SpielkartenImage);
        }
    }
}