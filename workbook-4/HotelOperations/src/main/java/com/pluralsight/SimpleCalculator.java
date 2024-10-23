package com.pluralsight;

public class SimpleCalculator {
    public double addTwoNumbers(double x, double y) {
        return x+y;
    }

    public double divideTwoNumbers(double dividend, double divisor) {
        if (divisor != 0) {
            return dividend / divisor;
        } else {
            return 0;
        }

    }
}
