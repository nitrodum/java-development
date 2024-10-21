package com.pluralsight;

public class Reservation {
    private final float KING_RATE = 139f;
    private final float DOUBLE_RATE = 123f;
    private final float WEEKENDRATE = 1.1f;
    private String roomType;
    private int numberOfNights;
    private boolean weekend;

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
            price = KING_RATE;
        } else {
            price = DOUBLE_RATE;
        }

        if (this.weekend) {
            price *= WEEKENDRATE;
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
