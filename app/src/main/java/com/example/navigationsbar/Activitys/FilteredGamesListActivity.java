package com.example.navigationsbar.Activitys;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.R;

public class FilteredGamesListActivity extends AppCompatActivity {

    TextView T6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtered_gamelist);

        //T6 = findViewById(R.id.textView6);

            // Receive the selected options array from the previous activity
        //String[] selectedOptions = getIntent().getStringArrayExtra("selectedOptions");

            // Receive the button number from the previous activity
        //int buttonNumber = getIntent().getIntExtra("buttonNumber", 0);

            // Receive the array from the previous activity
        //int[] array = getIntent().getIntArrayExtra("array");

            // zeige variable in TextView an
        //String text = ("Button Number: " + buttonNumber + ", " + "\n" + "übergebene eingabe: " + array[0] + ", " +  array[1] + ", " +  array[2]);
        //T6.setText(text);
    }
}