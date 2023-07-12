package com.example.navigationsbar.Activitys.FilteredGameList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Activitys.GameDataSingelton;
import com.example.navigationsbar.Activitys.MainActivity;
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
        int playerNumber = gameDataSingelton.getNumberOfPlayers();
        String difficulty = gameDataSingelton.getSchwierigkeit();
        String missingCards = gameDataSingelton.getFehlenKarten();
        String haveCards = gameDataSingelton.getHaveCards();
        List<Integer> herzCards = gameDataSingelton.getSelectedHerzCards();
        List<Integer> pikCards = gameDataSingelton.getSelectedPikCards();
        List<Integer> kreuzCards = gameDataSingelton.getSelectedKreuzCards();
        List<Integer> karoCards = gameDataSingelton.getSelectedKaroCards();


        //  baue aus zb. [0,3,6] ein String mit den tatsächlichen Spielkarten
        StringBuilder missingCardsBuilder = new StringBuilder();
        if (herzCards != null && !herzCards.isEmpty()) {
            appendCardsToStringBuilder(herzCards, "herz", missingCardsBuilder);
        }
        if (pikCards != null && !pikCards.isEmpty()) {
            if (missingCardsBuilder.length() > 0) {
                missingCardsBuilder.append(", ");
            }
            appendCardsToStringBuilder(pikCards, "pik", missingCardsBuilder);
        }
        if (kreuzCards != null && !kreuzCards.isEmpty()) {
            if (missingCardsBuilder.length() > 0) {
                missingCardsBuilder.append(", ");
            }
            appendCardsToStringBuilder(kreuzCards, "kreuz", missingCardsBuilder);
        }
        if (karoCards != null && !karoCards.isEmpty()) {
            if (missingCardsBuilder.length() > 0) {
                missingCardsBuilder.append(", ");
            }
            appendCardsToStringBuilder(karoCards, "karo", missingCardsBuilder);
        }

        String missingCardsString;
        if (missingCardsBuilder.length() > 0) {
            missingCardsString = missingCardsBuilder.toString();
        } else {
            missingCardsString = "null";
        }

        // Convert to boolean
        boolean bol_answer_haveCards = "Ja".equals(haveCards != null ? haveCards : "Nein");
        boolean bol_answer_missingCards = "Ja".equals(missingCards != null ? missingCards : "Nein");

        // Logik für Zurück Button
        Button buttonReturn = findViewById(R.id.button_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });


        recyclerView = findViewById(R.id.filteredArticleRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //  Liste erzeugen in der meine gefilterten Artikel gespeichert werden.
        FilteredArticleCreator f1 = new FilteredArticleCreator(this);
        List<filteredArticle> filteredGamesList = f1.getFilteredArticle(playerNumber, difficulty, bol_answer_missingCards, bol_answer_haveCards, missingCardsString );

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

    private String getCardName(String cardType, int cardValue) {
        String[] cardNames = {"zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun", "zehn", "bube", "dame", "koenig", "ass"};
        String typeName = cardType.toLowerCase();
        String valueName = cardNames[cardValue];
        return typeName + "_" + valueName;
    }

    private void appendCardsToStringBuilder(List<Integer> cards, String cardType, StringBuilder stringBuilder) {
        int size = cards.size();
        for (int i = 0; i < size; i++) {
            int cardValue = cards.get(i);
            String cardName = getCardName(cardType, cardValue);
            stringBuilder.append(cardName);
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }
    }

    @Override
    public void onFooterClick() {
            // TODO: Implement footer click logic to link to addArticle
        System.out.println("Working");
    }
}