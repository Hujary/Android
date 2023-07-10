package com.example.navigationsbar.Activitys.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.Activitys.GameDataSingelton;
import com.example.navigationsbar.Activitys.MainActivity;
import com.example.navigationsbar.Fragments.HomeFragment;
import com.example.navigationsbar.R;

public class QuestionTwoActivity extends AppCompatActivity {

    NumberPicker numberPickerLocation;
    String[] antwortenArray = {"Ja", "Nein"};
    String chosenAnswer = "Ja";

    private GameDataSingelton gameDataSingelton; // Das GameData-Objekt als Feld deklarieren

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question2_layout);
        gameDataSingelton = GameDataSingelton.getInstance();

        // NumberPicker Werte einsetzen
        numberPickerLocation = findViewById(R.id.answerPicker);
        numberPickerLocation.setMinValue(0);
        numberPickerLocation.setMaxValue(antwortenArray.length - 1);
        numberPickerLocation.setDisplayedValues(antwortenArray);

        // Logik für Return Button
        TextView buttonReturn = findViewById(R.id.TextView_back);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Logik für Home Button
        TextView buttonHome = findViewById(R.id.TextView_home);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        // Logik für Confirm Button
        Button button_confirm = findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chosenAnswer != null && chosenAnswer.equals("Ja")) {
                    try {
                        // Speichern der Antwort im GameData-Objekt
                        gameDataSingelton.setHaveCards(chosenAnswer);
                        Intent intent = new Intent(QuestionTwoActivity.this, QuestionThreeActivity.class);
                        intent.putExtra("SpielkartenAnswer", chosenAnswer);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        // Speichern der Antwort im GameData-Objekt
                        gameDataSingelton.setHaveCards(chosenAnswer);
                        Intent intent = new Intent(QuestionTwoActivity.this, QuestionFiveActivity.class);
                        intent.putExtra("SpielkartenAnswer", chosenAnswer);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Werte vom NumberPicker speichern
        numberPickerLocation.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                chosenAnswer = antwortenArray[newVal];
                System.out.println(chosenAnswer);
            }
        });
    }
}