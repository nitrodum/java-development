package com.pluralsight;

public class Room {
    int numberOfBeds;
    float price;
    boolean occupied;
    boolean dirty;

    public Room(int numberOfBeds, float price) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
    }

    public void checkIn() {
        this.occupied = true;
        this.dirty = true;
    }

    public void checkOut() {
        this.occupied = false;
    }

    public void cleanRoom() {
        this.dirty = false;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public float getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public boolean isAvailable() {
        return !this.occupied && !this.dirty;
    }
}
