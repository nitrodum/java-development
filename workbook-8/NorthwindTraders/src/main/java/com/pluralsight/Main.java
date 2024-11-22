package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "yearup");

        Statement statement = connection.createStatement();

        String query = "SELECT * FROM products";

        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            String name = results.getString("ProductName");
            System.out.println(name);
        }
        connection.close();
    }
}