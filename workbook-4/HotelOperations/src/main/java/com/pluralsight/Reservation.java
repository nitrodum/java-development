package com.pluralsight;

public class Reservation {
    String roomType;
    int numberOfNights;
    boolean weekend;

    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        setRoomType(roomType);
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;

    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        if (roomType.equalsIgnoreCase("king") || roomType.equalsIgnoreCase("double")) {
            this.roomType = roomType;
        } else {
            throw new IllegalArgumentException("Room type must be King or Double.");
        }
    }

    public float getPrice() {
        float price = 0f;
        if(this.roomType.equalsIgnoreCase("king")) {
            price = 139;
        } else if (this.roomType.equalsIgnoreCase("double")) {
            price = 123;
        }

        if (this.weekend) {
            price *= 1.1f;
        }
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public float getReservationTotal() {
        return getPrice() * numberOfNights;
    }

}
