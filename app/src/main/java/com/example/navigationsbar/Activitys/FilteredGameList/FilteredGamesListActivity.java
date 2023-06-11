package com.example.navigationsbar.Activitys.FilteredGameList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Activitys.GameData;
import com.example.navigationsbar.Adapter.FilteredArticleAdapter;
import com.example.navigationsbar.Items.Article.Article;
import com.example.navigationsbar.Items.FilteredArticle.filteredArticle;
import com.example.navigationsbar.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FilteredGamesListActivity extends AppCompatActivity implements FilteredArticleAdapter.OnClickListener {

    private RecyclerView recyclerView;
    private List<filteredArticle> filteredGamesList = new ArrayList<>();

    private GameData gameData; // Das GameData-Objekt als Feld deklarieren

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtered_gamelist);
        gameData = GameData.getInstance();

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        int player = gameData.getNumberOfPlayers();
        System.out.println("Spieleranzahl: " + player);

        String answer = gameData.getHaveCards();
        System.out.println("hast du Karten: " + answer);

        String answer1 = gameData.getFehlenKarten();
        System.out.println("fehlen Karten: " +  answer1);

        String answer2 = gameData.getSchwierigkeit();
        System.out.println("Schwierigkeit: " +  answer2);




        Button buttonReturn = findViewById(R.id.button_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        recyclerView = findViewById(R.id.filteredArticleRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        filteredGamesList.add(new filteredArticle("Titel1", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel2", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel3", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel4", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel5", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        FilteredArticleAdapter filteredArticleAdapter = new FilteredArticleAdapter(filteredGamesList, this);
        recyclerView.setAdapter(filteredArticleAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onItemClick(filteredArticle article) {
        Intent intent = new Intent(this, DetailedGameInformationActivity.class);
        intent.putExtra("title", article.getTitle());
        intent.putExtra("cardNumber", article.getBenötigteKarten());
        intent.putExtra("playerNumberMin", article.getSpieleranzahlMin());
        intent.putExtra("playerNumberMax", article.getSpieleranzahlMax());
        intent.putExtra("playTimeMin", article.getSpieldauerMin());
        intent.putExtra("playTimeMax", article.getSpieldauerMax());
        intent.putExtra("difficulty", article.getSchwierigkeitsgrad());
        intent.putExtra("rules", article.getSpielregeln());
        startActivity(intent);
    }

    @Override
    public void onFooterClick() {
        System.out.println("Working");
        // Handle the footer click here
        // You can open a new activity or perform any other desired action
        // For example, you can open a suggestion form or add a new game
    }

    public interface OnClickListener {
        void onItemClick(Article article);
        void onFooterClick();
    }
}