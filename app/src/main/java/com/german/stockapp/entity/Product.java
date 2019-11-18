package com.german.stockapp.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.DateTimeException;

public class Product {

    private int id;
    private String title;
    private Time dateOfDelivery;  // как задавать дата+время занесения
    private int operator_id;
    private int amount;
    private Date implementationPeriod; // Тут просто дату нужно задавать.
    private int locationId;
    private int weightCategoryId;

    private Location location;
    private WeightCategory weightCategory;
    private Operator operator;

    public Product(int id, String title, Time dateOfDelivery, int operator_id, int amount, Date implementationPeriod,
                   int locationId, int weightCategoryId, Location location, WeightCategory weightCategory, Operator operator) {
        this.id = id;
        this.title = title;
        this.dateOfDelivery = dateOfDelivery;
        this.operator_id = operator_id;
        this.amount = amount;
        this.implementationPeriod = implementationPeriod;
        this.locationId = locationId;
        this.weightCategoryId = weightCategoryId;
        this.location = location;   
        this.weightCategory = weightCategory;
        this.operator = operator;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Time getDateOfDelivery() {
        return dateOfDelivery;
    }

    public int getOperator_id() {
        return operator_id;
    }

    public int getAmount() {
        return amount;
    }

    public Date getImplementationPeriod() {
        return implementationPeriod;
    }

    public int getLocationId() {
        return locationId;
    }

    public int getWeightCategoryId() {
        return weightCategoryId;
    }

    public Product(int id, String title, Time dateOfDelivery, int operator_id, int amount,
                   Date implementationPeriod, int locationId, int weightCategoryId) {
        this.id = id;
        this.title = title;
        this.dateOfDelivery = dateOfDelivery;
        this.operator_id = operator_id;
        this.amount = amount;
        this.implementationPeriod = implementationPeriod;
        this.locationId = locationId;
        this.weightCategoryId = weightCategoryId;


    }
}
