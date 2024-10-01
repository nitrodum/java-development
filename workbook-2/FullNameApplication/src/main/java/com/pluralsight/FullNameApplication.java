package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name.");
        String firstName = scanner.nextLine().trim() + " ";

        System.out.println("Enter your middle name or press enter.");
        String middleName = scanner.nextLine().trim();

        if (!middleName.isEmpty()){
            middleName = middleName + " ";
        }

        System.out.println("Enter your last name.");
        String lastName = scanner.nextLine().trim();

        System.out.println("Enter your suffix or press enter.");
        String suffix = scanner.nextLine().trim();

        if (!suffix.isEmpty()){
            suffix = ", " + suffix;
        }

        String fullName = firstName + middleName + lastName + suffix;
        System.out.println(fullName);
    }
}
