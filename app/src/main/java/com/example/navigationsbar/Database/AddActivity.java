package com.example.navigationsbar.Database;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.R;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    EditText title_input, spielregel_input, benötigteKarten_input, spieleranzahlMin_input, spieleranzahlMax_input,
            spieldauerMin_input, spieldauerMax_input, schwierigkeitsgrad_input;
    Button add_button;
    LinearLayout cardContainer;

    private int[] cardResources = {
            R.drawable.herz_zwei,
            R.drawable.herz_drei,
            R.drawable.herz_vier,
            // Fügen Sie hier weitere Ressourcen-IDs für die Kartenbilder hinzu
    };

    private List<String> selectedCards = new ArrayList<>();

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
        cardContainer = findViewById(R.id.cardContainer);

        // Dynamisch Bilder hinzufügen
        for (int i = 0; i < cardResources.length; i++) {
            final int index = i; // Erforderlich, um die Variable in der anonymen Klasse zugreifbar zu machen

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            imageView.setPadding(8, 8, 8, 8);

            // Bild aus den Ressourcen laden und im ImageView setzen
            Drawable drawable = getResources().getDrawable(cardResources[i]);
            imageView.setImageDrawable(drawable);

            // Klick-Handler für die Auswahl implementieren
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView.setSelected(!imageView.isSelected());

                    if (imageView.isSelected()) {
                        // Die Karte wurde ausgewählt
                        int selectedCardIndex = cardContainer.indexOfChild(imageView);
                        int selectedCardResource = cardResources[selectedCardIndex];
                        String selectedCard = getResources().getResourceName(selectedCardResource);

                        // Konsolenausgabe
                        System.out.println("Ausgewählte Karte: " + selectedCard);

                        // Fügen Sie die ausgewählte Karte zur Liste der ausgewählten Karten hinzu
                        selectedCards.add(selectedCard);
                    } else {
                        // Die Auswahl wurde aufgehoben
                        int deselectedCardIndex = cardContainer.indexOfChild(imageView);
                        int deselectedCardResource = cardResources[deselectedCardIndex];
                        String deselectedCard = getResources().getResourceName(deselectedCardResource);

                        // Konsolenausgabe
                        System.out.println("Abgewählte Karte: " + deselectedCard);

                        // Entfernen Sie die abgewählte Karte aus der Liste der ausgewählten Karten
                        selectedCards.remove(deselectedCard);
                    }
                }
            });

            // ImageView dem Container hinzufügen
            cardContainer.addView(imageView);
        }

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hier können Sie die ausgewählten Karten abrufen und entsprechend verarbeiten
                // z.B. überprüfen, welche Karten ausgewählt sind und die entsprechenden Aktionen ausführen

                // ...

                // Ausgabe der ausgewählten Karten
                System.out.println("Ausgewählte Karten: " + selectedCards.toString());

                // ...
            }
        });
    }
}