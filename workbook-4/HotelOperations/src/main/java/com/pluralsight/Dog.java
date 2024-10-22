package com.pluralsight;

public class Dog {
    String name;
    String breed;
    String sound;

    public Dog(String name, String breed, String sound) {
        this.name = name;
        this.breed = breed;
        this.sound = sound;
    }

    public void bark() {
        System.out.println(name + " says " + this.sound);
    }

    public void walk(String person) {
        System.out.println(person + " walks " + this.name);
    }

    public void walk(String[] people) {
        for (String person : people) {
            System.out.print(person + " ");
        }
        System.out.println("walk" + this.name);
    }

    public void walk(String person, float minuets) {
        System.out.println(person + " walks " + this.name + " for " + minuets + " minutes");
    }
}
