package com.pluralsight;

import java.util.Scanner;

public class BasicCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int x = getNumber();
        int y = getNumber();
        doOperation(x, y);
        scanner.close();

    }
    public BasicCalculator(){
    }

    public static int getNumber() {
        boolean validInput = false;
        int number = 0;
        do {
            System.out.println("Enter a number: ");
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Not a valid number, please enter another number:");
                scanner.next();
            }
        } while (!validInput);
        return number;
    }

    public static void doOperation(int x, int y) {
        boolean validInput = false;
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
    }
}
