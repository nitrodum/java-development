package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Mortgage Calculator!");
        double p = input("Principle");
        double r = input("Interest Rate")/100/12;
        double n = 12*input("Loan Length");

        double m = getMonthly(p, r, n);
        System.out.printf("Your monthly rate is : $%.2f", m);
    }
    public static double input(String message) {
        System.out.println("Please enter your " + message);
        return scanner.nextFloat();
    }

    public static double getMonthly(double p, double r, double n) {
        return (p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1)));
    }
}
