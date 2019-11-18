package com.german.stockapp.entity;

public class Roles {

    private int id;
    private String roleName;

    public Roles(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }
}
