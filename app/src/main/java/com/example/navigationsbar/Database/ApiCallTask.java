package com.example.navigationsbar.Database;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiCallTask extends AsyncTask<Void, Void, String> {
    private static final String TAG = "ApiCallTask";

    private String apiUrl;
    private double a;
    private double b;
    private double c;

    public ApiCallTask(String apiUrl, double a, double b, double c) {
        this.apiUrl = apiUrl;
        this.a = a;
        this.b = b;
        this.c = c;
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
            requestBody.put("a", a);
            requestBody.put("b", b);
            requestBody.put("c", c);

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
        Log.d(TAG, "API response: " + result);
    }
}