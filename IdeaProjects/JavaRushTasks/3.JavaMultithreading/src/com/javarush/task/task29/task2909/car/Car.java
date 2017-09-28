package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    public Car(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
        if (type == 0)
            return new Truck(numberOfPassengers);
        if (type == 1)
            return new Sedan(numberOfPassengers);
        if (type == 2)
            return new Cabriolet(numberOfPassengers);
        return null;
    }

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {
        if (date.getTime() > summerStart.getTime() && date.getTime() < summerEnd.getTime()) {
            return true;
        }
        return false;
    }

    private boolean canPassengersBeTransferred() {
        if (isDriverAvailable() && fuel > 0)
            return true;
        return false;
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }
    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }


    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        /*double consumption;
        if (date.before(SummerStart) || date.after(SummerEnd)) {
            consumption = length * winterFuelConsumption + winterWarmingUp;
        } else {
            consumption = length * summerFuelConsumption;
        }*/
        if (isSummer(date, SummerStart, SummerEnd)) {
            return getSummerConsumption(length);
        } else
            return getWinterConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred())
            return numberOfPassengers;
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}