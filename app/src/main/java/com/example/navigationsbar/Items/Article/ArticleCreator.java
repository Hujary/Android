package com.example.navigationsbar.Items.Article;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.Log;

import com.example.navigationsbar.Database.MyDatabaseHelper;
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
    private MyDatabaseHelper myDB;

    public ArticleCreator(Resources resources, Context context) {
        this.resources = resources;
        myDB = new MyDatabaseHelper(context);
    }

    public List<Article> createArticles() {
        List<Article> articles = new ArrayList<>();

        // Daten aus der Datenbank abrufen
        List<Article> databaseArticles = readDatabaseData();

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

            // Datenbank-Artikel zur Liste hinzufügen
            articles.addAll(databaseArticles);

            return articles;
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("ArticleCreator", "Fehler: " + e);
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
            Log.d("ArticleCreator", "Fehler beim Lesen der JSON-Datei: " + ex);
        }
        return json;
    }

    private List<Article> readDatabaseData() {
        List<Article> databaseArticles = new ArrayList<>();

        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Log.d("ArticleCreator", "Die Datenbank ist leer.");
        } else {
            while (cursor.moveToNext()) {
                String id = cursor.getString(0);
                String title = cursor.getString(1);
                String spielregel = cursor.getString(2);
                String benötigteKarten = cursor.getString(3);
                int spieleranzahlMin = cursor.getInt(4);
                int spieleranzahlMax = cursor.getInt(5);
                int spieldauerMin = cursor.getInt(6);
                int spieldauerMax = cursor.getInt(7);
                String schwierigkeitsgrad = cursor.getString(8);

                Article article = new Article(title, spielregel, benötigteKarten, spieleranzahlMin, spieleranzahlMax, spieldauerMin, spieldauerMax, schwierigkeitsgrad);
                databaseArticles.add(article);

                String data = "ID: " + id + ", Title: " + title + ", Spielregel: " + spielregel + ", Benötigte Karten: " + benötigteKarten + ", Spieleranzahl: " + spieleranzahlMin + "-" + spieleranzahlMax + ", Spieldauer: " + spieldauerMin + "-" + spieldauerMax + ", Schwierigkeitsgrad: " + schwierigkeitsgrad;
                Log.d("ArticleCreator", data);
            }
        }

        return databaseArticles;
    }
}