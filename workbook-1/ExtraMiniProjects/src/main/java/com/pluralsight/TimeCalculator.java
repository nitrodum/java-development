package com.pluralsight;

import java.util.Scanner;

public class TimeCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the time in format HH.MM");
        float time = scanner.nextFloat();
        System.out.println("Enter the minutes to add or subtract");
        int timeToAdd = scanner.nextInt();

        int hours = timeToAdd / 60;
        int minutes = timeToAdd % 60;

        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
    }
}
