package com.example.navigationsbar.Database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.navigationsbar.Adapter.allCardAdapter;
import com.example.navigationsbar.Items.Spielkarten.SpielKarten;
import com.example.navigationsbar.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UpdateActivity extends AppCompatActivity implements allCardAdapter.OnItemClickListener {

    EditText title_input, spielregel_input, spieleranzahlMin_input, spieleranzahlMax_input, spieldauerMin_input, spieldauerMax_input;
    Button update_button, delete_button;
    String id, title, spielregel, benötigteKarten, schwierigkeitsgrad;
    int spieleranzahlMin, spieleranzahlMax, spieldauerMin, spieldauerMax;
    allCardAdapter adapter1;

    ArrayAdapter<CharSequence> adapter;
    Spinner schwierigkeitsgradSpinner;
    List<SpielKarten> selectedCardsList2 = new ArrayList<>();
    Set<Integer> selectedPositions = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        // Get references to layout elements
        title_input = findViewById(R.id.title_input2);
        spielregel_input = findViewById(R.id.spielregel_input2);
        spieleranzahlMin_input = findViewById(R.id.spieleranzahlMin_input2);
        spieleranzahlMax_input = findViewById(R.id.spieleranzahlMax_input2);
        spieldauerMin_input = findViewById(R.id.spieldauerMin_input2);
        spieldauerMax_input = findViewById(R.id.spieldauerMax_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        // Set up the spinner and adapter
        schwierigkeitsgradSpinner = findViewById(R.id.schwierigkeitsgrad_spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.schwierigkeitsgrade_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schwierigkeitsgradSpinner.setAdapter(adapter);

        // Set up the recyclerView and add all Cards
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

        adapter1 = new allCardAdapter(spielKartenList, selectedPositions, false);
        recyclerView.setAdapter(adapter1);
        adapter1.setOnItemClickListener(this);

        // Retrieve and set intent data
        getAndSetIntentData(spielKartenList);

        // Update button click listener
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInputs()) {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                    title = title_input.getText().toString().trim();
                    spielregel = spielregel_input.getText().toString().trim();
                    benötigteKarten = getSelectedCardNamesAsString(spielKartenList, selectedPositions);
                    spieleranzahlMin = Integer.parseInt(spieleranzahlMin_input.getText().toString().trim());
                    spieleranzahlMax = Integer.parseInt(spieleranzahlMax_input.getText().toString().trim());
                    spieldauerMin = Integer.parseInt(spieldauerMin_input.getText().toString().trim());
                    spieldauerMax = Integer.parseInt(spieldauerMax_input.getText().toString().trim());
                    schwierigkeitsgrad = schwierigkeitsgradSpinner.getSelectedItem().toString();
                    myDB.updateData(id, title, spielregel, benötigteKarten, spieleranzahlMin, spieleranzahlMax, spieldauerMin, spieldauerMax, schwierigkeitsgrad);
                    finish();
                }
            }
        });

        // Delete button click listener
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInputs()) {
                    confirmDialog();
                }
            }
        });
    }

    void getAndSetIntentData(List<SpielKarten> spielKartenList) {
        // Retrieve values from Intent
        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");
        spielregel = getIntent().getStringExtra("spielregel");
        benötigteKarten = getIntent().getStringExtra("benötigteKarten");
        spieleranzahlMin = Integer.parseInt(getIntent().getStringExtra("spieleranzahlMin"));
        spieleranzahlMax = Integer.parseInt(getIntent().getStringExtra("spieleranzahlMax"));
        spieldauerMin = Integer.parseInt(getIntent().getStringExtra("spieldauerMin"));
        spieldauerMax = Integer.parseInt(getIntent().getStringExtra("spieldauerMax"));
        schwierigkeitsgrad = getIntent().getStringExtra("schwierigkeitsgrad");

        // Set values in EditText
        title_input.setText(title);
        spielregel_input.setText(spielregel);
        spieleranzahlMin_input.setText(String.valueOf(spieleranzahlMin));
        spieleranzahlMax_input.setText(String.valueOf(spieleranzahlMax));
        spieldauerMin_input.setText(String.valueOf(spieldauerMin));
        spieldauerMax_input.setText(String.valueOf(spieldauerMax));

        // Set the selected item in the spinner
        int spinnerPosition = adapter.getPosition(schwierigkeitsgrad);
        schwierigkeitsgradSpinner.setSelection(spinnerPosition);

        for (int i = 0; i < spielKartenList.size(); i++) {
            SpielKarten spielKarte = spielKartenList.get(i);
            if (benötigteKarten.contains(spielKarte.getName())) {
                selectedPositions.add(i);
            }
        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title + " ?");
        builder.setMessage("Are you sure you want to delete " + title + " ?");

        // User wants to proceed with the deletion
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });

        // User wants to cancel the deletion
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do nothing
            }
        });
        builder.create().show();
    }

    private boolean isTitleValid(String title) {
        int maxLength = 20;
        return title.length() <= maxLength;
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
            Toast.makeText(this, "Bitte füllen Sie alle Felder aus.", Toast.LENGTH_SHORT).show();
            return false;   // Eine oder mehrere Eingaben fehlen
        }

        // Überprüfen, ob der Titel gültig ist
        if (!isTitleValid(title)) {
            Toast.makeText(this, "Der Titel darf maximal 20 Zeichen haben.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;        // Alle Eingaben sind vorhanden und gültig
    }

    private String getSelectedCardNamesAsString(List<SpielKarten> spielKartenList, Set<Integer> selectedPositions) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer position : selectedPositions) {
            SpielKarten spielKarte = spielKartenList.get(position);
            stringBuilder.append(spielKarte.getName()).append(", ");
        }

        if (stringBuilder.length() > 0) {
            // Remove the last comma and space
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.toString();
    }

    @Override
    public void onItemClick(SpielKarten spielkarte, int position) {
        if (selectedCardsList2.contains(spielkarte)) {
            selectedCardsList2.remove(spielkarte);   // Karte wurde abgewählt
        } else {
            selectedCardsList2.add(spielkarte);      // Karte wurde ausgewählt
        }
    }
}