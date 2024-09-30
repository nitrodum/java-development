package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        float price = 29.99f;
        float optionsCost = 0f;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, welcome to Car Company!\n" +
                "Please enter the date you would like to pick up the car!");
        String date = scanner.nextLine();
        System.out.println("Please enter the number of days.");
        int daysOfRental = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Would you like to add an electronic toll tag for an additional $3.95 a day? (Y/N)");
        String hasElectronicTag = scanner.nextLine().toUpperCase();
        System.out.println("Would you like to add a GPS for an additional $2.95 a day? (Y/N)");
        String hasGPS = scanner.nextLine().toUpperCase();
        System.out.println("Would you like to add roadside assistance for an additional $3.95 a day? (Y/N)");
        String hasRoadside = scanner.nextLine().toUpperCase();
        System.out.println("What is your current age?");
        int age = scanner.nextInt();
        scanner.close();

        System.out.println("The base price for the car rental is $29.99 per day.");

        if(hasElectronicTag.equals("Y")) {
            System.out.println("You got an electronic toll tag for an additional $3.95 a day.");
            optionsCost += 3.95f;
        }
        if(hasGPS.equals("Y")) {
            System.out.println("You got a GPS for an additional $2.95 a day.");
            optionsCost += 3.95f;
        }
        if(hasRoadside.equals("Y")) {
            System.out.println("You got roadside assistance for an additional $3.95 a day.");
            optionsCost += 3.95f;
        }

        if (age < 25) {
            System.out.println("Because you are under 25 we apply a 30% surcharge to the base car rate.");
            price *= 1.3f;
        }

        price = (price + optionsCost) * daysOfRental;

        System.out.printf("For your car rental starting on %s your total cost is $%.2f", date, price);

    }
}
