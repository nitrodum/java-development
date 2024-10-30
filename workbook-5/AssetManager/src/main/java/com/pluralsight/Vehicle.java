package com.pluralsight;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        double value = getOriginalCost();

        for (int i = 0; i < this.year; i++) {
            if (i < 3) {
                value *= .97;
            } else if (i < 6) {
                value *= .94;
            } else if (i < 10) {
                value *= .92;
            } else {
                value = 1000;
            }

        }

        if (this.odometer > 100000 && !makeModel.contains("Honda") &&
                !makeModel.contains("Toyota")) {
            value *= .75;
        }

        return value;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
