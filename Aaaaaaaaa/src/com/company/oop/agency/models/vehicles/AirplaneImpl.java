package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleImpl implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(VehicleType.AIR,  passengerCapacity, pricePerKilometer, id);
        setHasFreeFood(hasFreeFood);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity){
        if(passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE){
            throw new IllegalArgumentException("A train cannot have less than 30 passengers or more than 150 passenger.");
        }
    }//validatePassengerCapacity

    protected void validatePricePerKilometer(double pricePerKilometer){
        if(pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE){
            throw new IllegalArgumentException("A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist.");
        }
    }

    private void setHasFreeFood(boolean hasFreeFood){
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    public String getAsString(){
        return String.format("Airplane ----%n%sHas Free Food: %b", super.print(), hasFreeFood);
    }
}