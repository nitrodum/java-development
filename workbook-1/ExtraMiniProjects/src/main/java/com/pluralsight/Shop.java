package com.pluralsight;

import java.util.Map;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        float price = 0f;
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> items = Map.of("CHEESE", 8, "BREAD", 2, "COFFEE", 4, "WINE", 3);
        System.out.println("Welcome to our shop!\n" +
                "Please choose an item:\n" +
                "Cheese: $8.00\n" +
                "Bread: $2.00\n" +
                "Coffee: $4.00\n" +
                "Wine: $3.00");

        String item = scanner.nextLine().toUpperCase();

        System.out.println("Please choose an amount.");
        int amount = scanner.nextInt();

        price = items.get(item) * amount;
        System.out.printf("Your total is $%.2f", price);
        scanner.close();
    }
}
