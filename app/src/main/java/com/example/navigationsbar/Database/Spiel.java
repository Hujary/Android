package com.example.navigationsbar.Database;

public class Spiel {
    private int id;
    private String name;
    private String spielregeln;
    private int spieleranzahl;
    private String kartensets;

    public Spiel(int id, String name, String spielregeln, int spieleranzahl, String kartensets) {
        this.id = id;
        this.name = name;
        this.spielregeln = spielregeln;
        this.spieleranzahl = spieleranzahl;
        this.kartensets = kartensets;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpielregeln() {
        return spielregeln;
    }

    public int getSpieleranzahl() {
        return spieleranzahl;
    }

    public String getKartensets() {
        return kartensets;
    }
}
