package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hi! Welcome to Sandwich Shop!\n" +
                "Please select the size of the sandwich:\n" +
                "Type 1 for a regular sized sandwich or 2 for a large sandwich."
                );
        String size = scanner.nextLine();
        System.out.println("Would you like to have the sandwich loaded?\n" +
                "Please respond yes or no: ");
        String loaded = scanner.nextLine();
        float price = 0.0f;
        if (size.equals("1")) {
            price = 5.45f;
            if (loaded.equals("yes")){
                price += 1f;
            }
        } else if (size.equals("2")) {
            price = 8.95f;
            if (loaded.equals("yes")){
                price += 1.75f;
            }
        }

        System.out.println("What is your age?");
        int age = scanner.nextInt();


        if (age <= 17) {
            price *= .9f;
        } else if (age >= 65) {
            price *= .8f;
        }

        System.out.printf("Your total cost is: $%.2f", price);
        scanner.close();
    }
}
