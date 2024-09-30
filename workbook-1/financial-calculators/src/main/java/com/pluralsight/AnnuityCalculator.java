package com.pluralsight;

import java.util.Scanner;

public class AnnuityCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Annuity Calculator!");
        double p = input("monthly payout");
        double r = input("interest rate")/100/12;
        double t = input("years to pay out")*12;

        double pv = getPresentValue(p, r, t);
        System.out.printf("The present value for this annuity is: $%.2f", pv);
    }

    public static double input(String message) {
        System.out.println("Please enter the " + message);
        return scanner.nextDouble();
    }

    public static double getPresentValue(double p, double r, double t) {
        return  p * (1 - Math.pow((1+r),-t)) / r ;
    }
}
