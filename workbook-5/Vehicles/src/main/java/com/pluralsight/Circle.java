package com.pluralsight;

public class Circle extends Shape {
    private double radius;

    @Override
    public void calculateArea() {
        double area = Math.PI*this.radius*this.radius;
        System.out.println(area);
    }

    @Override
    public void calculateCircumference() {
        double circumference = 2*Math.PI*this.radius;;
        System.out.println(circumference);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
