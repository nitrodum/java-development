package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StoreApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Product> inventory = new ArrayList<Product>();

    public static void main(String[] args) {
        getInventory();
        menu();

        scanner.close();
    }

    public static void menu() {
        int choice = 0;
        do {
            System.out.println("What do you want to do?\n" +
                    "\t1-List all products\n" +
                    "\t2-Look up a product by its id\n" +
                    "\t3-Find all products within a price range\n" +
                    "\t4-Add a new product\n" +
                    "\t5-Quit the application\n" +
                    "Enter the command:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    lookUpById();
                    break;
                case 3:
                    findInPriceRange();
                case 4:
                    addProduct();
            }
        } while (choice != 5);
    }

    public static void displayAll() {

        System.out.println("We carry the following inventory: ");

        inventory.sort(Comparator.comparing(Product::getName));

        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static void lookUpById() {
        System.out.println("Please enter the product id you are looking for:");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Product p : inventory) {
            if (p.getId() == id) {
                System.out.printf("id: %d %s - Price: $%.2f\n",
                        p.getId(), p.getName(), p.getPrice());
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public static void findInPriceRange() {
        System.out.println("Please enter the bottom of the price range: ");
        float floor = scanner.nextFloat();
        System.out.println("Please enter the top of the price range: ");
        float top = scanner.nextFloat();
        scanner.nextLine();

        inventory.sort(Comparator.comparing(Product::getPrice));

        for (Product p : inventory) {
            if (p.getPrice() >= floor && p.getPrice() <= top) {
                System.out.printf("id: %d %s - Price: $%.2f\n",
                        p.getId(), p.getName(), p.getPrice());
            } else if (p.getPrice() > top) {
                return;
            }
        }
    }

    public static void addProduct() {
        System.out.println("Please enter the details of the product to add.\n" +
                "Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Product Name: ");
        String name = scanner.nextLine();
        System.out.println("Product Price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();

        inventory.add(new Product(id, name, price));
    }

    public static void getInventory() {

        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;

            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split("\\|");
                Product p = new Product(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]));
                inventory.add(p);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println("Error Reading File!");
            e.printStackTrace();
        }
    }
}
