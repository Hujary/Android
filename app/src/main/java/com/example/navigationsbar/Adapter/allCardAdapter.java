package com.example.navigationsbar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.navigationsbar.Items.Spielkarten.SpielKarten;
import com.example.navigationsbar.R;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class allCardAdapter extends RecyclerView.Adapter<allCardAdapter.BestSellerViewHolder> {

    private List<SpielKarten> spielKartenList;
    private Set<Integer> selectedPositions = new HashSet<>();
    private OnItemClickListener onItemClickListener;

    public allCardAdapter(List<SpielKarten> spielKartenList) {
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

        if (selectedPositions.contains(position)) {
            holder.mImageview.setImageResource(R.drawable.card_back);
        } else {
            holder.mImageview.setImageResource(spielKarte.getImage());
        }
    }

    @Override
    public int getItemCount() {
        return spielKartenList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(SpielKarten spielkarte, int position);
    }

    public class BestSellerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageview;

        public BestSellerViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageview = itemView.findViewById(R.id.SpielkartenImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                SpielKarten spielkarte = spielKartenList.get(position);
                if (selectedPositions.contains(position)) {
                    selectedPositions.remove(position);
                } else {
                    selectedPositions.add(position);
                }
                notifyItemChanged(position);
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(spielkarte, position);
                }
            }
        }
    }
}