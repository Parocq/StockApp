package com.german.stockapp.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.DateTimeException;

public class Product {

    private int id;
    private String title;
    private String date_of_delivery;  // как задавать дата+время занесения
    private int operator_id;
    private int amount;
    private String implementation_period; // Тут просто дату нужно задавать.
    private int locationId;
    private int weightCategoryId;

    private Location location;
    private WeightCategory weightCategory;
    private Operator operator;

    public Product(int id, String title, String date_of_delivery, int operator_id, int amount, String implementation_period,
                   int locationId, int weightCategoryId, Location location, WeightCategory weightCategory, Operator operator) {
        this.id = id;
        this.title = title;
        this.date_of_delivery = date_of_delivery;
        this.operator_id = operator_id;
        this.amount = amount;
        this.implementation_period = implementation_period;
        this.locationId = locationId;
        this.weightCategoryId = weightCategoryId;
        this.location = location;
        this.weightCategory = weightCategory;
        this.operator = operator;
    }

    public Product(String title, String date_of_delivery, int operator_id, int amount, String implementation_period,
                   int locationId, int weightCategoryId, Location location, WeightCategory weightCategory, Operator operator) {
        this.title = title;
        this.date_of_delivery = date_of_delivery;
        this.operator_id = operator_id;
        this.amount = amount;
        this.implementation_period = implementation_period;
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

    public String getDate_of_delivery() {
        return date_of_delivery;
    }

    public int getOperator_id() {
        return operator_id;
    }

    public int getAmount() {
        return amount;
    }

    public String getImplementation_period() {
        return implementation_period;
    }

    public int getLocationId() {
        return locationId;
    }

    public int getWeightCategoryId() {
        return weightCategoryId;
    }

    public Product(int id, String title, String date_of_delivery, int operator_id, int amount,
                   String implementation_period, int locationId, int weightCategoryId) {
        this.id = id;
        this.title = title;
        this.date_of_delivery = date_of_delivery;
        this.operator_id = operator_id;
        this.amount = amount;
        this.implementation_period = implementation_period;
        this.locationId = locationId;
        this.weightCategoryId = weightCategoryId;
    }



    public Product(String title, String date_of_delivery, int operator_id, int amount,
                   String implementation_period, int locationId, int weightCategoryId) {
        this.title = title;
        this.date_of_delivery = date_of_delivery;
        this.operator_id = operator_id;
        this.amount = amount;
        this.implementation_period = implementation_period;
        this.locationId = locationId;
        this.weightCategoryId = weightCategoryId;
    }

    public Product( String title) {
        this.title = title;
    }


    public Location getLocation() {
        return location;
    }

    public WeightCategory getWeightCategory() {
        return weightCategory;
    }

    public Operator getOperator() {
        return operator;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "title='" + title + '\'' +
//                '}';
//    }
}
