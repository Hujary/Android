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
                COLUMN_SCHWIERIGKEITSGRAD + " TEXT);";
        db.execSQL(query);

        // Vordefinierte Spiele hinzufügen
        addDefaultGames(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addArticle(String title, String spielregel, String benötigteKarten, int spieleranzahlMin, int spieleranzahlMax, int spieldauerMin, int spieldauerMax, String schwierigkeitsgrad) {
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

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Log.d("MyDatabaseHelper", "Error inserting data");
        } else {
            Log.d("MyDatabaseHelper", "Data inserted successfully");
        }
    }

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

        long result = db.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

    private void addDefaultGames(SQLiteDatabase db) {
        // Überprüfen, ob die Tabelle bereits Einträge enthält
        String countQuery = "SELECT count(*) FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.moveToFirst();
        int rowCount = cursor.getInt(0);
        cursor.close();

        // Vordefinierte Spiele hinzufügen, falls die Tabelle noch leer ist
        if (rowCount == 0) {
            db.beginTransaction();
            try {
                ContentValues cv = new ContentValues();

                // Spiel 1
                cv.put(COLUMN_TITLE, "Spiel 1");
                cv.put(COLUMN_SPIELREGEL, "Spielregel 1");
                cv.put(COLUMN_BENÖTIGTE_KARTEN, "Karten 1");
                cv.put(COLUMN_SPIELERANZAHL_MIN, 2);
                cv.put(COLUMN_SPIELERANZAHL_MAX, 4);
                cv.put(COLUMN_SPIELDAUER_MIN, 30);
                cv.put(COLUMN_SPIELDAUER_MAX, 60);
                cv.put(COLUMN_SCHWIERIGKEITSGRAD, "Einfach");
                db.insert(TABLE_NAME, null, cv);

                // Spiel 2
                cv.put(COLUMN_TITLE, "Spiel 2");
                cv.put(COLUMN_SPIELREGEL, "Spielregel 2");
                cv.put(COLUMN_BENÖTIGTE_KARTEN, "Karten 2");
                cv.put(COLUMN_SPIELERANZAHL_MIN, 2);
                cv.put(COLUMN_SPIELERANZAHL_MAX, 6);
                cv.put(COLUMN_SPIELDAUER_MIN, 45);
                cv.put(COLUMN_SPIELDAUER_MAX, 90);
                cv.put(COLUMN_SCHWIERIGKEITSGRAD, "Mittel");
                db.insert(TABLE_NAME, null, cv);

                // Spiel 3
                cv.put(COLUMN_TITLE, "Spiel 3");
                cv.put(COLUMN_SPIELREGEL, "Spielregel 3");
                cv.put(COLUMN_BENÖTIGTE_KARTEN, "Karten 3");
                cv.put(COLUMN_SPIELERANZAHL_MIN, 3);
                cv.put(COLUMN_SPIELERANZAHL_MAX, 8);
                cv.put(COLUMN_SPIELDAUER_MIN, 60);
                cv.put(COLUMN_SPIELDAUER_MAX, 120);
                cv.put(COLUMN_SCHWIERIGKEITSGRAD, "Schwer");
                db.insert(TABLE_NAME, null, cv);

                db.setTransactionSuccessful();
                Toast.makeText(context, "Default games added successfully!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(context, "Failed to add default games.", Toast.LENGTH_SHORT).show();
            } finally {
                db.endTransaction();
            }
        }
    }
}