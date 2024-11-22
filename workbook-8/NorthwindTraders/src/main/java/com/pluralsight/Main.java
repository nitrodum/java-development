package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", args[0], args[1]);
        ) {
            getAllProducts(connection);
            getProductByID(connection);
        }
        scanner.close();
    }

    private static void getAllProducts(Connection connection) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products");
            ResultSet results = statement.executeQuery()
        ) {
            printProducts(results);
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

}