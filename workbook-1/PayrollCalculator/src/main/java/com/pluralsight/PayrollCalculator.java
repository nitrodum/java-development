package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        String name;
        float hoursWorked = 0.0f;
        float payRate = 0.0f;
        boolean isValid = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        name = scanner.nextLine();

        do {
            System.out.println("Please enter your hours worked: ");
            if (scanner.hasNextFloat()) {
                hoursWorked = scanner.nextFloat();
                isValid = true;
            } else {
                System.out.println("Not a valid entry, please reenter a valid number");
                scanner.next();
            }
        } while (!isValid);

        isValid = false;
        do {
            System.out.println("Please enter your pay rate: ");
            if (scanner.hasNextFloat()) {
                payRate = scanner.nextFloat();
                isValid = true;
            } else {
                System.out.println("Not a valid entry, please reenter a valid number");
                scanner.next();
            }
        } while (!isValid);
        float grossPay = 0.0f;

        if (hoursWorked < 40) {
            grossPay = hoursWorked * payRate;
        } else {
            grossPay = (40f*payRate) + ((hoursWorked-40f)*payRate*1.5f);
        }

        System.out.printf("Hello, %s your gross pay is $%.2f", name, grossPay);
        scanner.close();
    }
}
