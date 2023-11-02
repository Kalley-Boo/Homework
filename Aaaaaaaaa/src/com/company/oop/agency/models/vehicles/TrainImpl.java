package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.contracts.Printable;
import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleImpl implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(VehicleType.LAND, passengerCapacity, pricePerKilometer, id);
        setCarts(carts);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity){
        if(passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE){
            throw new IllegalArgumentException("A train cannot have less than 30 passengers or more than 150 passenger.");
        }
    }//validatePassengerCapacity

    private void validateCarts(int carts){
        if(carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE){
            throw new IllegalArgumentException("A train cannot have less than 1 cart or more than 15 carts.");
        }
    }//validateCarts

    protected void validatePricePerKilometer(double pricePerKilometer){
        if(pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE){
            throw new IllegalArgumentException("A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist.");
        }
    }//validatePricePerKilometer

    public int getCarts(){
        return carts;
    }

    private void setCarts(int carts){
        validateCarts(carts);
        this.carts = carts;
    }

    public String getAsString(){
        return String.format("Train ----%n%sCarts ammount: %s", super.print(), carts);
    }
}