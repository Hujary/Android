package com.example.navigationsbar.Activitys.Games;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
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

    private boolean isCardBackVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_hoeher_tiefer);

        textViewStreak = findViewById(R.id.textView7);
        textViewNumber = findViewById(R.id.textView5);
        textViewInfo = findViewById(R.id.textView4);
        ImageViewKarten = findViewById(R.id.imageViewKarten);
        ImageViewKarten.setImageResource(R.drawable.card_back);
        isCardBackVisible = true;
        ImageViewKarten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {flipAnimation();}
        });


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
        generateRandomNumber(2, 14);
    }

    private void flipAnimation() {
        ObjectAnimator oa1, oa2;

        if (isCardBackVisible) {
            oa1 = ObjectAnimator.ofFloat(ImageViewKarten, "rotationY", 0f, 90f);
            oa2 = ObjectAnimator.ofFloat(ImageViewKarten, "rotationY", -90f, 0f);
        } else {
            oa1 = ObjectAnimator.ofFloat(ImageViewKarten, "rotationY", 0f, -90f);
            oa2 = ObjectAnimator.ofFloat(ImageViewKarten, "rotationY", 90f, 0f);
        }

        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (isCardBackVisible) {
                    ImageViewKarten.setImageResource(R.drawable.card_back);
                    isCardBackVisible = false;
                } else {
                    generateRandomNumber(2, 14);
                    isCardBackVisible = true;
                }
                oa2.start();
            }
        });

        oa1.setDuration(200);
        oa2.setDuration(200);

        oa1.start();
    }

    private void generateRandomNumber(int low, int high) {
        // Method to generate a new random number
        Random random = new Random();
        currentNumber = random.nextInt(high - low + 1) + low;

        textViewNumber.setText(String.valueOf(currentNumber));
        currentNumberToName = getNameOfNumber(currentNumber);
        setImageResourceForNumber(currentNumber);
    }

    private String getNameOfNumber(int randomNumber) {
        if (randomNumber > 2 && randomNumber <= 14) {
            return numberNames[randomNumber];
        } else {
            return "";
        }
    }

    private void setImageResourceForNumber(int number) {
        int resourceID;
        switch (number) {
            case 2:
                resourceID = R.drawable.pik_zwei;
                break;
            case 3:
                resourceID = R.drawable.pik_drei;
                break;
            case 4:
                resourceID = R.drawable.pik_vier;
                break;
            case 5:
                resourceID = R.drawable.pik_fuenf;
                break;
            case 6:
                resourceID = R.drawable.pik_sechs;
                break;
            case 7:
                resourceID = R.drawable.pik_sieben;
                break;
            case 8:
                resourceID = R.drawable.pik_acht;
                break;
            case 9:
                resourceID = R.drawable.pik_neun;
                break;
            case 10:
                resourceID = R.drawable.pik_zehn;
                break;
            case 11:
                resourceID = R.drawable.pik_bube;
                break;
            case 12:
                resourceID = R.drawable.pik_dame;
                break;
            case 13:
                resourceID = R.drawable.pik_koenig;
                break;
            case 14:
                resourceID = R.drawable.pik_ass;
                break;
            default:
                resourceID = 0; // No image resource for invalid number
                break;
        }

        ImageViewKarten.setImageResource(resourceID);
    }

    private void checkGuess(String guess) {
        // Generate a new random number
        Random random = new Random();
        newNumber = random.nextInt(14 - 2 + 1) + 2;
        textViewNumber.setText(String.valueOf(newNumber));
        NewNumberToName = getNameOfNumber(newNumber);

        String previousNumberToName = currentNumberToName; // Speichern des vorherigen Kartenwertes

        setImageResourceForNumber(newNumber);

        if ((guess.equals("higher") && newNumber > currentNumber) ||
                (guess.equals("lower") && newNumber < currentNumber) ||
                (guess.equals("same") && newNumber == currentNumber)) {
            // You win
            textViewInfo.setText("Dein Tipp war korrekt");
            currentNumber = newNumber;
            currentNumberToName = NewNumberToName; // Aktualisieren des aktuellen Kartenwertes
            streakNumber++;
            textViewStreak.setText("aktueller Streak: " + streakNumber);
        } else {
            // You lose
            textViewInfo.setText("Dein Tipp war leider falsch");
            streakNumber = 0;
            textViewStreak.setText("aktueller Streak: " + streakNumber);
        }
    }
}