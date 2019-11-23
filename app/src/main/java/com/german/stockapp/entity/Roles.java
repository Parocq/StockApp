package com.german.stockapp.entity;

public class Roles {

    private int id;
    private String role_name;

    public Roles(int id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public int getId() {
        return id;
    }

    public String getRole_name() {
        return role_name;
    }
}
