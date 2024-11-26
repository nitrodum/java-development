package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main {
    private static BasicDataSource dataSource;
    private static DataManager dm;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init(args);
        getActorByLastName();


        getMoviesByActor();

        scanner.close();
    }

    private static void init(String[] args) {
        String username = args[0];
        String password = args[1];
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dm = new DataManager(dataSource);
    }

    private static void getActorByLastName() {
        System.out.println("Enter the last name you would like to search for:");
        String lastName = scanner.nextLine();

        System.out.printf("%-10s%-20s%-20s\n", "actor_id", "first_name", "last_name");
        System.out.printf("%-10s%-20s%-20s\n", "-".repeat(9), "-".repeat(19), "-".repeat(19));
        dm.getActorByLastName(lastName).forEach(System.out::println);
    }

    private static void getMoviesByActor( ) {
        System.out.println("Enter the first and last name of an actor to see movies they are in.\n" +
                "First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.printf("%-9s%-30s%-55s%-14s%-7s\n", "film_id", "title", "description", "release_year", "length");
        System.out.printf("%-9s%-30s%-55s%-14s%-7s\n", "-".repeat(8), "-".repeat(29), "-".repeat(54),
                "-".repeat(13), "-".repeat(7));
        dm.getMoviesByActor(firstName, lastName).forEach(System.out::println);

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