package com.example.navigationsbar.Items.Article;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.Log;

import com.example.navigationsbar.Database.MyDatabaseHelper;
import com.example.navigationsbar.R;

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

            // Datenbank-Artikel zur Liste hinzufügen
        articles.addAll(databaseArticles);

        return articles;
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
                String creator = cursor.getString(9);;

                Article article = new Article(id, title, spielregel, benötigteKarten, spieleranzahlMin, spieleranzahlMax, spieldauerMin, spieldauerMax, schwierigkeitsgrad, creator);
                databaseArticles.add(article);
            }
        }
        return databaseArticles;
    }
}