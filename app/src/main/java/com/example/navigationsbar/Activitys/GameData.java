package com.example.navigationsbar.Activitys;

import java.util.List;

public class GameData {
    private static GameData instance;
    private int numberOfPlayers;
    private String haveCards;
    private String fehlenKarten;
    private String schwierigkeit;
    private List<String> selectedCards;

    private GameData() {
        // Private Konstruktor, um direkte Instanziierung zu verhindern
    }

        // Singelton Logik
    public static GameData getInstance() {
        if (instance == null) {
            instance = new GameData();
        }
        return instance;
    }

        //  Getter & Setter für Spieleranzahl
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }


        //  Getter & Setter für Frage ob man Karten hat
    public String getHaveCards() {
        return haveCards;
    }
    public void setHaveCards(String haveCards) {
        this.haveCards = haveCards;
    }


        //  Getter & Setter für Frage ob Karten Fehlen
    public String getFehlenKarten() {
        return fehlenKarten;
    }
    public void setFehlenKarten(String fehlenKarten) {
        this.fehlenKarten = fehlenKarten;
    }


        //  Getter & Setter für Schwierigkeit
    public String getSchwierigkeit() {
        return schwierigkeit;
    }
    public void setSchwierigkeit(String schwierigkeit) {
        this.schwierigkeit = schwierigkeit;
    }


        //  Getter und Setter für selectedCards
    public List<String> getSelectedCards() { return selectedCards; }
    public void setSelectedCards(List<String> selectedCards) { this.selectedCards = selectedCards; }

}