package com.example.navigationsbar.Artikel;

public class Article {
    private String title;
    private String spielregel;
    private String benötigteKarten;
    private int spieleranzahlMin;
    private int spieleranzahlMax;
    private int spieldauerMin;
    private int spieldauerMax;
    private String schwierigkeitsgrad;

    public Article(String title, String spielregel, String benötigteKarten, int spieleranzahlMax, int spieleranzahlMin, int spieldauerMax, int spieldauerMin, String schwierigkeitsgrad) {
        this.title = title;
        this.spielregel = spielregel;
        this.benötigteKarten = benötigteKarten;
        this.spieleranzahlMin = spieleranzahlMin;
        this.spieleranzahlMax = spieleranzahlMax;
        this.spieldauerMin = spieldauerMin;
        this.spieldauerMax = spieldauerMax;
        this.schwierigkeitsgrad = schwierigkeitsgrad;
    }

    public String getTitle() {
        return title;
    }

    public String getSpielregel() {
        return spielregel;
    }

    public String getBenötigtekarten() {
        return benötigteKarten;
    }

    public int getSpieleranzahlMin() {
        return spieleranzahlMin;
    }

    public int getSpieleranzahlMax() {
        return spieleranzahlMax;
    }

    public int getSpieldauerMin() {
        return spieldauerMin;
    }

    public int getSpieldauerMax() {
        return spieldauerMax;
    }

    public String getSchwierigkeitsgrad() {
        return schwierigkeitsgrad;
    }
}