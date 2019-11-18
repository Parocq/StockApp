package com.german.stockapp.entity;

public class WeightCategory {

    private int id;
    private String title;
    private double maxWeight;
    private double minWeight;

    public WeightCategory(int id, String title, double maxWeight, double minWeight) {
        this.id = id;
        this.title = title;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getMinWeight() {
        return minWeight;
    }
}
