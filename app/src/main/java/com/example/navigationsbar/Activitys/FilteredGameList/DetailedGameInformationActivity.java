package com.example.navigationsbar.Activitys.FilteredGameList;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Adapter.allCardAdapter;
import com.example.navigationsbar.Items.Spielkarten.SpielKarten;
import com.example.navigationsbar.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DetailedGameInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailedgamerule_layout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
                // holt sich die information aus dem Intent
            String title = extras.getString("title");
            String cardNumber = extras.getString("cardNumber");
            int playerNumberMin = extras.getInt("playerNumberMin");
            int playerNumberMax = extras.getInt("playerNumberMax");
            int playTimeMin = extras.getInt("playTimeMin");
            int playTimeMax = extras.getInt("playTimeMax");
            String difficulty = extras.getString("difficulty");
            String rules = extras.getString("rules");

                // Verwendet die übergebenen Werte, um die Ansichten in Ihrem Layout zu aktualisieren
            TextView titleTextView = findViewById(R.id.gameNameTextView);
            titleTextView.setText(title);

            TextView playerNumberTextView = findViewById(R.id.playerCountTextView);
            playerNumberTextView.setText("Benötigte Spieler: " + playerNumberMin + " - " + playerNumberMax);

            TextView playTimeTextView = findViewById(R.id.gameDurationTextView);
            playTimeTextView.setText("Spielzeit: " + playTimeMin + "min - " + playTimeMax + "min");

            TextView difficultyTextView = findViewById(R.id.difficultyTextView);
            difficultyTextView.setText("Schwierigkeit: " + difficulty);

            TextView rulesTextView = findViewById(R.id.rulesTextView);
            rulesTextView.setText(rules);

                // RecyclerView und Adapter einrichten
            RecyclerView recyclerView = findViewById(R.id.CardsRecyclerview);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);

                // todo: hier stehen alle drawable namen: String cardNumber = extras.getString("cardNumber"); füge nur die Spielkarten hinzu dessen namen hier enthalten sind.

            String cardNumberCUT = extras.getString("cardNumber");
            String[] cardNumbers = cardNumberCUT.split(",");

            List<SpielKarten> spielKartenList = new ArrayList<>(); // Erstelle eine Liste mit Spielkarten-Objekten


            for (String number : cardNumbers) {
                int drawableResourceId = getResources().getIdentifier(number.trim(), "drawable", getPackageName());
                spielKartenList.add(new SpielKarten(drawableResourceId, number.trim()));
            }


                // Füge deine Spielkarten zur spielKartenList hinzu
            //spielKartenList.add(new SpielKarten(R.drawable.herz_zwei, "herz_zwei"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_drei, "herz_drei"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_vier, "herz_vier"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_fuenf, "herz_fuenf"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_sechs, "herz_sechs"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_sieben, "herz_sieben"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_acht, "herz_acht"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_neun, "herz_neun"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_zehn, "herz_zehn"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_bube, "herz_bube"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_dame, "herz_dame"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_koenig, "herz_koenig"));
            //spielKartenList.add(new SpielKarten(R.drawable.herz_ass, "herz_ass"));

            allCardAdapter adapter1 = new allCardAdapter(spielKartenList);
            recyclerView.setAdapter(adapter1);
        }

            // Logik um Intent zu beenden
        FloatingActionButton fabButton = findViewById(R.id.returnFabButton);
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }
}