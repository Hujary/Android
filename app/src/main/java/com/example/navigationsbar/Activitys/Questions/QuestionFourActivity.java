package com.example.navigationsbar.Activitys.Questions;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Activitys.Adapter.RecyclerViewAdapter;
import com.example.navigationsbar.R;

public class QuestionFourActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question4_layout);

            // Finde die RecyclerView in der Layout-Datei
        RecyclerView recyclerView = findViewById(R.id.ItemFehlendeRecyclerView);

            // Erstelle den Adapter und setze ihn für die RecyclerView
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

            // Erstelle einen LayoutManager und setze ihn für die RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

            // Füge den PagerSnapHelper hinzu, um ein sauberes Scrollen zu ermöglichen
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
    }
}