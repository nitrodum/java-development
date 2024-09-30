package com.pluralsight;

import java.util.Scanner;

public class AnnuityCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Annuity Calculator!");
        double m = input("monthly payout");
        double r = input("interest rate");
        double n = input("years to pay out");
    }

    public static double input(String message) {
        System.out.println("Please enter the " + message);
        return scanner.nextDouble();
    }
}
