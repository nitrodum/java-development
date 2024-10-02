package com.pluralsight;

import java.util.Scanner;

public class HighScoreWins {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter the game score in format: HomeName:VisitorName|HomeScore:VisitorScore");
        String input = scanner.nextLine();
        scanner.close();
        String[] headings = input.split("\\|");
        String[] names = headings[0].split(":");
        String[] scores = headings[1].split(":");
        if (Integer.parseInt(scores[0]) > Integer.parseInt(scores[1])) {
            System.out.println("Winner: " + names[0]);
        } else if (Integer.parseInt(scores[0]) < Integer.parseInt(scores[1])) {
            System.out.println("Winner: " + names[1]);
        } else {
            System.out.println("Tie Game");
        }
    }
}
