package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main {
    private static BasicDataSource dataSource;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init(args);
        try (Connection connection = dataSource.getConnection()) {
            getActorByLastName(connection);
            getMoviesByActor(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    private static void init(String[] args) {
        String username = args[0];
        String password = args[1];
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    private static void getActorByLastName(Connection connection) throws SQLException {
        System.out.println("Enter the last name you would like to search for:");
        String lastName = scanner.nextLine();

        try (PreparedStatement statement = connection.prepareStatement("SELECT first_name, last_name FROM actor WHERE last_name = ?")) {
            statement.setString(1, lastName);
            try (ResultSet results = statement.executeQuery()) {
                printTable(results);
            }
        }
    }

    private static void getMoviesByActor(Connection connection) throws SQLException {
        System.out.println("Enter the first and last name of an actor to see movies they are in.\n" +
                "First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();

        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT title FROM film AS f
                INNER JOIN film_actor AS fa
                ON f.film_id = fa.film_id
                INNER JOIN actor AS a
                ON fa.actor_id = a.actor_id
                WHERE a.first_name = ? AND a.last_name = ?""")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            try (ResultSet results = statement.executeQuery()) {
                printTable(results);
            }
        }
    }

    private static void printTable(ResultSet results) throws SQLException {
        List<String> cols = new ArrayList<>();
        for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
            String colName = results.getMetaData().getColumnName(i);
            cols.add(colName);
            System.out.printf("%-20s", colName);
        }
        System.out.println();
        cols.forEach(col -> System.out.printf("%-20s", "-".repeat(19)));
        System.out.println();

        if (!results.next()) {
            System.out.println("No matches!");
        }

        while (results.next()) {
            for (String column : cols) {
                System.out.printf("%-20s", results.getString(column));
            }
            System.out.println();
        }
    }
}