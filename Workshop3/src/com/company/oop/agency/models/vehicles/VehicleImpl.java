package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;

abstract class VehicleImpl implements Vehicle {
    protected int id;
    protected int passengerCapacity;
    protected double pricePerKilometer;
    protected VehicleType type;

    public VehicleImpl(int id, int passengerCapacity, double pricePerKilometer, VehicleType type) {
        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.pricePerKilometer = pricePerKilometer;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    public String toString() {
        return String.format("Vehicle ID: %d%n%s ----%nPassenger capacity: %d%nPrice per kilometer: %.2f%nVehicle type: %s",
                getId(), getType(), getPassengerCapacity(), getPricePerKilometer(), getType());
    }

}
