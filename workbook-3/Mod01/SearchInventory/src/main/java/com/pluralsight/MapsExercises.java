package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsExercises {
    public static void main(String[] args) {
        getFruits();
        getSquares();
        getPuppies();
    }

    static void getFruits() {
        Map<String, String> favFruits = new HashMap<>();
        favFruits.put("Nima", "Apples");
        favFruits.put("Osmig", "Bananas");
        favFruits.put("Harvinder", "Starberry");
        favFruits.put("Mordecai", "Oranges");
        System.out.println(favFruits.get("Nima"));
    }

    static void getSquares() {
        Map<Integer, Integer> squares = new HashMap<>();
        squares.put(1, 1);
        squares.put(2, 4);
        squares.put(3, 9);
        squares.put(4, 16);
        squares.put(5, 25);
        System.out.println(squares.get(4));
    }

    static void getPuppies() {
        Map<String, List<Puppy>> puppies = new HashMap<>();
        puppies.put("Nima", new ArrayList<Puppy>(List.of(new Puppy("dog1", "Golden Retriever"))));
        puppies.put("Adrian", new ArrayList<Puppy>(List.of(new Puppy("dog2", "Pitbull"))));
        puppies.put("Osmig", new ArrayList<Puppy>(List.of(new Puppy("dog3", "Poodle"))));
        System.out.println(puppies.get("Adrian").get(0).getName()  + " " + puppies.get("Adrian").get(0).getBreed());
    }
}
