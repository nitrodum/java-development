package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static BasicDataSource dataSource;
    private static ShipperDAO shipperDAO;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init(args);
        addShipper();
        displayAll();
        updatePhoneNumber();
        displayAll();
        deleteShipper();
        displayAll();
        scanner.close();
    }

    private static void deleteShipper() {
        System.out.println("Enter the id shipping company you would like to delete:\n" +
                "Shipping ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        shipperDAO.deleteRecord(id);
    }

    private static void updatePhoneNumber() {
        System.out.println("Enter the id shipping company you would like to update:\n" +
                "Shipping ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Phone Number: ");
        String phone = scanner.nextLine();

        shipperDAO.updatePhone(id, phone);
    }

    private static void displayAll() {
        System.out.printf("%-10s%-20s%-15s\n", "ShipperID", "CompanyName", "Phone");
        System.out.printf("%-10s%-20s%-15s\n", "-".repeat(9), "-".repeat(19), "-".repeat(14));
        shipperDAO.getAllShippers().forEach(System.out::println);
    }

    private static void addShipper() {
        System.out.println("Enter the name and phone number of the shipping company you would like to add:\n" +
                "Company Name: ");
        String companyName = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phone = scanner.nextLine();

        Shipper s = new Shipper(companyName, phone);
        shipperDAO.add(s);
    }

    private static void init(String[] args) {
        String username = args[0];
        String password = args[1];
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        shipperDAO = new ShipperDAO(dataSource);
    }
}