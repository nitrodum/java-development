package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;
class SimpleCalculatorTest {

    @org.junit.jupiter.api.Test
    void addTwoNumbers_positiveNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        double result = simpleCalculator.addTwoNumbers(3, 4);

        assertEquals(7, result);
    }

    @org.junit.jupiter.api.Test
    void addTwoNumbers_negativeNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        double result = simpleCalculator.addTwoNumbers(-3, -4);

        assertEquals(-7, result);
    }

    @org.junit.jupiter.api.Test
    void addTwoNumbers_positiveAndNegativeNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        double result = simpleCalculator.addTwoNumbers(-3, 4);

        assertEquals(1, result);
    }

    @org.junit.jupiter.api.Test
    void divideTwoNumbers_positiveNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        double result = simpleCalculator.divideTwoNumbers(10, 2);

        assertEquals(5, result);
    }

    @org.junit.jupiter.api.Test
    void divideTwoNumbers_negativeNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        double result = simpleCalculator.divideTwoNumbers(-10, -2);

        assertEquals(5, result);
    }

    @org.junit.jupiter.api.Test
    void divideTwoNumbers_positiveAndNegativeNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        double result = simpleCalculator.divideTwoNumbers(-10, 2);

        assertEquals(-5, result);
    }

    @org.junit.jupiter.api.Test
    void divideTwoNumbers_divideByZero() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        double result = simpleCalculator.divideTwoNumbers(-10, 0);

        assertEquals(0, result);
    }
}