package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchInventoryMap {
    private static Map<Integer, Product> inventory = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;

    public static void main(String[] args) {
        loadInventory();

        while (running) {
            menu();
        }
        scanner.close();
    }

    static void menu() {
        System.out.println("What item # are you interested in? ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product matchedProduct = inventory.get(id);
        if (matchedProduct == null) {
            System.out.println("We don't carry that product");
            return;
        }
        System.out.printf("We carry %s and the price is $%.2f\n",
                matchedProduct.getName(), matchedProduct.getPrice());

        System.out.println("Do you want to search again? (Yes/No)");
        String ans = scanner.nextLine();
        if (ans.equalsIgnoreCase("yes")) {

        } else {
            running = false;
        }
    }

    static void loadInventory() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split("\\|");
                int productId = Integer.parseInt(data[0]);
                Product p = new Product(productId, data[1], Float.parseFloat(data[2]));
                inventory.put(productId, p);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error loading file!");
            e.printStackTrace();
        }
    }
}