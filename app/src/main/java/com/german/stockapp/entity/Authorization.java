package com.german.stockapp.entity;

public class Authorization {

private int id;
private String login;
private String pass;
private int roles_id;
private int operator_id;

private Roles roles;

    public Authorization(int id, String login, String pass, int roles_id, int operator_id, Roles roles) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.roles_id = roles_id;
        this.operator_id = operator_id;
        this.roles = roles;
    }

    public Authorization(int id, String login, String pass, int roles_id, int operator_id) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.roles_id = roles_id;
        this.operator_id = operator_id;
    }

    public Authorization(String login, String pass, int roles_id, int operator_id) {
        this.login = login;
        this.pass = pass;
        this.roles_id = roles_id;
        this.operator_id = operator_id;
    }

    public Authorization(String login, String pass, int roles_id) {
        this.login = login;
        this.pass = pass;
        this.roles_id = roles_id;
    }

    public Authorization(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public int getOperator_id() {
        return operator_id;
    }
}
