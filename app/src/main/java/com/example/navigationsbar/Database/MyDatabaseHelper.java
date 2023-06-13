package com.example.navigationsbar.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

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

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_library";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_SPIELREGEL = "spielregel";
    private static final String COLUMN_BENÖTIGTE_KARTEN = "benötigte_karten";
    private static final String COLUMN_SPIELERANZAHL_MIN = "spieleranzahl_min";
    private static final String COLUMN_SPIELERANZAHL_MAX = "spieleranzahl_max";
    private static final String COLUMN_SPIELDAUER_MIN = "spieldauer_min";
    private static final String COLUMN_SPIELDAUER_MAX = "spieldauer_max";
    private static final String COLUMN_SCHWIERIGKEITSGRAD = "schwierigkeitsgrad";
    private static final String COLUMN_CREATOR = "creator";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_SPIELREGEL + " TEXT, " +
                COLUMN_BENÖTIGTE_KARTEN + " TEXT, " +
                COLUMN_SPIELERANZAHL_MIN + " INTEGER, " +
                COLUMN_SPIELERANZAHL_MAX + " INTEGER, " +
                COLUMN_SPIELDAUER_MIN + " INTEGER, " +
                COLUMN_SPIELDAUER_MAX + " INTEGER, " +
                COLUMN_SCHWIERIGKEITSGRAD + " TEXT, " +
                COLUMN_CREATOR + " TEXT);";
        db.execSQL(query);

            // JSON-Datenbank laden
        addJsonDataToDatabase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addArticle(String title, String spielregel, String benötigteKarten, int spieleranzahlMin, int spieleranzahlMax, int spieldauerMin, int spieldauerMax, String schwierigkeitsgrad, String creator) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_SPIELREGEL, spielregel);
        cv.put(COLUMN_BENÖTIGTE_KARTEN, benötigteKarten);
        cv.put(COLUMN_SPIELERANZAHL_MIN, spieleranzahlMin);
        cv.put(COLUMN_SPIELERANZAHL_MAX, spieleranzahlMax);
        cv.put(COLUMN_SPIELDAUER_MIN, spieldauerMin);
        cv.put(COLUMN_SPIELDAUER_MAX, spieldauerMax);
        cv.put(COLUMN_SCHWIERIGKEITSGRAD, schwierigkeitsgrad);
        cv.put(COLUMN_CREATOR, creator);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Log.d("MyDatabaseHelper", "Error inserting data");
        } else {
            Log.d("MyDatabaseHelper", "Data inserted successfully");
        }
    }

        //  Alle Daten lesen.
    public Cursor readAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        return db.rawQuery(query, null);
    }

    public void updateData(String row_id, Article article) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, article.getTitle());
        cv.put(COLUMN_SPIELREGEL, article.getSpielregeln());
        cv.put(COLUMN_BENÖTIGTE_KARTEN, article.getBenötigteKarten());
        cv.put(COLUMN_SPIELERANZAHL_MIN, article.getSpieleranzahlMin());
        cv.put(COLUMN_SPIELERANZAHL_MAX, article.getSpieleranzahlMax());
        cv.put(COLUMN_SPIELDAUER_MIN, article.getSpieldauerMin());
        cv.put(COLUMN_SPIELDAUER_MAX, article.getSpieldauerMax());
        cv.put(COLUMN_SCHWIERIGKEITSGRAD, article.getSchwierigkeitsgrad());
        cv.put(COLUMN_CREATOR, "user"); // Wert sollte nie verändert werden, nur bugfixing.

        long result = db.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

        //  Eine Zeile in meiner DB löschen
    public void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

        //  JSON Code zur Datenbank hinzuzufügen.
    public void addJsonDataToDatabase(SQLiteDatabase db) {
        List<Article> articles = new ArrayList<>();
        try {
                // JSON-Daten aus der Ressource laden
            String jsonData = loadJSONFromResource();
            JSONObject jsonObject = new JSONObject(jsonData);
            db.beginTransaction();

            try {
                ContentValues cv = new ContentValues();
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
                    String creator = "creator";

                        // Artikel erstellen und der Liste hinzufügen
                    Article article = new Article(name, spielregeln, benötigteKarten, maxSpieleranzahl, minSpieleranzahl, maxSpieldauer, minSpieldauer, schwierigkeitsgrad, creator);
                    articles.add(article);

                        // Artikel zur Datenbank hinzufügen
                    cv.clear();
                    cv.put(COLUMN_TITLE, name);
                    cv.put(COLUMN_SPIELREGEL, spielregeln);
                    cv.put(COLUMN_BENÖTIGTE_KARTEN, benötigteKarten);
                    cv.put(COLUMN_SPIELERANZAHL_MIN, minSpieleranzahl);
                    cv.put(COLUMN_SPIELERANZAHL_MAX, maxSpieleranzahl);
                    cv.put(COLUMN_SPIELDAUER_MIN, minSpieldauer);
                    cv.put(COLUMN_SPIELDAUER_MAX, maxSpieldauer);
                    cv.put(COLUMN_SCHWIERIGKEITSGRAD, schwierigkeitsgrad);
                    cv.put(COLUMN_CREATOR, creator);

                    db.insert(TABLE_NAME, null, cv);
                }

                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("ArticleCreator", "Fehler: " + e);
        }
    }

    private String loadJSONFromResource() {
        String json = null;
        try {
                // JSON-Datei aus der Ressource lesen
            InputStream is = context.getResources().openRawResource(R.raw.kartenspiele);
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
}