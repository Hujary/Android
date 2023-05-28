package com.example.navigationsbar.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SpieleDatenbank extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "spiele.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_SPIELE = "spiele";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SPIELREGELN = "spielregeln";
    private static final String COLUMN_SPIELERANZAHL = "spieleranzahl";
    private static final String COLUMN_KARTENSETS = "kartensets";

    public SpieleDatenbank(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_SPIELE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SPIELREGELN + " TEXT, " +
                COLUMN_SPIELERANZAHL + " INTEGER, " +
                COLUMN_KARTENSETS + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPIELE);
        onCreate(db);
    }

    public void addSpiel(String name, String spielregeln, int spieleranzahl, String kartensets) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SPIELREGELN, spielregeln);
        values.put(COLUMN_SPIELERANZAHL, spieleranzahl);
        values.put(COLUMN_KARTENSETS, kartensets);
        db.insert(TABLE_SPIELE, null, values);
        db.close();
    }

    public List<Spiel> getSpiele() {
        List<Spiel> spieleList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SPIELE, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String spielregeln = cursor.getString(cursor.getColumnIndex(COLUMN_SPIELREGELN));
                int spieleranzahl = cursor.getInt(cursor.getColumnIndex(COLUMN_SPIELERANZAHL));
                String kartensets = cursor.getString(cursor.getColumnIndex(COLUMN_KARTENSETS));

                Spiel spiel = new Spiel(id, name, spielregeln, spieleranzahl, kartensets);
                spieleList.add(spiel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return spieleList;
    }
}