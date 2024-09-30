package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Mortgage Calculator!");
        double p = input("Principle");
        double r = input("Interest Rate")/100/12;
        double n = input("Loan Length")*12;

        double m = getMonthly(p, r, n);
        System.out.printf("Your monthly rate is : $%.2f\n", m);

        double totalInterest = (m*n)-p;
        System.out.printf("Your total interest is : $%.2f\n", totalInterest);
    }
    public static double input(String message) {
        System.out.println("Please enter your " + message);
        return scanner.nextDouble();
    }

    public static double getMonthly(double p, double r, double n) {
        return (p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1)));
    }
}
