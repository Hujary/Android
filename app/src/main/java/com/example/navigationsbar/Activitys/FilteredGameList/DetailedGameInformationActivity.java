package com.example.navigationsbar.Activitys.FilteredGameList;

import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Adapter.allCardAdapter;
import com.example.navigationsbar.Adapter.DetailedCardListAdapter;
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
            String emoji = "\uD83C\uDF7B";
            titleTextView.setText(title + " " + emoji);

            // Custom Formatierung
            TextView playerNumberTextView = findViewById(R.id.playerCountTextView);
            String TextSpieler = "Benötigte Spieler: " + playerNumberMin + " - " + playerNumberMax;
            SpannableString spannableString1 = new SpannableString(TextSpieler);
            spannableString1.setSpan(new StyleSpan(Typeface.BOLD), 0, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            playerNumberTextView.setText(spannableString1);

            TextView playTimeTextView = findViewById(R.id.gameDurationTextView);
            String TextZeit = "Spielzeit: " + playTimeMin + " - " + playTimeMax + " min";
            SpannableString spannableString2 = new SpannableString(TextZeit);
            spannableString2.setSpan(new StyleSpan(Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            playTimeTextView.setText(spannableString2);

            TextView difficultyTextView = findViewById(R.id.difficultyTextView);
            String TextSchwierigkeit = "Schwierigkeit: " + difficulty;
            SpannableString spannableString3 = new SpannableString(TextSchwierigkeit);
            spannableString3.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            difficultyTextView.setText(spannableString3);

            // Regeln formatieren
            TextView rulesTextView = findViewById(R.id.rulesTextView);
            SpannableStringBuilder builder = new SpannableStringBuilder(rules);
            char insertedChar = '\n';
            int insertPosition = 0;
            int x = 1;
            for(int i = 0; i < rules.length(); i++){
                if(rules.charAt(i) == '.'){
                    insertPosition = i+x;
                    builder.insert(insertPosition, Character.toString(insertedChar));
                    x++;
                }
            }
            SpannableString spannableString4 = new SpannableString(builder);
            rulesTextView.setText(spannableString4);

            // RecyclerView und Adapter einrichten
            RecyclerView recyclerView = findViewById(R.id.CardsRecyclerview);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);
            String cardNumberCUT = extras.getString("cardNumber");
            String[] cardNumbers = cardNumberCUT.split(",");

            // Erstelle eine Liste mit Spielkarten-Objekten
            List<SpielKarten> spielKartenList = new ArrayList<>();

            for (String number : cardNumbers) {
                int drawableResourceId = getResources().getIdentifier(number.trim(), "drawable", getPackageName());
                spielKartenList.add(new SpielKarten(drawableResourceId, number.trim()));
            }

            //  Adapter für das Anzeigen der Spielkarten
            DetailedCardListAdapter adapter2 = new DetailedCardListAdapter(spielKartenList);
            recyclerView.setAdapter(adapter2);
        }

        // Logik um Intent zu beenden
        FloatingActionButton fabButton = findViewById(R.id.returnFabButton);
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }
}