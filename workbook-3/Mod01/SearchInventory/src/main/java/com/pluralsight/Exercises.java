package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

public class Exercises {
    public static void main(String[] args) {
        favSongs();
        ages();
        puppies();
    }

    static void favSongs() {
        ArrayList<String> favSongs = new ArrayList<>();
        favSongs.add("Right Now - New Jeans");
        favSongs.add("DashStar - Knock2");
        favSongs.add("MIMI - youra");
        favSongs.remove(1);
        Collections.sort(favSongs);
        System.out.println(favSongs);
    }

    static void ages() {
        ArrayList<Integer> ages = new ArrayList<>();
        ages.add(22);
        ages.add(27);
        ages.add(26);
        ages.add(24);

        ages.clone();

        ArrayList<Integer> newAges = new ArrayList<>();
        for (int age : ages) {
            newAges.add(age + (2*age));
        }

        Collections.sort(newAges);

        int sum = 0;
        for (int age : newAges) {
            sum += age;
        }

        System.out.println("Sum of ages: " + sum + " Average age: " + ((float)(sum/newAges.size())));

    }

    static void puppies() {
        ArrayList<Puppy> puppies = new ArrayList<>();
        Puppy puppy1 = new Puppy("Bla", "Golden Retriever");
        Puppy puppy2 = new Puppy("La", "German Shepard");
        Puppy puppy3 = new Puppy("Ba", "Border Collie");

        puppies.add(puppy1);
        puppies.add(puppy2);
        puppies.add(puppy3);

        puppies.remove(puppy2);

        System.out.println("Remaining puppies count: " + puppies.size());
    }
}
