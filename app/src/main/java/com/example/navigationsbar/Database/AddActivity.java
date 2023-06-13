package com.example.navigationsbar.Database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.R;

public class AddActivity extends AppCompatActivity {

    EditText title_input, spielregel_input, benötigteKarten_input, spieleranzahlMin_input, spieleranzahlMax_input,
            spieldauerMin_input, spieldauerMax_input, schwierigkeitsgrad_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        spielregel_input = findViewById(R.id.spielregel_input);
        benötigteKarten_input = findViewById(R.id.benötigteKarten_input);
        spieleranzahlMin_input = findViewById(R.id.spieleranzahlMin_input);
        spieleranzahlMax_input = findViewById(R.id.spieleranzahlMax_input);
        spieldauerMin_input = findViewById(R.id.spieldauerMin_input);
        spieldauerMax_input = findViewById(R.id.spieldauerMax_input);
        schwierigkeitsgrad_input = findViewById(R.id.schwierigkeitsgrad_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addArticle(
                        title_input.getText().toString().trim(),
                        spielregel_input.getText().toString().trim(),
                        benötigteKarten_input.getText().toString().trim(),
                        Integer.parseInt(spieleranzahlMin_input.getText().toString().trim()),
                        Integer.parseInt(spieleranzahlMax_input.getText().toString().trim()),
                        Integer.parseInt(spieldauerMin_input.getText().toString().trim()),
                        Integer.parseInt(spieldauerMax_input.getText().toString().trim()),
                        schwierigkeitsgrad_input.getText().toString().trim(),
                        "user");
                finish();
            }
        });
    }
}