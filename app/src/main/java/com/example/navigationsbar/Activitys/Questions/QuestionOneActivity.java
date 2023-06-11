package com.example.navigationsbar.Activitys.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.Activitys.GameData;
import com.example.navigationsbar.R;

public class QuestionOneActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {
    private TextView tvShowNumbers;
    private int chosenNumber;
    private GameData gameData; // Das GameData-Objekt als Feld deklarieren

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1_layout);
        gameData = GameData.getInstance();

        tvShowNumbers = findViewById(R.id.questionOneTextView);
        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        chosenNumber = 1;

        Button button_confirm = findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity();
            }
        });


        TextView buttonReturn = findViewById(R.id.TextView_back);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

            // Change the format of numbers in the number picker
        numberPicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", i);
            }
        });
        numberPicker.setOnValueChangedListener(this);
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
            // Store the currently selected number
        chosenNumber = newVal;
    }

    private void startNextActivity() {

            // Pass the chosen number as data to the Singelton Object
        int buttonNumber = chosenNumber;
        gameData.setNumberOfPlayers(buttonNumber);

            // Starte Frage 2 Activity
        Intent intent = new Intent(QuestionOneActivity.this, QuestionTwoActivity.class);
        startActivity(intent);
    }
}
