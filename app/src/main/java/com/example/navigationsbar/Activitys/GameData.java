package com.example.navigationsbar.Activitys;

import java.util.List;

public class GameData {
    private static GameData instance;
    private int numberOfPlayers;
    private String haveCards;
    private String fehlenKarten;
    private String schwierigkeit;
    private List<Integer> selectedHerzCards;
    private List<Integer> selectedKaroCards;
    private List<Integer> selectedPikCards;
    private List<Integer> selectedKreuzCards;



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


        //  Getter und Setter für selectedHerzCards
    public List<Integer> getSelectedHerzCards() { return selectedHerzCards; }
    public void setSelectedHerzCards(List<Integer> selectedHerzCards) { this.selectedHerzCards = selectedHerzCards; }


        //  Getter und Setter für selectedPikCards
    public List<Integer> getSelectedPikCards() { return selectedPikCards; }
    public void setSelectedPikCards(List<Integer> selectedPikCards) { this.selectedPikCards = selectedPikCards; }


        //  Getter und Setter für selectedKreuzCards
    public List<Integer> getSelectedKreuzCards() { return selectedKreuzCards; }
    public void setSelectedKreuzCards(List<Integer> selectedKreuzCards) { this.selectedKreuzCards = selectedKreuzCards; }


        //  Getter und Setter für selectedKaroCards
    public List<Integer> getSelectedKaroCards() { return selectedKaroCards; }
    public void setSelectedKaroCards(List<Integer> selectedKaroCards) { this.selectedKaroCards = selectedKaroCards; }


}