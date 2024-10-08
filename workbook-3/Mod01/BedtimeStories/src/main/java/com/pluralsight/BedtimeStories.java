package com.pluralsight;

import java.io.FileInputStream;
import java.util.Scanner;

public class BedtimeStories {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter the name of the story you want.\n" +
                "The choices are: " +
                "goldilocks.txt\n" +
                "hansel_and_gretel.txt\n" +
                "mary_had_a_little_lamb.txt");
        String choice = scanner.nextLine();
        scanner.close();

        try {
            FileInputStream file = new FileInputStream(choice);
            Scanner reader = new Scanner(file);
            String input;
            int line = 1;

            while (reader.hasNextLine()) {
                input = reader.nextLine();
                System.out.println(line + ". " + input);
                line++;
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
