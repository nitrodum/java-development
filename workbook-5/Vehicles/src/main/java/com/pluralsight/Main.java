package com.pluralsight;

public class Main {
    public static void main(String[] args) {
//        Moped slowRide = new Moped("Red", 2, 2, 5);
//        System.out.println(slowRide.getColor());
//        System.out.println(slowRide.getFuelCapacity());

        Shape s1 = new Shape();
        Shape s2 = new Square();
        Shape s3 = new Circle();

        s1.setColor("Red");
        s2.setColor("Blue");
        s3.setColor("Green");
        s1.calculateArea();
        s1.calculateCircumference();
        ((Square) s2).setSide(5);
        s2.calculateArea();
        s2.calculateCircumference();
        ((Circle)s3).setRadius(5);
        s3.calculateArea();
        s3.calculateCircumference();
    }
}