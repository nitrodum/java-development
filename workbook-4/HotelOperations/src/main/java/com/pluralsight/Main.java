package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(2, 139);
        System.out.println(room1.isAvailable());

        Room room2 = new Room(1, 123);
        room2.setOccupied(true);

        System.out.println(room2.isAvailable());


    }
}