package com.german.stockapp.entity;

public class WorkDays {

    private int id;
    private String days;

    public WorkDays(int id, String days) {
        this.id = id;
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public String getDays() {  return days;  }
}
