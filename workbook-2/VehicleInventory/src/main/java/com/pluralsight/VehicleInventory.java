package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {
    static Vehicle[] vehicles = new Vehicle[20];
    static int count = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
                    "6 - Quit\n\n" +
                    "Enter your command:");

            int choice = scanner.nextInt();
            scanner.nextLine();

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
        scanner.close();
    }

    static void listall() {
        for (Vehicle car : vehicles) {
            display(car);
        }
    }

    static void display(Vehicle car) {
        System.out.println("Vehicle ID: " + car.getVehicleId() + " Make Model: " + car.getMakeModel() + " Color: " + car.getColor() + " Odometer Reading: " + car.getOdometerReading() + " Price: " + car.getPrice());
    }

    static void searchMake() {
        System.out.println("Enter a Make and Model to search");
        String input = scanner.nextLine();
    }

    static void searchPrice() {
        System.out.println("Enter a price range to search");
        String input = scanner.nextLine();
    }

    static void searchColor() {
        System.out.println("Enter a color to search");
        String input = scanner.nextLine();
    }

    static void addVehicle() {
        System.out.println("Enter the details of the car to add:" +
                "Vehicle ID: ");
        int vehicleId = scanner.nextInt();
        scanner.nextLine();
        String makeModel = input("Make and Model: ");
        String color = input("Color: ");
        System.out.println("Odometer Reading: ");
        int odometerReading = scanner.nextInt();
        System.out.println("Price: ");
        float price = scanner.nextFloat();
        Vehicle car = new Vehicle(vehicleId, makeModel, color, odometerReading, price);
        vehicles[count++] = car;
    }

    static String input(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
