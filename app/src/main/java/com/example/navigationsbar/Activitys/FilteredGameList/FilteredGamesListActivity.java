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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtered_gamelist);
    }
}