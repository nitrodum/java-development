package com.pluralsight;

import java.util.Scanner;

public class CompoundInterestCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Compound Interest Calculator!");
        double p = input("deposit");
        double r = input("interest rate")/100/12;
        double n = input("number of years")*12;
    }

    public static double input(String message){
        System.out.println("Please enter the ");
        return scanner.nextDouble();
    }
}
