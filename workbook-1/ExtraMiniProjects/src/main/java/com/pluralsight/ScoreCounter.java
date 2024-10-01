package com.pluralsight;

import java.util.Scanner;

public class ScoreCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] scores = new Integer[5];
        int count = 0;

        System.out.println("Please enter the five test scores.");
        for (int i = 0; i < 5; i++){
            scores[i] = scanner.nextInt();
        }
        for (int score : scores) {
            if (score > 7) {
                count++;
            }
        }
        System.out.println("The count of score over 7 is: " + count);
        scanner.close();
    }
}
