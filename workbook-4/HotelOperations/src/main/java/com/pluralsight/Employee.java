package com.pluralsight;

import java.time.LocalTime;

public class Employee {
    private final float MAX_REGULAR_HOURS = 40f;
    private final float OVERTIMERATE = 1.5f;
    private int employeeId;
    private String name;
    private String department;
    private float payRate;
    private float hoursWorked;
    private double startTime;
    private LocalTime startLocalTime;

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

    public double getStartTime() {
        return this.startTime;
    }

    public void punchIn(double time) {
        this.startTime = time;
    }

    public void punchIn() {
        this.startLocalTime = LocalTime.now();
    }

    public void punchOut(double time) {
        this.hoursWorked += (float) (time - this.startTime);
    }

    public void punchOut() {
        int hours = LocalTime.now().getHour() - this.startLocalTime.getHour();
        int minutes = LocalTime.now().getMinute() - this.startLocalTime.getMinute();
        this.hoursWorked += hours + (float)(minutes/60);
    }

    public void punchTimeCard(double startTime, double endTime) {
        hoursWorked += (float) (endTime - startTime);
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getTotalPay() {
        return payRate * (getRegularHours() + (getOvertimeHours() * OVERTIMERATE));
    }

    public float getRegularHours() {
        return Math.min(hoursWorked, MAX_REGULAR_HOURS);
    }

    public float getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

}
