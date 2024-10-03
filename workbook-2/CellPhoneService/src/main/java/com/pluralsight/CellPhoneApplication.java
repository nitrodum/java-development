package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int serialNumber = Integer.parseInt(input("What is the serial number?"));
        String model = input("What model is the phone?");
        String carrier = input("Who is the carrier?");
        String phoneNumber = input("What is the phone number?");
        String owner = input("Who is the owner of the phone?");

        CellPhone phone = new CellPhone();

        phone.setSerialNumber(serialNumber);
        phone.setModel(model);
        phone.setCarrier(carrier);
        phone.setPhoneNumber(phoneNumber);
        phone.setOwner(owner);

        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner());
        scanner.close();
    }

    static String input(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

}
