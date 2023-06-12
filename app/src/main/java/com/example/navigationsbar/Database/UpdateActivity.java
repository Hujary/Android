package com.example.navigationsbar.Database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigationsbar.Items.Article.Article;
import com.example.navigationsbar.R;

public class UpdateActivity extends AppCompatActivity {

    EditText title_input, spielregel_input, benötigteKarten_input, spieleranzahlMin_input, spieleranzahlMax_input,
            spieldauerMin_input, spieldauerMax_input, schwierigkeitsgrad_input;
    Button update_button, delete_button;

    String id, title, spielregel, benötigteKarten;
    int spieleranzahlMin, spieleranzahlMax, spieldauerMin, spieldauerMax;
    String schwierigkeitsgrad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title_input = findViewById(R.id.title_input2);
        spielregel_input = findViewById(R.id.spielregel_input2);
        benötigteKarten_input = findViewById(R.id.benötigteKarten_input2);
        spieleranzahlMin_input = findViewById(R.id.spieleranzahlMin_input2);
        spieleranzahlMax_input = findViewById(R.id.spieleranzahlMax_input2);
        spieldauerMin_input = findViewById(R.id.spieldauerMin_input2);
        spieldauerMax_input = findViewById(R.id.spieldauerMax_input2);
        schwierigkeitsgrad_input = findViewById(R.id.schwierigkeitsgrad_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        getAndSetIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                title = title_input.getText().toString().trim();
                spielregel = spielregel_input.getText().toString().trim();
                benötigteKarten = benötigteKarten_input.getText().toString().trim();
                spieleranzahlMin = Integer.parseInt(spieleranzahlMin_input.getText().toString().trim());
                spieleranzahlMax = Integer.parseInt(spieleranzahlMax_input.getText().toString().trim());
                spieldauerMin = Integer.parseInt(spieldauerMin_input.getText().toString().trim());
                spieldauerMax = Integer.parseInt(spieldauerMax_input.getText().toString().trim());
                schwierigkeitsgrad = schwierigkeitsgrad_input.getText().toString().trim();

                myDB.updateData(id, new Article(title, spielregel, benötigteKarten, spieleranzahlMin,
                        spieleranzahlMax, spieldauerMin, spieldauerMax, schwierigkeitsgrad));
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("spielregel")
                && getIntent().hasExtra("benötigteKarten") && getIntent().hasExtra("spieleranzahlMin")
                && getIntent().hasExtra("spieleranzahlMax") && getIntent().hasExtra("spieldauerMin")
                && getIntent().hasExtra("spieldauerMax") && getIntent().hasExtra("schwierigkeitsgrad")) {
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            spielregel = getIntent().getStringExtra("spielregel");
            benötigteKarten = getIntent().getStringExtra("benötigteKarten");
            spieleranzahlMin = Integer.parseInt(getIntent().getStringExtra("spieleranzahlMin"));
            spieleranzahlMax = Integer.parseInt(getIntent().getStringExtra("spieleranzahlMax"));
            spieldauerMin = Integer.parseInt(getIntent().getStringExtra("spieldauerMin"));
            spieldauerMax = Integer.parseInt(getIntent().getStringExtra("spieldauerMax"));
            schwierigkeitsgrad = getIntent().getStringExtra("schwierigkeitsgrad");

            title_input.setText(title);
            spielregel_input.setText(spielregel);
            benötigteKarten_input.setText(benötigteKarten);
            spieleranzahlMin_input.setText(String.valueOf(spieleranzahlMin));
            spieleranzahlMax_input.setText(String.valueOf(spieleranzahlMax));
            spieldauerMin_input.setText(String.valueOf(spieldauerMin));
            spieldauerMax_input.setText(String.valueOf(spieldauerMax));
            schwierigkeitsgrad_input.setText(schwierigkeitsgrad);
            Log.d("stev", title + " " + spielregel + " " + benötigteKarten + " " + spieleranzahlMin + " " +
                    spieleranzahlMax + " " + spieldauerMin + " " + spieldauerMax + " " + schwierigkeitsgrad);
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title + " ?");
        builder.setMessage("Are you sure you want to delete " + title + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}