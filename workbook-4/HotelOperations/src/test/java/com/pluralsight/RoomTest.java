package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void checkIn_isOccupied_True() {
        Room test = new Room(2, 100);

        test.checkIn();

        assertTrue(test.isOccupied());
    }

    @Test
    void checkIn_isDirty_True() {
        Room test = new Room(2, 100);

        test.checkIn();

        assertTrue(test.isDirty());
    }

    @Test
    void checkIn_doesNotAllowToCheckIntoDirtyRoom() {
        Room test = new Room(2, 100);
        test.checkIn();
        test.checkOut();
        test.checkIn();

        assertFalse(test.isOccupied());
    }

    @Test
    void checkOut_isOccupied_False() {
        Room test = new Room(2, 100);

        test.checkOut();

        assertFalse(test.isOccupied());
    }

    @Test
    void checkOut_isDirty_True() {
        Room test = new Room(2, 100);
        test.checkIn();

        test.checkOut();

        assertTrue(test.isDirty());
    }

    @Test
    void cleanRoom_isDirty_False() {
        Room test = new Room(2, 100);
        test.checkIn();
        test.checkOut();
        test.cleanRoom();

        assertFalse(test.isDirty());
    }

    @Test
    void cleanRoom_doesNotAllowToCleanOccupiedRoom() {
        Room test = new Room(2, 100);
        test.checkIn();
        test.cleanRoom();

        assertTrue(test.isDirty());
    }
}