package com.pluralsight;

import java.util.Scanner;

public class FamousQuotes {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] quotes = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        boolean running = true;

        do {
            System.out.println("Please select a number 1-10 to pick a quote or -1 for a random quote!");
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num == -1) {
                int rand = (int)(Math.random()*10);
                System.out.println(quotes[rand]);
            } else {
                try {
                    System.out.println(quotes[num - 1]);
                } catch (Exception e) {
                    System.out.println("Number out of range!");
                }
            }
            System.out.println("Do you want to pick another quote?");
            String ans = scanner.nextLine();
            if (!ans.equalsIgnoreCase("YES")) {
                running = false;
            }
        } while (running);

        scanner.close();
    }
}
