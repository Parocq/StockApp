package com.german.stockapp.entity;

public class Location {

    private int id;
    private int line;
    private int rack;
    private int shelf;

    public Location(int id, int line, int rack, int shelf) {
        this.id = id;
        this.line = line;
        this.rack = rack;
        this.shelf = shelf;
    }

    public int getId() {
        return id;
    }

    public int getLine() {
        return line;
    }

    public int getRack() {
        return rack;
    }

    public int getShelf() {
        return shelf;
    }
}
