package com.example.navigationsbar.Activitys.FilteredGameList;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.navigationsbar.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailedGameInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailedgamerule_layout);

        FloatingActionButton fabButton = findViewById(R.id.returnFabButton);
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }
}