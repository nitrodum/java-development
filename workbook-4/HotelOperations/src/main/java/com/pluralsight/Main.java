package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(2, 139);
        System.out.println(room1.isAvailable());

        Room room2 = new Room(1, 123);
        room2.setOccupied(true);

        System.out.println(room2.isAvailable());

        Reservation res1 = new Reservation("King", 2, false);
        System.out.println(res1.getReservationTotal());

        Employee emp1 = new Employee(1, "John", "Clerk", 25);
        emp1.punchTimeCard(10, 12);
        System.out.println(emp1.getTotalPay());

    }
}