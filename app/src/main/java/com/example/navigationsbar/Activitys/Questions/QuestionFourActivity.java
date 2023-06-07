package com.example.navigationsbar.Activitys.Questions;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Activitys.Adapter.RecyclerViewAdapter;
import com.example.navigationsbar.R;


public class QuestionFourActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question4_layout);

        RecyclerView recyclerView = findViewById(R.id.ItemFehlendeRecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
    }
}