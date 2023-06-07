package com.example.navigationsbar.Activitys.FilteredGameList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Artikel.Article;
import com.example.navigationsbar.Activitys.Adapter.ArticleAdapter;
import com.example.navigationsbar.R;

import java.util.ArrayList;
import java.util.List;

public class FilteredGamesListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArticleAdapter articleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtered_gamelist);

        recyclerView = findViewById(R.id.GefilterteSpieleRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

            // Create a list of filtered articles (replace this with your actual filtered list)
        List<Article> filteredArticles = new ArrayList<>();

            // Create an adapter with the filtered articles
        articleAdapter = new ArticleAdapter(filteredArticles);

            // Set the adapter to the RecyclerView
        recyclerView.setAdapter(articleAdapter);
    }
}