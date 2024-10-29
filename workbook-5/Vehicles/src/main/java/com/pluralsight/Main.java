package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Moped slowRide = new Moped("Red", 2, 2, 5);
        System.out.println(slowRide.getColor());
        System.out.println(slowRide.getFuelCapacity());
    }
}