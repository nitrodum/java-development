package com.pluralsight;

import java.sql.*;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;
    private static Map<String, List<String>> tables = Map.of(
            "products", List.of("ProductID", "ProductName", "SupplierID", "CategoryID", "QuantityPerUnit", "UnitPrice", "UnitsInStock", "UnitsOnOrder", "ReorderLevel", "Discontinued"),
            "customers", List.of("CustomerID", "CompanyName", "ContactName", "ContactTitle", "Address", "City", "Region", "PostalCode", "Country", "Phone", "Fax"),
            "categories", List.of("CategoryID", "CategoryName", "Description")
    );

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", args[0], args[1]);
        ) {
            while (running) {
                menu(connection);
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
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
                4) Custom Search
                0) Exit
                """);
        String ans = scanner.nextLine();

        switch (ans) {
            case "1" -> getAllProducts(connection);
            case "2" -> getAllCustomers(connection);
            case "3" -> getAllCategories(connection);
            case "4" -> customSearch(connection);
            case "0" -> running = false;
            default -> System.out.println("Invalid Option");
        }
    }

    private static void customSearch(Connection connection) throws SQLException {
        System.out.println("""
                Select the data table to search from:
                1) Products
                2) Customers
                3) Categories""");

        String ans = scanner.nextLine();

        switch (ans) {
            case "1" -> getAll(connection, "products");
            case "2" -> getAll(connection, "customers");
            case "3" -> getAll(connection, "categories");
        }
    }

    private static void getAll(Connection connection, String tableName) throws SQLException {
        List<String> cols = tables.get(tableName);
        System.out.println("Please choose the columns separated by commas you would like to display or type all:\n" +
                String.join(", ", cols));

        String input = scanner.nextLine().trim();

        List<String> selectedCols = null;
        if (input.equalsIgnoreCase("all")) {
            selectedCols = cols;
        } else {
            selectedCols = new ArrayList<>();
            for (String col : input.split(",")) {
                selectedCols.add(col.trim());
            }
            if (!cols.containsAll(selectedCols)) {
                System.out.println("Invalid entry. Displaying all");
                selectedCols = cols;
            }
        }
        String sql = "SELECT " + String.join(",", selectedCols) + " FROM " + tableName;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()
        ) {
            printTable(results);
        }
    }

    private static void getAllProducts(Connection connection) throws SQLException {

        try (PreparedStatement statement = connection.prepareStatement("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products");
             ResultSet results = statement.executeQuery()
        ) {
            printProducts(results);
        }
    }

    private static void getAllCustomers(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT ContactName, CompanyName, City, Country, Phone FROM customers");
             ResultSet results = statement.executeQuery()
        ) {
            printCustomers(results);
        }
    }

    private static void getAllCategories(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT CategoryID, CategoryName FROM categories");
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
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                FROM products
                WHERE CategoryID = ?""")) {
            statement.setInt(1, id);
            try (ResultSet results = statement.executeQuery()) {
                printProducts(results);
            }
        }
    }

    private static void getProductByID(Connection connection) throws SQLException {
        System.out.println("\nEnter the Product ID you would like to search for: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                FROM products
                WHERE ProductID = ?""")) {
            statement.setInt(1, id);
            try (ResultSet results = statement.executeQuery()) {
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

    private static void printTable(ResultSet results) throws SQLException {
        Map<String, String> cols = new TreeMap<>();
        for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
            String colName = results.getMetaData().getColumnName(i);
            cols.put(colName, results.getMetaData().getColumnTypeName(i));
            System.out.printf("%-35s", colName);
        }
        System.out.println();
        cols.forEach((k, v) -> System.out.printf("%-35s", "-".repeat(34)));
        System.out.println();

        while (results.next()) {
            for (String colKey : cols.keySet()) {
                if (cols.get(colKey).equalsIgnoreCase("VARCHAR") || cols.get(colKey).toUpperCase().contains("INT")) {
                    System.out.printf("%-35s", results.getString(colKey));
                }
            }
            System.out.println();
        }
    }

}