package com.example.navigationsbar.Database;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.R;

public class AddActivity extends AppCompatActivity implements ApiCallTask.ApiCallTaskCallback {

    EditText title_input, spielregel_input, benötigteKarten_input, spieleranzahlMin_input, spieleranzahlMax_input,
            spieldauerMin_input, spieldauerMax_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Hier Variablen für Layout-Elemente erstellen.
        Spinner schwierigkeitsgradSpinner = findViewById(R.id.schwierigkeitsgrad_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.schwierigkeitsgrade_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schwierigkeitsgradSpinner.setAdapter(adapter);

        title_input = findViewById(R.id.title_input);
        spielregel_input = findViewById(R.id.spielregel_input);
        benötigteKarten_input = findViewById(R.id.benötigteKarten_input);
        spieleranzahlMin_input = findViewById(R.id.spieleranzahlMin_input);
        spieleranzahlMax_input = findViewById(R.id.spieleranzahlMax_input);
        spieldauerMin_input = findViewById(R.id.spieldauerMin_input);
        spieldauerMax_input = findViewById(R.id.spieldauerMax_input);
        CheckBox checkBox = findViewById(R.id.checkBox2);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                String title = title_input.getText().toString().trim();
                String spielregel = spielregel_input.getText().toString().trim();
                String benötigteKarten = benötigteKarten_input.getText().toString().trim();
                int spieleranzahlMin = Integer.parseInt(spieleranzahlMin_input.getText().toString().trim());
                int spieleranzahlMax = Integer.parseInt(spieleranzahlMax_input.getText().toString().trim());
                int spieldauerMin = Integer.parseInt(spieldauerMin_input.getText().toString().trim());
                int spieldauerMax = Integer.parseInt(spieldauerMax_input.getText().toString().trim());
                String schwierigkeitsgrad = schwierigkeitsgradSpinner.getSelectedItem().toString().trim();

                myDB.addArticle(
                        title,
                        spielregel,
                        benötigteKarten,
                        spieleranzahlMin,
                        spieleranzahlMax,
                        spieldauerMin,
                        spieldauerMax,
                        schwierigkeitsgrad,
                        "user");

                if (checkBox.isChecked()) {
                        // Checkbox ist ausgewählt, führe den API-Aufruf aus
                    String apiUrl = "https://androidpartysaverbackend.azurewebsites.net/api/androidAPITrigger";
                    ApiCallTask apiCallTask = new ApiCallTask(apiUrl, title, spielregel, spieleranzahlMin, spieleranzahlMax, benötigteKarten, spieldauerMin, spieldauerMax, schwierigkeitsgrad, AddActivity.this);
                    apiCallTask.execute();
                }
                finish();
            }
        });
    }

    @Override
    public void onApiCallComplete(String result) {
        // Hier kannst du den Toast anzeigen
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}