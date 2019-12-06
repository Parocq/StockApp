package com.german.stockapp.entity;

public class Operator {

    private int id;
    private String operatorName;
    private int workDaysId;
    private int workShiftId;

    private WorkShift workShift;
    private WorkDays workDays;
    private Authorization authorization;

    public Operator(int id, String operatorName, WorkShift workShift, WorkDays workDays, Authorization authorization) {
        this.id = id;
        this.operatorName = operatorName;
        this.workShift = workShift;
        this.workDays = workDays;
        this.authorization = authorization;
    }

    public Operator(int id, String operatorName, int workDaysId, int workShiftId) {
        this.id = id;
        this.operatorName = operatorName;
        this.workDaysId = workDaysId;
        this.workShiftId = workShiftId;
    }

    public  Operator(String operatorName, int workDaysId, int workShiftId) {
        this.operatorName = operatorName;
        this.workDaysId = workDaysId;
        this.workShiftId = workShiftId;
    }

    public  Operator(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getId() {
        return id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public int getWorkDaysId() {
        return workDaysId;
    }

    public int getWorkShiftId() {
        return workShiftId;
    }

    public WorkDays getWorkDays() {
        return workDays;
    }

    public WorkShift getWorkShift() {
        return workShift;
    }

    public Authorization getAuthorization() {
        return authorization;
    }
}
