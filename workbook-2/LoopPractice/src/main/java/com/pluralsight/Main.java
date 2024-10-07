package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        whileLoop();
        forLoop();
        forEachLoop();
        monkeys();
        String x = "Hello";

        for (byte letter : x.getBytes()) {
            System.out.println(letter);
        }
    }

    static void whileLoop() {
        boolean isUnder = false;
        int count = 1;
        while(!isUnder) {
            System.out.println("Hi " + count);
            count++;
            if (Math.random() < .05) {
                isUnder = true;
            }
        }
    }
    static void forLoop() {
        for(int i = 0; i < 20; i++) {
            if (i%2 == 0) {
                System.out.println(i);
            }
        }
    }
    static void forEachLoop() {
        String[] fav = {"Apples", "Bananas", "Carrots", "Potatos"};
        for (String item : fav) {
            System.out.println(item);
        }
    }
    static void monkeys() {
        for (int i = 10; i >= 1; i--) {
            if (i != 1) {
                System.out.println(i + " little monkeys jumping on the bed, one fell of and bumped his head, mommy called the doctor and the doctor said no more monkeys jumping on the bed");
            } else {
                System.out.println(i + " little monkey jumping on the bed, one fell of and bumped his head, mommy called the doctor and the doctor said no more monkeys jumping on the bed");
            }
        }
    }
}