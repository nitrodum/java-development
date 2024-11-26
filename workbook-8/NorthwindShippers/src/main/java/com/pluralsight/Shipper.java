package com.pluralsight;

public class Shipper {
    private int shipperID;
    private String companyName;
    private String phone;

    public Shipper(int shipperID, String companyName, String phone) {
        this.shipperID = shipperID;
        this.companyName = companyName;
        this.phone = phone;
    }

    public Shipper(String companyName, String phone) {
        this.companyName = companyName;
        this.phone = phone;
    }

    public int getShipperID() {
        return shipperID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-7s", shipperID, companyName, phone);
    }

}
