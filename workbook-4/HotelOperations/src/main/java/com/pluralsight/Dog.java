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
        System.out.println(name + " says " + sound);
    }

    public void walk(String person) {
        System.out.println(person + " walks " + name);
    }
}
