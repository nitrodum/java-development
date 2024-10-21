package com.pluralsight;

public class Reservation {
    String roomType;
    float price;
    int numberOfNights;
    boolean weekend;

    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;

        if(this.roomType.equalsIgnoreCase("king")) {
            this.price = 139;
        } else if (this.roomType.equalsIgnoreCase("double")) {
            this.price = 123;
        }

        if (this.weekend) {
            this.price *= 1.1f;
        }
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public float getReservationTotal() {
        return price * numberOfNights;
    }

}
