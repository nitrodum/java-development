package com.pluralsight;

public class Actor {
    private int actorID;
    private String firstName;
    private String lastName;

    public Actor(int actorID, String firstName, String lastName) {
        this.actorID = actorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-20s%-20s", actorID, firstName, lastName);
    }
}
