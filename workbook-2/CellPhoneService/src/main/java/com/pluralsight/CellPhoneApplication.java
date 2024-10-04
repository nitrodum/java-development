package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        CellPhone phone1 = createPhone();
        CellPhone phone2 = createPhone();

        display(phone1);
        display(phone2);

        phone1.dial(phone2.getPhoneNumber());
        phone2.dial(phone1.getPhoneNumber());

        scanner.close();
    }

    static String input(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    static CellPhone createPhone() {
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

        return phone;
    }

    static void display(CellPhone phone) {
        System.out.println("Displaying phone details:");
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner());
        System.out.println();
    }

}
