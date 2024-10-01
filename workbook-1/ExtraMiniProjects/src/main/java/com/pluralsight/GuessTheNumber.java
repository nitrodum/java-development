package com.pluralsight;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuessTheNumber {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double totalGuesses = 0;
        double gamesToRun = 10000;

        for (int i = 0; i < gamesToRun; i++) {
            totalGuesses += runScript();
        }
        System.out.printf("The average number of guesses was %.2f",(totalGuesses / gamesToRun));
        scanner.close();

    }

    public static int getGuess(LinkedList<Integer> guesses) {
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

    public static void runGame() {
        int random = (int) (Math.random() * 10) + 1;
        int guess = 0;
        int count = 1;
        LinkedList<Integer> guesses = new LinkedList<>();

        System.out.println("Guess a number between 1-10");
        guess = getGuess(guesses);

        if (guess == random) {
            System.out.println("You got the right number " + random + " on the first try!");
        } else {
            while (guess != random) {
                if (guess > random) {
                    System.out.println("Guess lower");
                } else {
                    System.out.println("Guess higher");
                }
                guess = getGuess(guesses);
                count++;
            }

            System.out.println("You guessed the right number " + random + " in " + count + " tries!");
            if (count < 5) {
                System.out.println("You are awesome!");
            }

        }
    }

    public static int runScript() {
        int random = (int) (Math.random() * 10) + 1;
        int guess = 0;
        int count = 1;
        LinkedList<Integer> guesses = new LinkedList<>();
        guess = (int) (Math.random() * 10) + 1;
        guesses.add(guess);
        while (guess != random) {
            guess = (int) (Math.random() * 10) + 1;
            guesses.add(guess);
            count++;
        }
        writeToFile(guesses, count, random);
        return count;
    }

    public static void writeToFile(LinkedList<Integer> guesses, int count, int random) {
        try {
            FileWriter writer = new FileWriter("results.txt", true);
            writer.write("You guessed the right number " + random + " in " + count + " guesses.\n");
            writer.write("Your guesses: ");
            for (Integer number : guesses) {
                writer.write(number + " ");
            }
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
