package com.example.navigationsbar.Activitys.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.Activitys.FilteredGameList.FilteredGamesListActivity;
import com.example.navigationsbar.Activitys.GameData;
import com.example.navigationsbar.R;

public class QuestionThreeActivity extends AppCompatActivity {

    NumberPicker numberPickerLocation;
    String[] antwortenArray = {"Ja", "Nein"};
    String chosenAnswer = "Ja";

    private GameData gameData; // Das GameData-Objekt als Feld deklarieren

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question3_layout);
        gameData = GameData.getInstance();

            // NumberPicker Werte einsetzen
        numberPickerLocation = findViewById(R.id.answerPicker);
        numberPickerLocation.setMinValue(0);
        numberPickerLocation.setMaxValue(antwortenArray.length - 1);
        numberPickerLocation.setDisplayedValues(antwortenArray);

            // Logik für Return button
        TextView buttonReturn = findViewById(R.id.TextView_back);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

            // Logik für Confirm button
        Button button_confirm = findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chosenAnswer != null && chosenAnswer.equals("Ja")) {
                    try {
                        gameData.setFehlenKarten(chosenAnswer);
                        Intent intent = new Intent(QuestionThreeActivity.this, QuestionFourActivity.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        gameData.setFehlenKarten(chosenAnswer);
                        Intent intent = new Intent(QuestionThreeActivity.this, QuestionFiveActivity.class);
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
            }
        });
    }
}