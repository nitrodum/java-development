package com.pluralsight;

public class Employee {
    private final float MAX_REGULAR_HOURS = 40f;
    private final float OVER_TIME_RATE = 1.5f;
    private int employeeId;
    private String name;
    private String department;
    private float payRate;
    private float hoursWorked;

    public Employee(int employeeId, String name, String department, float payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
    }

    public Employee(int employeeId, String name, String department, float payRate, float hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getTotalPay() {
        return payRate*(getRegularHours() + (getOvertimeHours()*OVER_TIME_RATE));
    }

    public float getRegularHours() {
        return Math.min(hoursWorked, MAX_REGULAR_HOURS);
    }

    public float getOvertimeHours() {
        if (hoursWorked > MAX_REGULAR_HOURS) {
            return hoursWorked - MAX_REGULAR_HOURS;
        } else {
            return 0;
        }
    }

}
