package com.example.navigationsbar.Activitys.Questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.navigationsbar.Activitys.Adapter.BestSellerAdapter;
import com.example.navigationsbar.Activitys.Adapter.Model.BestSeller;
import com.example.navigationsbar.R;
import java.util.ArrayList;
import java.util.List;

public class QuestionFourActivity extends AppCompatActivity {

    private RecyclerView  bestSellerRecyclerView, KaroRecyclerView, PikRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question4_layout);

            // Herz RecyclerView
        bestSellerRecyclerView = findViewById(R.id.HerzRecyclerView);
        bestSellerRecyclerView.setHasFixedSize(true);
        bestSellerRecyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));
        List<BestSeller> bestSellerList = new ArrayList<>();
        bestSellerList.add(new BestSeller(R.drawable.herz_zwei));
        bestSellerList.add(new BestSeller(R.drawable.herz_drei));
        bestSellerList.add(new BestSeller(R.drawable.herz_vier));
        bestSellerList.add(new BestSeller(R.drawable.herz_fuenf));
        bestSellerList.add(new BestSeller(R.drawable.herz_sechs));
        bestSellerList.add(new BestSeller(R.drawable.herz_sieben));
        bestSellerList.add(new BestSeller(R.drawable.herz_acht));
        bestSellerList.add(new BestSeller(R.drawable.herz_neun));
        bestSellerList.add(new BestSeller(R.drawable.herz_zehn));
        bestSellerList.add(new BestSeller(R.drawable.herz_bube));
        bestSellerList.add(new BestSeller(R.drawable.herz_dame));
        bestSellerList.add(new BestSeller(R.drawable.herz_koenig));
        bestSellerList.add(new BestSeller(R.drawable.herz_ass));
        BestSellerAdapter bestSellerAdapter = new BestSellerAdapter(bestSellerList);
        bestSellerRecyclerView.setAdapter(bestSellerAdapter);

            // Karo RecyclerView
        KaroRecyclerView = findViewById(R.id.KaroRecyclerView);
        KaroRecyclerView.setHasFixedSize(true);
        KaroRecyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));
        List<BestSeller> KaroList = new ArrayList<>();
        KaroList.add(new BestSeller(R.drawable.karo_zwei));
        KaroList.add(new BestSeller(R.drawable.karo_drei));
        KaroList.add(new BestSeller(R.drawable.karo_vier));
        KaroList.add(new BestSeller(R.drawable.karo_fuenf));
        KaroList.add(new BestSeller(R.drawable.karo_sechs));
        KaroList.add(new BestSeller(R.drawable.karo_sieben));
        KaroList.add(new BestSeller(R.drawable.karo_acht));
        KaroList.add(new BestSeller(R.drawable.karo_neun));
        KaroList.add(new BestSeller(R.drawable.karo_zehn));
        KaroList.add(new BestSeller(R.drawable.karo_bube));
        KaroList.add(new BestSeller(R.drawable.karo_dame));
        KaroList.add(new BestSeller(R.drawable.karo_koenig));
        KaroList.add(new BestSeller(R.drawable.karo_ass));
        BestSellerAdapter KaroAdapter = new BestSellerAdapter(KaroList);
        KaroRecyclerView.setAdapter(KaroAdapter);

            // pik RecyclerView
        PikRecyclerView = findViewById(R.id.PikRecyclerview);
        PikRecyclerView.setHasFixedSize(true);
        PikRecyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));
        List<BestSeller> pikList = new ArrayList<>();
        pikList.add(new BestSeller(R.drawable.pik_zwei));
        pikList.add(new BestSeller(R.drawable.pik_drei));
        pikList.add(new BestSeller(R.drawable.pik_vier));
        pikList.add(new BestSeller(R.drawable.pik_fuenf));
        pikList.add(new BestSeller(R.drawable.pik_sechs));
        pikList.add(new BestSeller(R.drawable.pik_sieben));
        pikList.add(new BestSeller(R.drawable.pik_acht));
        pikList.add(new BestSeller(R.drawable.pik_neun));
        pikList.add(new BestSeller(R.drawable.pik_zehn));
        pikList.add(new BestSeller(R.drawable.pik_bube));
        pikList.add(new BestSeller(R.drawable.pik_dame));
        pikList.add(new BestSeller(R.drawable.pik_koenig));
        pikList.add(new BestSeller(R.drawable.pik_ass));
        BestSellerAdapter PikAdapter = new BestSellerAdapter(pikList);
        PikRecyclerView.setAdapter(PikAdapter);
    }
}