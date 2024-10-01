package com.pluralsight;

import java.util.Scanner;

public class MontyHall {
    static Scanner scanner = new Scanner(System.in);
    static Integer[] doors = new Integer[3];
    public static void main(String[] args) {
        int prize = (int)(Math.random()*3);
        populateDoors();
        System.out.println("Welcome to the Monty Hall Game!\n" +
                "One of these three doors contains a big prize while the other two contain nothing.\n" +
                "Enter the number of the door you want to choose.");
        printDoors();

        int choice = scanner.nextInt();

    }

    static void populateDoors() {
        for (int i = 0; i < doors.length; i++) {
            doors[i] = i+1;
        }
    }

    static void printDoors() {
        for (int i = 0; i < doors.length; i++) {
            System.out.print("[" + doors[i] + "]");
        }
        System.out.println();
    }
}
