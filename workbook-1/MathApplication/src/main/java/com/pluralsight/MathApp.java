package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {
        //Question 1:
        float bobSalary = 12.00f;
        float garySalary = 15.00f;

        float highestSalary = Math.max(bobSalary, garySalary);

        System.out.println("The highest salary is " + highestSalary);

        //Question 2:
        float carPrice = 1000.00f;
        float truckPrice = 1400.00f;

        System.out.println("The minimum price is " + Math.min(carPrice, truckPrice));

        //Question 3:
        float pi = 3.14f;
        float r = 7.25f;
        float area = pi*(r*r);

        System.out.println("The area is " + area);

        //Question 4:
        float a = 5.0f;
        System.out.println("The square root is " + Math.sqrt(a));

        //Question 5:
        double x1 = 5;
        double y1 = 10;
        double x2 = 85;
        double y2 = 50;

        double dx = x2-x1;
        double dy = y2-y1;

        double dist = Math.sqrt((dx*dx) + (dy*dy));

        System.out.println("The distance between the points is " + dist);

        //Question 6:
        float neg = -3.8f;
        System.out.println("The absolute value is " + Math.abs(neg));

        //Question 7:
        System.out.println("The random number is " + Math.random());
    }
}
