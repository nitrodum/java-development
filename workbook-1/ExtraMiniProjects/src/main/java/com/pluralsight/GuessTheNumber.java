package com.pluralsight;

import java.util.LinkedList;
import java.util.Scanner;

public class GuessTheNumber {
    static LinkedList<Integer> guesses = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int random = (int)(Math.random()*10) + 1;
        int guess = 0;
        int count = 1;


        System.out.println("Guess a number between 1-10");
        guess = getGuess();

        if (guess == random) {
            System.out.println("You got the right number " + random + " on the first try!");
        } else {
            while (guess != random) {
                System.out.println("Guess again");
                guess = getGuess();
                count++;
            }
            System.out.println("You guessed the right number " + random + " in " + count + " tries!");
        }
        scanner.close();
        System.out.println("Your guesses: ");
        for (Integer number : guesses) {
            System.out.println(number);
        }
    }

    public static int getGuess() {
        int guess = -1;
        boolean isValid = false;
        do {
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                guesses.add(guess);
                isValid = true;
            } else {
                scanner.nextLine();
            }
        } while (!isValid);
        return guess;
    }
}
