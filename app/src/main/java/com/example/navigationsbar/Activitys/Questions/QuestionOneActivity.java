package com.example.navigationsbar.Activitys.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.R;

public class QuestionOneActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1_layout);

        Button buttonReturn = findViewById(R.id.buttonBack);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            // Setze den Listener für die Antwort-Buttons
        Button button1 = findViewById(R.id.button_true);
        Button button2 = findViewById(R.id.button_false);
        Button button3 = findViewById(R.id.button7);
        Button button4 = findViewById(R.id.button8);
        Button button5 = findViewById(R.id.button9);
        Button button6 = findViewById(R.id.button10);
        Button button7 = findViewById(R.id.button11);
        Button button8 = findViewById(R.id.button12);
        Button button9 = findViewById(R.id.button13);
        Button button10 = findViewById(R.id.button14);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            // Nummer des Buttons als Daten an den neuen Intent übergeben
        String buttonText = ((Button) v).getText().toString();
        int buttonNumber = Integer.parseInt(buttonText);

        Intent intent = new Intent(QuestionOneActivity.this, QuestionTwoActivity.class);
        intent.putExtra("buttonNumber", buttonNumber);
        startActivity(intent);
    }
}