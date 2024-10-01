package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectingWords {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        String word;
        System.out.println("Please enter a word.");
        while (!(word = scanner.nextLine()).isBlank()) {
            wordList.add(word);
        }
    }
}
