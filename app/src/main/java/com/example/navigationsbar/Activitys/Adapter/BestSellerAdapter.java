package com.example.navigationsbar.Activitys.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.navigationsbar.Activitys.Adapter.Model.BestSeller;
import com.example.navigationsbar.R;
import java.util.List;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder> {

    private List<BestSeller> bestSellerList;
    public BestSellerAdapter(List<BestSeller> bestSellerList){
        this.bestSellerList = bestSellerList;
    }
    @NonNull
    @Override
    public BestSellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent , false);
        return new BestSellerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellerViewHolder holder, int position) {
        holder.mImageview.setImageResource(bestSellerList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return bestSellerList.size();
    }

    public class BestSellerViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageview;
        public BestSellerViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageview = itemView.findViewById(R.id.SpielkartenImage);
        }
    }
}
