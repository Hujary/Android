package com.example.navigationsbar.Activitys.FilteredGameList;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.navigationsbar.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

            TextView cardNumberTextView = findViewById(R.id.cardCountTextView);
            cardNumberTextView.setText("Benötigte Karten: " + cardNumber);

            TextView playerNumberTextView = findViewById(R.id.playerCountTextView);
            playerNumberTextView.setText("Benötigte Spieler: " + playerNumberMin + " - " + playerNumberMax);

            TextView playTimeTextView = findViewById(R.id.gameDurationTextView);
            playTimeTextView.setText("Spielzeit: " + playTimeMin + "min - " + playTimeMax + "min");

            TextView difficultyTextView = findViewById(R.id.difficultyTextView);
            difficultyTextView.setText("Schwierigkeit: " + difficulty);

            TextView rulesTextView = findViewById(R.id.rulesTextView);
            rulesTextView.setText(rules);
        }

            // Logik um Intent zu beenden
        FloatingActionButton fabButton = findViewById(R.id.returnFabButton);
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }
}