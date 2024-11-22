package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "yearup");

        String query = "SELECT ProductID, ProductName FROM products";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            int id = results.getInt("ProductID");
            String name = results.getString("ProductName");
            System.out.println(id + " " + name);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the product you would like get details for: ");
        int productID = scanner.nextInt();
        scanner.nextLine();

        query = "SELECT ProductID, ProductName FROM products WHERE ProductID = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, productID);

        results = statement.executeQuery();

        while (results.next()) {
            int id = results.getInt("ProductID");
            String name = results.getString("ProductName");
            System.out.println(id + " " + name);
        }

        results.close();
        statement.close();
        connection.close();

        scanner.close();
    }
}