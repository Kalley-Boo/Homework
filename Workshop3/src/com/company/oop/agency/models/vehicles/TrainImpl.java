package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleImpl implements Train {
    private int carts;
    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        validatePassengerCapacity(passengerCapacity);
        validatePricePerKilometer(pricePerKilometer);
        validateCarts(carts);
        this.carts = carts;
    }//Constructor

    //----------------------------------functions---------------------------------------
    private void validatePassengerCapacity(int passengerCapacity){
        if(passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE){
            throw new IllegalArgumentException("A train cannot have less than 30 passengers or more than 150 passenger.");
        }
    }//validatePassengerCapacity

    private void validateCarts(int carts){
        if(carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE){
            throw new IllegalArgumentException("A train cannot have less than 1 cart or more than 15 carts.");
        }
    }//validateCarts

    private void validatePricePerKilometer(double pricePerKilometer){
        if(pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE){
            throw new IllegalArgumentException("A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist.");
        }
    }

    //-------------------------------setters and getters------------------------------
    @Override
    public int getCarts() {
        return carts;
    }
}