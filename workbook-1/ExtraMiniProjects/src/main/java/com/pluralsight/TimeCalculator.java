package com.pluralsight;

import java.util.Scanner;

public class TimeCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the time in format HH.MM");
        float time = scanner.nextFloat();
        System.out.println("Enter the minutes to add or subtract");
        int timeToAdd = scanner.nextInt();

        int hoursToAdd = timeToAdd / 60;
        float minutesToAdd = (timeToAdd % 60)/100f;

        int currentHours = (int) time;
        float currentMinutes = time - currentHours;

        int newHours = (hoursToAdd + currentHours)%24;
        float newMinutes = minutesToAdd + currentMinutes;

        time = newHours + newMinutes;

        System.out.println("New time = " + time);
    }
}
