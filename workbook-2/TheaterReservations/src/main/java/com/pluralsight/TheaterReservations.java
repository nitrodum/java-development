package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter your full name:");
        String name = scanner.nextLine().trim();
        String[] splitName = name.split("\\s");
        String formattedName = splitName[1] + ", " + splitName[0];

        System.out.println("What date will you be coming (MM/dd/yyyy):");
        String date = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate ld = LocalDate.parse(date, formatter);

        boolean isValid = false;
        String tickets;

        do {
            System.out.println("How many tickets would you like?");
            tickets = scanner.nextLine();

            if (Integer.parseInt(tickets) == 1) {
                tickets = tickets + " ticket ";
                isValid = true;
            } else if (Integer.parseInt(tickets) > 1) {
                tickets = tickets + " tickets ";
                isValid = true;
            } else {
                System.out.println("Invalid ticket number!\n" +
                        "Please Try Again");
            }
        } while (!isValid);
        scanner.close();

        System.out.println(tickets + "reserved for " + ld + " under " + formattedName);

    }
}
