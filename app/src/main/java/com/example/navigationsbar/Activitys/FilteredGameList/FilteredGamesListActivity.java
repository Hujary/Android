package com.example.navigationsbar.Activitys.FilteredGameList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Activitys.GameDataSingelton;
import com.example.navigationsbar.Adapter.FilteredArticleAdapter;
import com.example.navigationsbar.Items.FilteredArticle.FilteredArticleCreator;
import com.example.navigationsbar.Items.FilteredArticle.filteredArticle;
import com.example.navigationsbar.R;

import java.util.List;

public class FilteredGamesListActivity extends AppCompatActivity implements FilteredArticleAdapter.OnClickListener {

    private RecyclerView recyclerView;
    private GameDataSingelton gameDataSingelton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtered_gamelist);
        gameDataSingelton = GameDataSingelton.getInstance();

            // Retrieve variables from Singleton and print them in the console
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        int playerNumber = gameDataSingelton.getNumberOfPlayers();
        String difficulty = gameDataSingelton.getSchwierigkeit();
        String missingCards = gameDataSingelton.getFehlenKarten();
        String haveCards = gameDataSingelton.getHaveCards();

            // Convert "Hast du Karten?" to boolean
        boolean bol_answer_haveCards = haveCards.equals("Ja");

            // Convert "Fehlen Karten?" to boolean
        boolean bol_answer_missingCards = missingCards.equals("Ja");


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

            //  Liste erzeugen in der meine gefilterten Artikel gespeichert werden.
        FilteredArticleCreator f1 = new FilteredArticleCreator(this);
        List<filteredArticle> filteredGamesList = f1.getFilteredArticle(playerNumber, difficulty, bol_answer_haveCards, bol_answer_missingCards);

            // Add the filtered games list to the adapter
        FilteredArticleAdapter filteredArticleAdapter = new FilteredArticleAdapter(filteredGamesList, this);
        recyclerView.setAdapter(filteredArticleAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onItemClick(filteredArticle article) {
        // Pass the current article information to the intent
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
        // TODO: Implement footer click logic
        System.out.println("Working");
    }
}