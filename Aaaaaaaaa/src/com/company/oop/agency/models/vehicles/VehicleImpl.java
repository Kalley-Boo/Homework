package com.company.oop.agency.models.vehicles;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

    public abstract class VehicleImpl implements Vehicle {
    private VehicleType type;
    private int passengerCapacity;
    private double pricePerKilometer;
    private int id;

    public VehicleImpl(VehicleType type, int passengerCapacity, double pricePerKilometer, int id){
        setId(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        this.type = type;
    }

    protected abstract void validatePassengerCapacity(int passengerCapacity);
    protected abstract void validatePricePerKilometer(double pricePerKilometer);

    private void setPassengerCapacity(int passengerCapacity){
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }
    private void setPricePerKilometer(double pricePerKilometer){
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }
    private void setId(int id){
        this.id = id;
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

    @Override
    public int getId() {
        return id;
    }

    public String print() {
        return String.format(
                "Passenger capacity: $d%nPrice per kilometer: %.2f%nVehicle type: %s%n",
                passengerCapacity,
                pricePerKilometer,
                type
        );
    }
}
