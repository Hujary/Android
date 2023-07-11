package com.example.navigationsbar.Database;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Adapter.allCardAdapter;
import com.example.navigationsbar.Items.Spielkarten.SpielKarten;
import com.example.navigationsbar.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddActivity extends AppCompatActivity implements allCardAdapter.OnItemClickListener, ApiCallTask.ApiCallTaskCallback {

    EditText title_input, spielregel_input, spieleranzahlMin_input, spieleranzahlMax_input,
            spieldauerMin_input, spieldauerMax_input;
    Button add_button;
    TextView textView_back2;
    List<SpielKarten> selectedCardsList = new ArrayList<>();
    Set<Integer> selectedCardsList1 = new HashSet<>();

    // Alle Spielkarten als Vorauswahl
    String[] allCardsArray = {
            "herz_zwei", "herz_drei", "herz_vier", "herz_fuenf", "herz_sechs", "herz_sieben", "herz_acht", "herz_neun", "herz_zehn",
            "herz_bube", "herz_dame", "herz_koenig", "herz_ass", "pik_zwei", "pik_drei", "pik_vier", "pik_fuenf", "pik_sechs",
            "pik_sieben", "pik_acht", "pik_neun", "pik_zehn", "pik_bube", "pik_dame", "pik_koenig", "pik_ass", "kreuz_zwei",
            "kreuz_drei", "kreuz_vier", "kreuz_fuenf", "kreuz_sechs", "kreuz_sieben", "kreuz_acht", "kreuz_neun", "kreuz_zehn",
            "kreuz_bube", "kreuz_dame", "kreuz_koenig", "kreuz_ass", "karo_zwei", "karo_drei", "karo_vier", "karo_fuenf",
            "karo_sechs", "karo_sieben", "karo_acht", "karo_neun", "karo_zehn", "karo_bube", "karo_dame", "karo_koenig", "karo_ass"
    };

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
        spieleranzahlMin_input = findViewById(R.id.spieleranzahlMin_input);
        spieleranzahlMax_input = findViewById(R.id.spieleranzahlMax_input);
        spieldauerMin_input = findViewById(R.id.spieldauerMin_input);
        spieldauerMax_input = findViewById(R.id.spieldauerMax_input);
        CheckBox checkBox = findViewById(R.id.checkBox2);
        add_button = findViewById(R.id.add_button);
        textView_back2 = findViewById(R.id.textView_back2);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInputs()) {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                    String title = title_input.getText().toString().trim();
                    String spielregel = spielregel_input.getText().toString().trim();
                    String selectedCardNamesString = getSelectedCardNamesAsString();
                    int spieleranzahlMin = Integer.parseInt(spieleranzahlMin_input.getText().toString().trim());
                    int spieleranzahlMax = Integer.parseInt(spieleranzahlMax_input.getText().toString().trim());
                    int spieldauerMin = Integer.parseInt(spieldauerMin_input.getText().toString().trim());
                    int spieldauerMax = Integer.parseInt(spieldauerMax_input.getText().toString().trim());
                    String schwierigkeitsgrad = schwierigkeitsgradSpinner.getSelectedItem().toString().trim();

                    // Gib den String mit den ausgewählten Karten aus
                    System.out.println(selectedCardNamesString);

                    myDB.addArticle(
                            title,
                            spielregel,
                            selectedCardNamesString,
                            spieleranzahlMin,
                            spieleranzahlMax,
                            spieldauerMin,
                            spieldauerMax,
                            schwierigkeitsgrad,
                            "user");

                    myDB.close();

                    if (checkBox.isChecked()) {
                        // Checkbox ist ausgewählt, führe den API-Aufruf aus
                        String apiUrl = "https://androidpartysaverbackend.azurewebsites.net/api/androidAPITrigger";
                        ApiCallTask apiCallTask = new ApiCallTask(apiUrl, title, spielregel, spieleranzahlMin, spieleranzahlMax, selectedCardNamesString, spieldauerMin, spieldauerMax, schwierigkeitsgrad, AddActivity.this);
                        apiCallTask.execute();
                    }
                    finish();
                } else {
                    Toast.makeText(AddActivity.this, "Bitte füllen Sie alle Felder aus", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textView_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // RecyclerView und Adapter einrichten
        RecyclerView recyclerView = findViewById(R.id.CardsRecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        List<SpielKarten> spielKartenList = new ArrayList<>();

        // Füge deine Spielkarten zur spielKartenList hinzu
        spielKartenList.add(new SpielKarten(R.drawable.herz_zwei, "herz_zwei"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_drei, "herz_drei"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_vier, "herz_vier"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_fuenf, "herz_fuenf"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_sechs, "herz_sechs"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_sieben, "herz_sieben"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_acht, "herz_acht"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_neun, "herz_neun"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_zehn, "herz_zehn"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_bube, "herz_bube"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_dame, "herz_dame"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_koenig, "herz_koenig"));
        spielKartenList.add(new SpielKarten(R.drawable.herz_ass, "herz_ass"));

        spielKartenList.add(new SpielKarten(R.drawable.karo_zwei, "karo_zwei"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_drei, "karo_drei"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_vier, "karo_vier"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_fuenf, "karo_fuenf"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_sechs, "karo_sechs"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_sieben, "karo_sieben"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_acht, "karo_acht"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_neun, "karo_neun"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_zehn, "karo_zehn"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_bube, "karo_bube"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_dame, "karo_dame"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_koenig, "karo_koenig"));
        spielKartenList.add(new SpielKarten(R.drawable.karo_ass, "karo_ass"));

        spielKartenList.add(new SpielKarten(R.drawable.pik_zwei, "pik_zwei"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_drei, "pik_drei"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_vier, "pik_vier"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_fuenf, "pik_fuenf"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_sechs, "pik_sechs"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_sieben, "pik_sieben"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_acht, "pik_acht"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_neun, "pik_neun"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_zehn, "pik_zehn"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_bube, "pik_bube"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_dame, "pik_dame"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_koenig, "pik_koenig"));
        spielKartenList.add(new SpielKarten(R.drawable.pik_ass, "pik_ass"));

        spielKartenList.add(new SpielKarten(R.drawable.kreuz_zwei, "kreuz_zwei"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_drei, "kreuz_drei"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_vier, "kreuz_vier"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_fuenf, "kreuz_fuenf"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_sechs, "kreuz_sechs"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_sieben, "kreuz_sieben"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_acht, "kreuz_acht"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_neun, "kreuz_neun"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_zehn, "kreuz_zehn"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_bube, "kreuz_bube"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_dame, "kreuz_dame"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_koenig, "kreuz_koenig"));
        spielKartenList.add(new SpielKarten(R.drawable.kreuz_ass, "kreuz_ass"));

        allCardAdapter adapter1 = new allCardAdapter(spielKartenList, selectedCardsList1, true);
        recyclerView.setAdapter(adapter1);
        adapter1.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(SpielKarten spielkarte, int position) {
        if (selectedCardsList.contains(spielkarte)) {
            selectedCardsList.remove(spielkarte);   // Karte wurde abgewählt
        } else {
            selectedCardsList.add(spielkarte);      // Karte wurde ausgewählt
        }
        System.out.println("ausgewählte Karten: " + selectedCardsList);
    }

    @Override
    public void onApiCallComplete(String result) {
        // Hier kannst du den Toast anzeigen
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    private boolean validateInputs() {
        String title = title_input.getText().toString().trim();
        String spielregel = spielregel_input.getText().toString().trim();
        String spieleranzahlMin = spieleranzahlMin_input.getText().toString().trim();
        String spieleranzahlMax = spieleranzahlMax_input.getText().toString().trim();
        String spieldauerMin = spieldauerMin_input.getText().toString().trim();
        String spieldauerMax = spieldauerMax_input.getText().toString().trim();

        // Überprüfen, ob alle Eingabefelder ausgefüllt sind
        if (title.isEmpty() || spielregel.isEmpty() ||
                spieleranzahlMin.isEmpty() || spieleranzahlMax.isEmpty() ||
                spieldauerMin.isEmpty() || spieldauerMax.isEmpty()) {
            return false;   // Eine oder mehrere Eingaben fehlen
        }
        return true;        // Alle Eingaben sind vorhanden
    }

    // Methode, um die ausgewählten Karten als einen einzelnen String mit Kommatrennung zurückzugeben
    private String getSelectedCardNamesAsString() {
        StringBuilder stringBuilder = new StringBuilder();

        // Überprüfe jede Karte aus dem allCardsArray
        for (String cardName : allCardsArray) {
            // Überprüfe, ob die Karte vom Benutzer abgewählt wurde
            boolean isCardSelected = false;
            for (SpielKarten selectedCard : selectedCardsList) {
                if (selectedCard.getName().equals(cardName)) {
                    isCardSelected = true;
                    break;
                }
            }
            // Füge die Karte zum stringBuilder hinzu, wenn sie nicht abgewählt wurde
            if (!isCardSelected) {
                stringBuilder.append(cardName).append(", ");
            }
        }
        // Entferne das letzte Komma und Leerzeichen, falls sie vorhanden sind
        int length = stringBuilder.length();
        if (length > 0) {
            stringBuilder.delete(length - 2, length);
        }
        return stringBuilder.toString();
    }
}