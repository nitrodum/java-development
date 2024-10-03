package com.pluralsight;

import java.util.Scanner;

public class AddressBuilder {
    static Scanner scanner = new Scanner(System.in);
    static StringBuilder address = new StringBuilder();
    public static void main(String[] args) {

        address.append(input("Please provide the following information:\n" +
                "Full name: "));
        System.out.println();
        address.append("\n\n");

        address.append("Billing Address: \n");
        inputAddress("Billing");
        address.append("\n");

        address.append("Shipping Address: \n");
        inputAddress("Shipping");

        String formattedAddress = address.toString();
        System.out.println(formattedAddress);
        scanner.close();

    }

    static void inputAddress(String message) {
        address.append(input( message + " Street: "));
        address.append("\n");

        address.append(input(message + " City: "));
        address.append(", ");
        address.append(input(message + " State: "));
        address.append(input(message + " Zip: "));
        address.append("\n");
        System.out.println();
    }

    static String input(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}
