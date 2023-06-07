package com.example.navigationsbar.Activitys.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.Activitys.FilteredGameList.FilteredGamesListActivity;
import com.example.navigationsbar.R;

public class QuestionThreeActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question3_layout);

            // Es fehlen Karten -> Abfrage welche fehlen
        Button TrueButton = findViewById(R.id.button_true);
        TrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionThreeActivity.this, QuestionFourActivity.class);
                startActivity(intent);
            }
        });

            // Es fehlen keine Karten -> filtered Gamelist aufrufen
        Button FalseButton = findViewById(R.id.button_false);
        FalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionThreeActivity.this, FilteredGamesListActivity.class);
                startActivity(intent);
            }
        });

            // Zurück zur vorherigen Frage
        Button buttonReturn = findViewById(R.id.button_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
