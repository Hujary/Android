package com.example.navigationsbar.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionTwoActivity extends AppCompatActivity {

    private ToggleButton toggleButton1;
    private ToggleButton toggleButton2;
    private ToggleButton toggleButton3;

    private int[] array;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question2_layout);

        toggleButton1 = findViewById(R.id.toggleButton1);
        toggleButton2 = findViewById(R.id.toggleButton2);
        toggleButton3 = findViewById(R.id.toggleButton3);

        // Get Data from the First Question.
        int buttonNumber = getIntent().getIntExtra("buttonNumber", 0);

        // Initialize the array with index 3 and set all values to 0
        array = new int[3];

        // Set OnCheckedChangeListener for toggleButton1
        toggleButton1.setOnCheckedChangeListener(optionCheckedChangeListener);

        // Set OnCheckedChangeListener for toggleButton2
        toggleButton2.setOnCheckedChangeListener(optionCheckedChangeListener);

        // Set OnCheckedChangeListener for toggleButton3
        toggleButton3.setOnCheckedChangeListener(optionCheckedChangeListener);

        submitButton = findViewById(R.id.button_submit);
        submitButton.setVisibility(View.INVISIBLE);
        submitButton.setEnabled(false);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a list to store the selected options
                List<String> selectedOptions = new ArrayList<>();

                // Check the state of the toggle buttons and add the selected options to the list
                if (toggleButton1.isChecked()) {
                    selectedOptions.add("Option 1");
                }
                if (toggleButton2.isChecked()) {
                    selectedOptions.add("Option 2");
                }
                if (toggleButton3.isChecked()) {
                    selectedOptions.add("Option 3");
                }

                // Convert the list to an array
                String[] selectedOptionsArray = selectedOptions.toArray(new String[0]);

                // Get Data from the First Question.
                int buttonNumber = getIntent().getIntExtra("buttonNumber", 0);

                // Create the intent for QuestionThreeActivity and pass the selected options, button number, and array
                Intent intent = new Intent(QuestionTwoActivity.this, QuestionThreeActivity.class);
                intent.putExtra("selectedOptions", selectedOptionsArray);
                intent.putExtra("buttonNumber", buttonNumber);
                intent.putExtra("array", array);
                startActivity(intent);
            }
        });

        Button buttonReturn = findViewById(R.id.button_return1);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private CompoundButton.OnCheckedChangeListener optionCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                submitButton.setVisibility(View.VISIBLE);
                submitButton.setEnabled(true);
            } else {
                // Check if any other option is selected
                if (!toggleButton1.isChecked() && !toggleButton2.isChecked() && !toggleButton3.isChecked()) {
                    submitButton.setVisibility(View.INVISIBLE);
                    submitButton.setEnabled(false);
                }
            }
        }
    };
}