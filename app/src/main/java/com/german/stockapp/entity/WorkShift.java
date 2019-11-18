package com.german.stockapp.entity;

public class WorkShift {
    private int id;
    private String shift;

    public WorkShift(int id, String shift) {
        this.id = id;
        this.shift = shift;
    }

    public int getId() {
        return id;
    }

    public String getShift() {
        return shift;
    }
}
