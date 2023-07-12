package com.example.navigationsbar.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Treiber laden
            Class.forName("org.sqlite.JDBC");

            // Verbindung zur Datenbank herstellen
            String url = "jdbc:sqlite:/path/to/database.db"; // Pfad zur SQLite-Datenbankdatei
            connection = DriverManager.getConnection(url);

            // Verbindung erfolgreich, SQL-Abfrage ausführen
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM table_name";
            ResultSet resultSet = statement.executeQuery(query);

            // Ergebnisse verarbeiten
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
            }

            // Ressourcen freigeben
            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Verbindung schließen, wenn Sie nicht mehr benötigt wird
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}