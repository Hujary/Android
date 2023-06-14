package com.example.navigationsbar.Items.FilteredArticle;

public class filteredArticle {
    private String id, title, spielregel, benötigteKarten, schwierigkeitsgrad, creator;
    private int spieleranzahlMin, spieleranzahlMax, spieldauerMin, spieldauerMax;

    public filteredArticle(String id, String title, String spielregel, String benötigteKarten, int spieleranzahlMin, int spieleranzahlMax, int spieldauerMin, int spieldauerMax, String schwierigkeitsgrad, String creator) {
        this.id = id;
        this.title = title;
        this.spielregel = spielregel;
        this.benötigteKarten = benötigteKarten;
        this.spieleranzahlMin = spieleranzahlMin;
        this.spieleranzahlMax = spieleranzahlMax;
        this.spieldauerMin = spieldauerMin;
        this.spieldauerMax = spieldauerMax;
        this.schwierigkeitsgrad = schwierigkeitsgrad;
        this.creator = creator;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getSpielregeln() {
        return spielregel;
    }
    public String getBenötigteKarten() {
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
    public String getCreator() {
        return creator;
    }

}
