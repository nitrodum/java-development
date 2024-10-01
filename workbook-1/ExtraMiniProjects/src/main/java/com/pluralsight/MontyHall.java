package com.pluralsight;

import java.util.Scanner;

public class MontyHall {
    static Scanner scanner = new Scanner(System.in);
    static Integer[] doors = new Integer[3];
    static int prize = (int) (Math.random() * 3) + 1;
    static int simulatedRuns = 1000;

    public static void main(String[] args) {
        //runForPlayer();
        System.out.println("Simulating Always Swap");
        runSim(true);
        System.out.println("Simulating Never Swap");
        runSim(false);
    }



    static void populateDoors() {
        for (int i = 0; i < doors.length; i++) {
            doors[i] = i + 1;
        }
    }

    static void printDoors() {
        for (int number : doors) {
            if (number != 0) {
                System.out.print("[" + number + "]");
            } else {
                System.out.print("[X]");
            }
        }
        System.out.println();
    }

    static int removeDoor(int choice) {
        int indexToRemove;
        if (choice != prize) {
            indexToRemove = 6 - choice - prize - 1;
        } else {
            int addOrSub = Math.random() < 0.5 ? -1 : 1;
            indexToRemove = (choice - 1 + addOrSub) % 3;
            if (indexToRemove == -1) {
                indexToRemove = 2;
            }
        }
        doors[indexToRemove] = 0;
        return indexToRemove + 1;
    }

    static void showResults(int choice) {
        if (choice == prize) {
            System.out.println("Congrats you won the big prize!");
        } else {
            System.out.println("Sorry, better luck next time.");
        }
    }

    static void runForPlayer() {
        populateDoors();
        System.out.println("Welcome to the Monty Hall Game!\n" +
                "One of these three doors contains a big prize while the other two contain nothing.\n" +
                "Enter the number of the door you want to choose.");
        printDoors();
        // For Debug
        //System.out.println("Winning door is: " + prize);
        int choice = scanner.nextInt();
        scanner.nextLine();
        int removedDoor = removeDoor(choice);
        int otherDoor = 6 - choice - removedDoor;
        System.out.println("I will now open door number " + removedDoor + " and show that it did not contain the prize.");
        printDoors();
        System.out.println("Would you like to switch to door " + otherDoor + " (y/n)");

        String willSwitch = scanner.nextLine().toUpperCase();
        if (willSwitch.equals("Y")) {
            showResults(otherDoor);
        } else {
            showResults(choice);
        }

        scanner.close();
    }

    static int simulate(boolean willSwap) {
        populateDoors();
        int choice = (int) (Math.random() * 3) + 1;
        int removedDoor = removeDoor(choice);
        int otherDoor = 6 - choice - removedDoor;

        if (willSwap) {
            choice = otherDoor;
        }

        if (choice == prize) {
            return 1;
        }
        return 0;
    }

    static void runSim(boolean willSwap) {
        int count = 0;

        for (int i = 0; i < simulatedRuns; i++) {
            count += simulate(willSwap);
            prize = (int) (Math.random() * 3) + 1;
        }
        float percentage = ((float) count /simulatedRuns)*100f;
        System.out.println("Win rate: " + (percentage) + "%");
    }
}
