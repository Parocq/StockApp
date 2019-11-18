package com.german.stockapp.entity;

public class Operator {

    private int id;
    private String operatorName;
    private int workDaysId;
    private int workShiftId;

    private WorkShift workShift;

    public Operator(int id, String operatorName, int workDaysId, int workShiftId) {
        this.id = id;
        this.operatorName = operatorName;
        this.workDaysId = workDaysId;
        this.workShiftId = workShiftId;
    }

    public Operator(int id, String operatorName, int workDaysId, int workShiftId, WorkShift workShift) {
        this.id = id;
        this.operatorName = operatorName;
        this.workDaysId = workDaysId;
        this.workShiftId = workShiftId;
        this.workShift = workShift;
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
}
