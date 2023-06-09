package com.example.navigationsbar.Activitys.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.Activitys.FilteredGameList.FilteredGamesListActivity;
import com.example.navigationsbar.Activitys.GameDataSingelton;
import com.example.navigationsbar.Activitys.MainActivity;
import com.example.navigationsbar.R;

public class QuestionFiveActivity extends AppCompatActivity {
    NumberPicker numberPickerLocation;
    String[] antwortenArray = {"egal", "einfach", "medium", "schwer"};
    String chosenAnswer;
    // Das GameData-Objekt als Feld deklarieren
    private GameDataSingelton gameDataSingelton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question5_layout);
        gameDataSingelton = GameDataSingelton.getInstance();
        gameDataSingelton.setSchwierigkeit(antwortenArray[0]);

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

        // Logik für Home button
        TextView buttonHome = findViewById(R.id.TextView_home);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        // Logik für Confirm button
        Button button_confirm = findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startNextActivity(); }
        });

        // Werte vom NumberPicker speichern
        numberPickerLocation.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                chosenAnswer = antwortenArray[newVal];
            }
        });
    }

    // Start the intent and pass the value
    private void startNextActivity() {
        gameDataSingelton.setSchwierigkeit(chosenAnswer);
        Intent intent = new Intent(QuestionFiveActivity.this, FilteredGamesListActivity.class);
        startActivity(intent);
    }
}