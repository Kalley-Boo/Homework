package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleImpl implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(VehicleType.LAND, passengerCapacity, pricePerKilometer, id);
    }

    protected void validatePassengerCapacity(int passengerCapacity){
        if(passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE){
            throw new IllegalArgumentException("A train cannot have less than 30 passengers or more than 150 passenger.");
        }
    }//validatePassengerCapacity

    protected void validatePricePerKilometer(double pricePerKilometer){
        if(pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE){
            throw new IllegalArgumentException("A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist.");
        }
    }//validatePricePerKilometer

    public String getAsString(){
        return String.format("Bus ----%n%s", super.print());
    }
}