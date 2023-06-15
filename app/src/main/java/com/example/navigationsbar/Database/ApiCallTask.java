package com.example.navigationsbar.Database;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCallTask extends AsyncTask<Void, Void, String> {
    private static final String TAG = "ApiCallTask";

    private String apiUrl;
    private String name;
    private String rules;
    private int playerNumberMin;
    private int playerNumberMax;
    private String cards;
    private int playtimeMin;
    private int playtimeMax;
    private String difficulty;
    private ApiCallTaskCallback callback;

    public ApiCallTask(String apiUrl, String name, String rules, int playerNumberMin, int playerNumberMax, String cards, int playtimeMin, int playtimeMax, String difficulty, ApiCallTaskCallback callback) {
        this.apiUrl = apiUrl;
        this.name = name;
        this.rules = rules;
        this.playerNumberMin = playerNumberMin;
        this.playerNumberMax = playerNumberMax;
        this.cards = cards;
        this.playtimeMin = playtimeMin;
        this.playtimeMax = playtimeMax;
        this.difficulty = difficulty;
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String result = "";

        try {
            // Aufbau der API-URL
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Erstellen des Request-Body als JSON
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", name);
            requestBody.put("rules", rules);
            requestBody.put("playernumber_min", playerNumberMin);
            requestBody.put("playernumber_max", playerNumberMax);
            requestBody.put("cards", cards);
            requestBody.put("playtime_min", playtimeMin);
            requestBody.put("playtime_max", playtimeMax);
            requestBody.put("difficulty", difficulty);

            // Senden des Request-Body an die API
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(requestBody.toString());
            writer.flush();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                reader.close();
            } else {
                Log.e(TAG, "API request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception occurred during API call: " + e.getMessage());
        }

        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        // Der API-Aufruf ist abgeschlossen, und das Ergebnis kann hier verarbeitet werden
        if (callback != null) {
            callback.onApiCallComplete(result);
        }
    }

    // Schnittstelle für die Callback-Methode
    interface ApiCallTaskCallback {
        void onApiCallComplete(String result);
    }
}