package com.example.navigationsbar.Activitys.FilteredGameList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Activitys.GameData;
import com.example.navigationsbar.Activitys.Questions.QuestionFourActivity;
import com.example.navigationsbar.Adapter.FilteredArticleAdapter;
import com.example.navigationsbar.Items.FilteredArticle.FilteredArticleManager;
import com.example.navigationsbar.Items.FilteredArticle.filteredArticle;
import com.example.navigationsbar.R;

import java.util.List;

public class FilteredGamesListActivity extends AppCompatActivity implements FilteredArticleAdapter.OnClickListener {

    private RecyclerView recyclerView;
    private GameData gameData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtered_gamelist);
        gameData = GameData.getInstance();

            // Retrieve variables from Singleton and print them in the console
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        int playerNumber = gameData.getNumberOfPlayers();
        String difficulty = gameData.getSchwierigkeit();
        String missingCards = gameData.getFehlenKarten();
        String haveCards = gameData.getHaveCards();

            // Convert "Hast du Karten?" to boolean
        boolean bol_answer_haveCards = haveCards.equals("Ja");

            // Convert "Fehlen Karten?" to boolean
        boolean bol_answer_missingCards = missingCards.equals("Ja");

            // Output the selected positions of the Herz cards
        if (gameData.getSelectedHerzCards() != null) {
            StringBuilder selectedHerzPositions = new StringBuilder("Selected Herz Positions: ");
            for (Integer selectedHerzPosition : gameData.getSelectedHerzCards()) {
                selectedHerzPositions.append(selectedHerzPosition).append(", ");
            }
            Log.d("QuestionFourActivity", selectedHerzPositions.toString());
        } else {
            System.out.println("Keine Herz Karten ausgewählt");
        }

        // Output the selected positions of the Pik cards
        if (gameData.getSelectedPikCards() != null) {
            StringBuilder selectedPikPositions = new StringBuilder("Selected Pik Positions: ");
            for (Integer selectedPikPosition : gameData.getSelectedPikCards()) {
                selectedPikPositions.append(selectedPikPosition).append(", ");
            }
            Log.d("QuestionFourActivity", selectedPikPositions.toString());
        } else {
            System.out.println("Keine Pik Karten ausgewählt");
        }

        // Output the selected positions of the Kreuz cards
        if (gameData.getSelectedKreuzCards() != null) {
            StringBuilder selectedKreuzPositions = new StringBuilder("Selected Kreuz Positions: ");
            for (Integer selectedKreuzPosition : gameData.getSelectedKreuzCards()) {
                selectedKreuzPositions.append(selectedKreuzPosition).append(", ");
            }
            Log.d("QuestionFourActivity", selectedKreuzPositions.toString());
        } else {
            System.out.println("Keine Kreuz Karten ausgewählt");
        }

        // Output the selected positions of the Karo cards
        if (gameData.getSelectedKaroCards() != null) {
            StringBuilder selectedKaroPositions = new StringBuilder("Selected Karo Positions: ");
            for (Integer selectedKaroPosition : gameData.getSelectedKaroCards()) {
                selectedKaroPositions.append(selectedKaroPosition).append(", ");
            }
            Log.d("QuestionFourActivity", selectedKaroPositions.toString());
        } else {
            System.out.println("Keine Karo Karten ausgewählt");
        }

        Button buttonReturn = findViewById(R.id.button_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

            // Apply filtering logic using FilteredArticleManager class
        List<filteredArticle> filteredGamesList = FilteredArticleManager.getFilteredArticles(playerNumber, bol_answer_haveCards, bol_answer_missingCards, difficulty);

        recyclerView = findViewById(R.id.filteredArticleRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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