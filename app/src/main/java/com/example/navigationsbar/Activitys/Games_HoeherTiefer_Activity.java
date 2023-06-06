package com.example.navigationsbar.Activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.R;

import java.util.Random;

public class Games_HoeherTiefer_Activity extends AppCompatActivity {

    private ImageView ImageViewKarten;
    private TextView textViewNumber;
    private TextView textViewInfo;
    private TextView textViewStreak;
    private int currentNumber;
    private int newNumber;
    private String NewNumberToName;
    private String currentNumberToName;

    private String[] numberNames = {
                // besserer Weg als ein Switch Case
            "", "Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs", "Sieben", "Acht", "Neun", "Zehn",
            "Bube", "Dame", "König", "Ass"
    };

    private int streakNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_hoeher_tiefer);

        textViewStreak = findViewById(R.id.textView7);
        textViewNumber = findViewById(R.id.textView5);
        textViewInfo = findViewById(R.id.textView4);
        ImageViewKarten = findViewById(R.id.imageViewKarten);

        Button buttonBack = findViewById(R.id.ButtonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button buttonGleich = findViewById(R.id.ButtonGleich);
        buttonGleich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess("same");
            }
        });

        Button buttonHigher = findViewById(R.id.ButtonHoeher);
        buttonHigher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess("higher");
            }
        });

        Button buttonLower = findViewById(R.id.ButtonTiefer);
        buttonLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess("lower");
            }
        });
        generateRandomNumber(1, 14);
    }

    private void generateRandomNumber(int low, int high) {
        // Method to generate a new random number
        Random random = new Random();
        currentNumber = random.nextInt(high - low + 1) + low;

        textViewNumber.setText(String.valueOf(currentNumber));
        currentNumberToName = getNameOfNumber(currentNumber);
        ImageViewKarten.setImageResource(R.drawable.herz_ass);
    }

    private String getNameOfNumber(int randomNumber) {
        if (randomNumber >= 1 && randomNumber <= 14) {
            return numberNames[randomNumber];
        } else {
            return "";
        }
    }

    private void checkGuess(String guess) {
        // Generate a new random number
        Random random = new Random();
        newNumber = random.nextInt(14 - 1 + 1) + 1;
        textViewNumber.setText(String.valueOf(newNumber));
        NewNumberToName = getNameOfNumber(newNumber);

        if ((guess.equals("higher") && newNumber > currentNumber) ||
                (guess.equals("lower") && newNumber < currentNumber) ||
                (guess.equals("same") && newNumber == currentNumber)) {
            // You win
            textViewInfo.setText("Dein Tipp war korrekt, vorherige Karte: " + currentNumberToName + ", gezogene Karte: " + NewNumberToName);
            currentNumber = newNumber;
            streakNumber++;
            textViewStreak.setText("aktueller Streak: " + streakNumber);
        } else {
            // You lose
            textViewInfo.setText("Dein Tipp war leider falsch. Versuche es erneut. vorherige Karte: " + currentNumberToName + ", gezogene Karte: " + NewNumberToName);
            streakNumber = 0;
            textViewStreak.setText("aktueller Streak: " + streakNumber);
        }
    }
}