package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/car_dealership_database", args[0], args[1])
        ) {
            displayALLVehicles(connection); // 1
            askForDealership(connection); // 2
            askForCarDetails(connection); // 3
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/northwind", args[0], args[1])) {
            displayAllProducts(connection); // 4
            askForCategoryName(connection); // 5
            askForProductDetails(connection); // 6
            askForSupplierName(connection);
        }

    }

    private static void displayALLVehicles(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vehicles");
             ResultSet results = statement.executeQuery()) {
            printVehicles(results);
        }
    }

    private static void printVehicles(ResultSet results) throws SQLException {
        System.out.printf("%-8s%-10s%-12s%-10s%-9s%-8s\n", "VIN", "Make", "Model", "Color", "Price", "Sold");
        System.out.printf("%-8s%-10s%-12s%-10s%-9s%-8s\n", "-".repeat(7), "-".repeat(9), "-".repeat(11), "-".repeat(9), "-".repeat(8), "-".repeat(7));
        while (results.next()) {
            String vin = results.getString("VIN");
            String make = results.getString("Make");
            String model = results.getString("Model");
            String color = results.getString("Color");
            Double price = results.getDouble("Price");
            boolean sold = results.getBoolean("Sold");
            String isSold = (sold) ? "Sold" : "Not Sold";
            System.out.printf("%-8s%-10s%-12s%-10s%-9.2f%-8s\n", vin, make, model, color, price, isSold);
        }
    }

    private static void askForDealership(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT * FROM dealerships
                WHERE Name = ?
                """)) {
            System.out.println("Enter the name of the dealership you would like the details for: ");
            String dealershipName = scanner.nextLine();
            statement.setString(1, dealershipName);
            try (ResultSet results = statement.executeQuery()) {
                System.out.printf("%-13s%-30s%-40s%-13s\n", "DealershipID", "Name", "Address", "Phone");
                System.out.printf("%-13s%-30s%-40s%-13s\n", "-".repeat(12), "-".repeat(29), "-".repeat(39), "-".repeat(12));
                int dealershipID = 0;
                while (results.next()) {
                    dealershipID = results.getInt("DealershipID");
                    String name = results.getString("Name");
                    String address = results.getString("Address");
                    String phone = results.getString("phone");
                    System.out.printf("%-13s%-30s%-40s%-13s\n", dealershipID, name, address, phone);
                }
                System.out.println("Would you like to see the cars this dealership has? (y/n)");
                String ans = scanner.nextLine();
                if (ans.equalsIgnoreCase("y")) {
                    try (PreparedStatement carStatement = connection.prepareStatement("""
                            SELECT v.* FROM vehicles AS v
                            INNER JOIN inventory AS i
                            ON v.VIN = i.VIN
                            WHERE i.dealershipID = ?""")) {
                        carStatement.setInt(1, dealershipID);
                        try (ResultSet carResults = carStatement.executeQuery()) {
                            printVehicles(carResults);
                        }
                    }
                } else {
                    System.out.println("BYE");
                }
            }
        }

    }

    private static void askForCarDetails(Connection connection) throws SQLException {
        System.out.println("""
                Choose what property of a car you would to select:
                1) Color
                2) Make
                3) Dealership Location
                """);
        String ans = scanner.nextLine();
        switch (ans) {
            case "1" -> searchCarByColor(connection);
            case "2" -> searchCarByMake(connection);
            case "3" -> searchCarByDealershipLocation(connection);
            default -> System.out.println("Invalid Option");
        }
    }

    private static void searchCarByColor(Connection connection) throws SQLException {
        System.out.println("Enter the color you would like to search for:");
        String searchColor = scanner.nextLine();
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT * FROM vehicles
                WHERE Color = ?"""
        )) {
            statement.setString(1, searchColor);
            try (ResultSet results = statement.executeQuery()) {
                printVehicles(results);
            }
        }
    }

    private static void searchCarByMake(Connection connection) throws SQLException {
        System.out.println("Enter the make you would like to search for:");
        String searchMake = scanner.nextLine();
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT * FROM vehicles
                WHERE Make = ?"""
        )) {
            statement.setString(1, searchMake);
            try (ResultSet results = statement.executeQuery()) {
                printVehicles(results);
            }
        }
    }

    private static void searchCarByDealershipLocation(Connection connection) throws SQLException {
        System.out.println("Enter the dealership location you would like to search for:");
        String location = scanner.nextLine();
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT v.* FROM vehicles AS v
                INNER JOIN inventory AS i
                ON v.VIN = i.VIN
                INNER JOIN dealerships AS d
                ON i.DealershipID = d.DealershipID
                WHERE d.Address LIKE ?"""
        )) {
            statement.setString(1, "%" + location + "%");
            try (ResultSet results = statement.executeQuery()) {
                printVehicles(results);
            }
        }
    }

    private static void displayAllProducts(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
             ResultSet results = statement.executeQuery()) {
            printProducts(results);
        }
    }

    private static void printProducts(ResultSet results) throws SQLException {
        System.out.printf("%-5s%-35s%-8s%-7s\n", "Id", "Name", "Price", "Quantity Per Unit");
        System.out.printf("%-5s%-35s%-8s%-7s\n", "-".repeat(4), "-".repeat(34), "-".repeat(7), "-".repeat(19));
        while (results.next()) {
            int id = results.getInt("ProductID");
            String name = results.getString("ProductName");
            double price = results.getDouble("UnitPrice");
            String stock = results.getString("QuantityPerUnit");
            System.out.printf("%-5d%-35s%-8.2f%-7s\n", id, name, price, stock);
        }
    }

    private static void askForCategoryName(Connection connection) throws SQLException {
        System.out.println("Enter a category name to search for:");
        String searchCategory = scanner.nextLine();
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT * FROM categories
                WHERE CategoryName = ?""")) {
            statement.setString(1, searchCategory);
            try (ResultSet results = statement.executeQuery()) {
                printCategory(results);
                System.out.println("Would you like to see the products in this category? (y/n)");
                String ans = scanner.nextLine();
                if (ans.equalsIgnoreCase("y")) {
                    productByCategory(connection, searchCategory);
                } else {
                    System.out.println("BYE");
                }
            }
        }

    }

    private static void printCategory(ResultSet results) throws SQLException {
        System.out.printf("%-11s%-13s%-50s\n", "CategoryID", "CategoryName", "Description");
        System.out.printf("%-11s%-13s%-50s\n", "-".repeat(10), "-".repeat(12), "-".repeat(49));
        while (results.next()) {
            int categoryID = results.getInt("CategoryID");
            String categoryName = results.getString("CategoryName");
            String desc = results.getString("Description");
            System.out.printf("%-11s%-13s%-50s\n", categoryID, categoryName, desc);
        }
    }

    private static void askForProductDetails(Connection connection) throws  SQLException {
        System.out.println("""
                Choose what property of a product you would to select:
                1) Product Name
                2) Supplier Name
                3) Category Name
                """);
        String ans = scanner.nextLine();
        switch (ans) {
            case "1" -> searchProductByName(connection);
            case "2" -> searchProductBySupplierID(connection);
            case "3" -> searchProductByCategory(connection);
            default -> System.out.println("Invalid Option");
        }
    }

    private static void searchProductByName(Connection connection) throws SQLException {
        System.out.println("Enter the name of the product you would like to search for");
        String searchName = scanner.nextLine();

        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT * FROM products
                WHERE productName LIKE ?""")) {
            statement.setString(1, "%" + searchName + "%");

            try (ResultSet results = statement.executeQuery()) {
                printProducts(results);
            }
        }
    }

    private static void searchProductBySupplierID(Connection connection) throws SQLException {
        System.out.println("Enter the supplier name of the product you would like to search for");
        String supplierName = scanner.nextLine();

        productBySupplier(connection, supplierName);
    }

    private static void searchProductByCategory(Connection connection) throws SQLException {
        System.out.println("Enter the category name of the product you would like to search for");
        String supplierName = scanner.nextLine();
        productByCategory(connection, supplierName);
    }

    private static void productByCategory(Connection connection, String searchCategory) throws SQLException {
        try (PreparedStatement productStatement = connection.prepareStatement("""
                            SELECT p.* FROM products AS p
                            INNER JOIN categories AS c
                            ON p.CategoryID = c.CategoryID
                            WHERE c.CategoryName = ?""")) {
            productStatement.setString(1, searchCategory);
            try (ResultSet productResults = productStatement.executeQuery()) {
                printProducts(productResults);
            }
        }
    }

    private static void askForSupplierName(Connection connection) throws SQLException {
        System.out.println("Enter a supplier name to search for:");
        String searchSupplier = scanner.nextLine();
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT * FROM suppliers
                WHERE CompanyName = ?""")) {
            statement.setString(1, searchSupplier);
            try (ResultSet results = statement.executeQuery()) {
                printSuppliers(results);
                System.out.println("Would you like to see the products by this supplier? (y/n)");
                String ans = scanner.nextLine();
                if (ans.equalsIgnoreCase("y")) {
                    productBySupplier(connection, searchSupplier);
                } else {
                    System.out.println("BYE");
                }
            }
        }
    }

    private static void productBySupplier(Connection connection, String supplierName) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT p.* FROM products AS p
                INNER JOIN suppliers AS s
                ON p.supplierID = s.supplierID
                WHERE companyName = ?""")) {
            statement.setString(1, supplierName);

            try (ResultSet results = statement.executeQuery()) {
                printProducts(results);
            }
        }
    }

    private static void printSuppliers(ResultSet resultSet) throws SQLException {
        System.out.printf("%-11s%-30s%-30s%-30s%-50s%20s\n", "SupplierID", "CompanyName", "ContactName", "ContactTitle", "Address", "City");
        System.out.printf("%-11s%-30s%-30s%-30s%-50s%20s\n","-".repeat(10), "-".repeat(29), "-".repeat(29), "-".repeat(29), "-".repeat(49), "-".repeat(19));
        while (resultSet.next()) {
            int supplierID = resultSet.getInt("SupplierID");
            String companyName = resultSet.getString("CompanyName");
            String contactName = resultSet.getString("ContactName");
            String contactTitle = resultSet.getString("ContactTitle");
            String address = resultSet.getString("Address");
            String city = resultSet.getString("City");
            System.out.printf("%-11s%-30s%-30s%-30s%-50s%20s\n",supplierID, companyName, contactName, contactTitle, address, city);
        }
    }
}