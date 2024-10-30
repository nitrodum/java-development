package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<Asset>();
        House house1 = new House("Home", "09/20/2019", 500000, "123 Street", 2, 20000, 20000);
        House house2 = new House("Vacation", "10/10/2023", 1000000, "Bahamas", 1, 100000, 1000000);
        Vehicle car1 = new Vehicle("Daily", "01/12/2012", 30000, "Toyota Corolla", 2012, 1000000);
        Vehicle car2 = new Vehicle("Sport Car", "01/04/2024", 100000, "Nissan GTR", 2024, 1000);

        assets.add(house1);
        assets.add(house2);
        assets.add(car1);
        assets.add(car2);

        for (Asset asset : assets) {
            if (asset instanceof House house) {
                System.out.println("Address: " + house.getAddress() + " Value: " + house.getValue());
            } else if (asset instanceof  Vehicle vehicle) {
                System.out.println("Vehicle: " + vehicle.getMakeModel() + " Value: " + vehicle.getValue());
            }
        }
    }
}