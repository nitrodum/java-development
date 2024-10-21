package com.pluralsight;

public class Employee {
    int employeeId;
    String name;
    String department;
    float payRate;
    float hoursWorked;

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
        return payRate*(getRegularHours() + (getOvertimeHours()*1.5f));
    }

    public float getRegularHours() {
        if (hoursWorked >= 40) {
            return 40f;
        } else {
            return hoursWorked;
        }
    }

    public float getOvertimeHours() {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        } else {
            return 0;
        }
    }

}
