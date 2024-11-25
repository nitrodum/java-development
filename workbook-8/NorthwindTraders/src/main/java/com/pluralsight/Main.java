package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", args[0], args[1]);
        ) {
            while (running) {
                menu(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        scanner.close();
    }

    private static void menu(Connection connection) throws SQLException {
        System.out.println("""
                --------------------------------------------------------------------------------------------------------
                What do you want to do?
                1) Display all products
                2) Display all customers
                3) Display all categories
                0) Exit
                """);
        String ans = scanner.nextLine();

        switch (ans) {
            case "1" -> getAllProducts(connection);
            case "2" -> getAllCustomers(connection);
            case "3" -> getAllCategories(connection);
            case "0" -> running = false;
            default -> System.out.println("Invalid Option");
        }
    }

    private static void getAllProducts(Connection connection) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products");
            ResultSet results = statement.executeQuery()
        ) {
            printProducts(results);
        }
    }

    private static void getAllCustomers(Connection connection) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement("SELECT ContactName, CompanyName, City, Country, Phone FROM customers");
            ResultSet results = statement.executeQuery()
        ) {
            printCustomers(results);
        }
    }

    private static void getAllCategories(Connection connection) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement("SELECT CategoryID, CategoryName FROM categories");
            ResultSet results = statement.executeQuery()
        ) {
            printCategories(results);
        }
        productByCategory(connection);
    }

    private static void productByCategory(Connection connection) throws SQLException {
        System.out.println("\nEnter the category ID you would like to search for: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try(PreparedStatement statement = connection.prepareStatement("""
                SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                FROM products
                WHERE CategoryID = ?""" )){
            statement.setInt(1, id);
            try(ResultSet results = statement.executeQuery()) {
                printProducts(results);
            }
        }
    }

    private static void getProductByID(Connection connection) throws SQLException {
        System.out.println("\nEnter the Product ID you would like to search for: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try(PreparedStatement statement = connection.prepareStatement("""
                SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                FROM products
                WHERE ProductID = ?""" )){
            statement.setInt(1, id);
            try(ResultSet results = statement.executeQuery()) {
                printProducts(results);
            }
        }
    }

    private static void printProducts(ResultSet results) throws SQLException {
        System.out.printf("%-5s%-35s%-8s%-7s\n", "Id", "Name", "Price", "Stock");
        System.out.printf("%-5s%-35s%-8s%-7s\n", "-".repeat(4), "-".repeat(34), "-".repeat(7), "-".repeat(6));
        while (results.next()) {
            int id = results.getInt("ProductID");
            String name = results.getString("ProductName");
            double price = results.getDouble("UnitPrice");
            int stock = results.getInt("UnitsInStock");
            System.out.printf("%-5d%-35s%-8.2f%-7d\n", id, name, price, stock);
        }
    }

    private static void printCustomers(ResultSet results) throws SQLException {
        System.out.printf("%-30s%-40s%-15s%-15s%-13s\n", "ContactName", "CompanyName", "City", "Country", "Phone");
        System.out.printf("%-30s%-40s%-15s%-15s%-13s\n", "-".repeat(29), "-".repeat(39), "-".repeat(14), "-".repeat(14), "-".repeat(12));
        while (results.next()) {
            String contactName = results.getString("ContactName");
            String companyName = results.getString("CompanyName");
            String city = results.getString("City");
            String country = results.getString("Country");
            String phone = results.getString("Phone");
            System.out.printf("%-30s%-40s%-15s%-15s%-13s\n", contactName, companyName, city, country, phone);
        }
    }

    private static void printCategories(ResultSet results) throws SQLException {
        System.out.printf("%-11s%-13s\n", "CategoryID", "CategoryName");
        System.out.printf("%-11s%-13s\n", "-".repeat(10), "-".repeat(12));
        while (results.next()) {
            int categoryID = results.getInt("CategoryID");
            String categoryName = results.getString("CategoryName");
            System.out.printf("%-11s%-13s\n", categoryID, categoryName);
        }
    }

}