package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name in the format first last or first middle last");
        String name = scanner.nextLine().trim();
        scanner.close();
        String[] names = name.split("\\s");

        System.out.println("First name: " + names[0]);
        if (names.length == 3) {
            System.out.println("Middle name: " + names[1]);
            System.out.println("Last name: " + names[2]);
        } else {
            System.out.println("Middle name: (none)");
            System.out.println("Last name: " + names[1]);
        }
    }
}
