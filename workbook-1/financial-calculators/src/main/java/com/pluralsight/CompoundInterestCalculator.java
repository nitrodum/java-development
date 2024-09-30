package com.pluralsight;

import java.util.Scanner;

public class CompoundInterestCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Compound Interest Calculator!");
        double p = input("deposit");
        double r = input("interest rate")/100;
        double t = input("number of years");
        double n = 365;
        scanner.close();

        double A = getFutureValue(p, r, t, n);
        System.out.printf("The future value of this account is: $%.2f\n", A);
        System.out.printf("You will earn $%.2f in interest!", (A-p));
    }

    public static double input(String message){
        System.out.println("Please enter the " + message);
        return scanner.nextDouble();
    }

    public static double getFutureValue(double p, double r, double t, double n) {
        return (p * Math.pow((1+(r/n)),(n*t)));
    }
}
