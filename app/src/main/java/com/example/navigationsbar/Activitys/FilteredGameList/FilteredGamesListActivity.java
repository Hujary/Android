package com.example.navigationsbar.Activitys.FilteredGameList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Activitys.GameData;
import com.example.navigationsbar.Activitys.Questions.QuestionFourActivity;
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
    private GameData gameData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtered_gamelist);
        gameData = GameData.getInstance();

            // Variablen aus Singelton auslesen & in Konsole ausgeben
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        int player = gameData.getNumberOfPlayers();
        String answer = gameData.getHaveCards();
        String answer1 = gameData.getFehlenKarten();
        String answer2 = gameData.getSchwierigkeit();

        System.out.println("Spieleranzahl: " + player);
        System.out.println("hast du Karten: " + answer);
        System.out.println("fehlen Karten: " +  answer1);
        System.out.println("Schwierigkeit: " +  answer2);

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


        recyclerView = findViewById(R.id.filteredArticleRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            //  Pseudoartikel   todo: Artikel abhängig der Eingabe anpassen
        filteredGamesList.add(new filteredArticle("Titel1", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel2", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel3", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel4", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel5", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
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
            //  todo: fix the onClick
        System.out.println("Working");
    }

    public interface OnClickListener {
        void onItemClick(Article article);
        void onFooterClick();
    }
}