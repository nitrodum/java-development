package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectingWords {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        fourWords();
    }

    public static void collectWordsInWhile() {
        ArrayList<String> wordList = new ArrayList<>();
        String word;

        System.out.println("Please enter a word.");
        while (!(word = scanner.nextLine()).isBlank()) {
            if (!wordList.contains(word)) {
                wordList.add(word);
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (i == 0) {
                    System.out.print(wordList.get(i));
                } else {
                    System.out.print(", " + wordList.get(i));
                }
            }
            System.out.println();
        }
    }

    public static void fourWords() {
        ArrayList<String> wordList = new ArrayList<>();
        String word;
        float avg = 0f;
        String smallest = "";
        String largest = "";

        System.out.println("Please enter four words.");

        for (int i = 0; i < 4; i++) {
            word = scanner.nextLine();
            wordList.add(word);
            avg += word.length();
            if (i == 0) {
                smallest = word;
                largest = word;
            } else if (smallest.length() > word.length()) {
                smallest = word;
            } else if (largest.length() < word.length()) {
                largest = word;
            }
        }
        avg /= 4;
        System.out.println("Smallest word was: " + smallest);
        System.out.println("Largest word was: " + largest);
        System.out.println("The average word length was: " + avg);
    }

}
