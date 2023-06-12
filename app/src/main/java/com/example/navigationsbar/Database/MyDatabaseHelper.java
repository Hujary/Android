package com.example.navigationsbar.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_library";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "book_title";
    private static final String COLUMN_AUTHOR = "book_author";
    private static final String COLUMN_PAGES = "book_pages";
    private static final String COLUMN_CREATOR = "book_creator";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_AUTHOR + " TEXT, " +
                COLUMN_PAGES + " INTEGER, " +
                COLUMN_CREATOR + " TEXT);";
        db.execSQL(query);

        // Vordefinierte Spiele hinzufügen
        addDefaultGames(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addBook(String title, String author, int pages, String creator) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_PAGES, pages);
        cv.put(COLUMN_CREATOR, creator);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        return db.rawQuery(query, null);
    }

    public void updateData(String row_id, String title, String author, String pages) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_PAGES, pages);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
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
                cv.put(COLUMN_AUTHOR, "Autor 1");
                cv.put(COLUMN_PAGES, 100);
                cv.put(COLUMN_CREATOR, "Entwickler");
                db.insert(TABLE_NAME, null, cv);

                // Spiel 2
                cv.put(COLUMN_TITLE, "Spiel 2");
                cv.put(COLUMN_AUTHOR, "Autor 2");
                cv.put(COLUMN_PAGES, 150);
                cv.put(COLUMN_CREATOR, "Entwickler");
                db.insert(TABLE_NAME, null, cv);

                // Spiel 3
                cv.put(COLUMN_TITLE, "Spiel 3");
                cv.put(COLUMN_AUTHOR, "Autor 3");
                cv.put(COLUMN_PAGES, 200);
                cv.put(COLUMN_CREATOR, "Entwickler");
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