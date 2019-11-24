package com.german.stockapp.entity;

public class WeightCategory {

    private int id;
    private String title;
    private double max_weight;
    private double min_weight;

    public WeightCategory(int id, String title, double max_weight, double min_weight) {
        this.id = id;
        this.title = title;
        this.max_weight = max_weight;
        this.min_weight = min_weight;
    }

    public WeightCategory(String title, double max_weight, double min_weight) {
        this.title = title;
        this.max_weight = max_weight;
        this.min_weight = min_weight;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getMax_weight() {
        return max_weight;
    }

    public double getMin_weight() {
        return min_weight;
    }
}
