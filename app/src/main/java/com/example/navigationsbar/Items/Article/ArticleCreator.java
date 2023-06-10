package com.example.navigationsbar.Items.Article;

import android.content.res.Resources;

import com.example.navigationsbar.Items.Article.Article;
import com.example.navigationsbar.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ArticleCreator {
    private Resources resources;

    public ArticleCreator(Resources resources) {
        this.resources = resources;
    }

    public List<Article> createArticles() {
        List<Article> articles = new ArrayList<>();

        try {
            // JSON-Daten aus der Ressource laden
            String jsonData = loadJSONFromResource();
            JSONObject jsonObject = new JSONObject(jsonData);

            for (int i = 1; i <= 6; i++) {
                // Den Schlüssel für jedes Spiel dynamisch generieren (z.B. "Game_1", "Game_2")
                String gameKey = "Game_" + i;
                JSONArray gameArray = jsonObject.getJSONArray(gameKey);
                JSONObject game = gameArray.getJSONObject(0);

                // Daten für das Spiel aus dem JSON-Objekt auslesen
                String name = game.getString("name");
                String spielregeln = game.getString("Regeln");
                int minSpieleranzahl = game.getInt("Spielerzahl_Min");
                int maxSpieleranzahl = game.getInt("Spieleranzahl_Max");
                String benötigteKarten = game.getString("Benötigte Karten");
                int minSpieldauer = game.getInt("SpieldauerMin");
                int maxSpieldauer = game.getInt("SpieldauerMax");
                String schwierigkeitsgrad = game.getString("Schwierigkeitsgrad");

                // Artikel erstellen und der Liste hinzufügen
                Article article = new Article(name, spielregeln, benötigteKarten, maxSpieleranzahl, minSpieleranzahl, maxSpieldauer, minSpieldauer, schwierigkeitsgrad);
                articles.add(article);
            }

            return articles;
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("Fehler: " + e);
        }

        return new ArrayList<>();
    }

    private String loadJSONFromResource() {
        String json = null;
        try {
            // JSON-Datei aus der Ressource lesen
            InputStream is = resources.openRawResource(R.raw.kartenspiele);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Fehler beim Lesen der JSON-Datei: " + ex);
        }
        return json;
    }
}