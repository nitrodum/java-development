package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[20];
        int count = 0;

        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        count+=6;

        boolean running = true;

        do {
            System.out.println("What do you want to do?\n" +
                    "1 - List all vehicles\n" +
                    "2 - Search by make/model\n" +
                    "3 - Search by price range\n" +
                    "4 - Search by color\n" +
                    "5 - Add a vehicle\n" +
                    "6 - Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listall();
                    break;
                case 2:
                    searchMake();
                    break;
                case 3:
                    searchPrice();
                    break;
                case 4:
                    searchColor();
                    break;
                case 5:
                    addVehicle();
                    break;
                case 6:
                    running = false;
                    break;
            }

        } while (running);
    }
}
