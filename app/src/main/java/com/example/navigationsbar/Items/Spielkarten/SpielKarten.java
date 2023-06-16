package com.example.navigationsbar.Items.Spielkarten;

public class SpielKarten {

    private int image;
    private String name;

    public SpielKarten(int image, String name){
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}