package com.pluralsight;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        boolean validInput = false;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the first number: ");
            if (scanner.hasNextInt()){
                x = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Not a valid number, please enter another number:");
                scanner.next();
            }
        } while (!validInput);
        validInput = false;

        do {
            System.out.println("Enter the second number: ");
            if (scanner.hasNextInt()){
                y = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Not a valid number, please enter another number:");
                scanner.next();
            }
        } while (!validInput);
        scanner.nextLine();
        validInput = false;
        String input;
        do {
            System.out.println("Possible calculations:\n" +
                    "(A)dd\n" +
                    "(S)ubtract\n" +
                    "(M)ultiply\n" +
                    "(D)ivide\n" +
                    "Please select an option:");

            input = scanner.next();

            switch (input) {
                case ("A"):
                case ("a"):
                    System.out.println(x + " + " + y + " = " + (x + y));
                    validInput = true;
                    break;
                case ("S"):
                case ("s"):
                    System.out.println(x + " - " + y + " = " + (x - y));
                    validInput = true;
                    break;
                case ("M"):
                case ("m"):
                    System.out.println(x + " * " + y + " = " + (x * y));
                    validInput = true;
                    break;
                case ("D"):
                case ("d"):
                    System.out.println(x + " / " + y + " = " + (x / y));
                    validInput = true;
                    break;
            }
            scanner.nextLine();
        } while (!validInput);
        scanner.close();
    }
}
