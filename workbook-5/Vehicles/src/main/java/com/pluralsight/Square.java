package com.pluralsight;

public class Square extends Shape {
    private double side;

    @Override
    public void calculateArea() {
        double area = this.side*this.side;
        System.out.println(area);
    }

    @Override
    public void calculateCircumference() {
        double circumference = 4*this.side;
        System.out.println(circumference);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
