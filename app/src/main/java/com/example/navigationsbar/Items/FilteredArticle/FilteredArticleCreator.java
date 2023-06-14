package com.example.navigationsbar.Items.FilteredArticle;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.navigationsbar.Database.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class FilteredArticleCreator {
    private MyDatabaseHelper myDB;

    public FilteredArticleCreator(Context context) {
        myDB = new MyDatabaseHelper(context);
    }

    public List<filteredArticle> getFilteredArticle(int playerNumber, String difficulty, Boolean missingCards, Boolean haveCards) {

          //  Standart Values zuweisen
        if (difficulty == null) {
            difficulty = "egal";
        }
        if (missingCards == null) {
            missingCards = false;
        }

            // Convert variables to strings
        String playerNumberString = String.valueOf(playerNumber);
        Log.d("YourTag", "Player Number: " + playerNumberString +
                ", Difficulty: " + difficulty +
                ", Missing Cards: " + missingCards +
                ", Have Cards: " + haveCards);

            //  Datenbank abfrage Methode aufrufen.
        List<filteredArticle> articles = readDatabaseDataWithValues(playerNumberString, difficulty);
        return articles;
    }

        // Datenbankabruf mit gefilterten Daten
    private List<filteredArticle> readDatabaseDataWithValues(String playerNumber, String difficulty) {
        List<filteredArticle> databaseArticles = new ArrayList<>();
        Cursor cursor = myDB.readFilteredData(playerNumber, difficulty);

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
                String creator = cursor.getString(9);
                filteredArticle article = new filteredArticle(id, title, spielregel, benötigteKarten, spieleranzahlMin, spieleranzahlMax, spieldauerMin, spieldauerMax, schwierigkeitsgrad, creator);
                databaseArticles.add(article);
            }
        }
        cursor.close();
        return databaseArticles;
    }
}