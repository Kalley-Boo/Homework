package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public class JourneyImpl implements Journey {
    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;
    private String startLocation;
    private String destination;
    private int distance;
    private Vehicle vehicle;
    private int id;

    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        setId(id);
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        setVehicle(vehicle);
    }

    private void setId(int id) {
        this.id = id;
    }
    private void setStartLocation(String startLocation) {
        if (startLocation.length() < START_LOCATION_MIN_LENGTH || startLocation.length() > START_LOCATION_MAX_LENGTH) {
            throw new IllegalArgumentException("The Starting Location's length cannot be less than 5 or more than 25 symbols long.");
        }
        this.startLocation = startLocation;
    }
    private void setDestination(String destination) {
        if (destination.length() < DESTINATION_MIN_LENGTH || destination.length() > DESTINATION_MAX_LENGTH) {
            throw new IllegalArgumentException("The Destination's length cannot be less than 5 or more than 25 symbols long.");
        }
        this.destination = destination;
    }
    private void setDistance(int distance) {
        if (distance < DISTANCE_MIN_VALUE || distance > DISTANCE_MAX_VALUE) {
            throw new IllegalArgumentException("The Distance cannot be less than 5 or more than 5000 kilometers.");
        }
        this.distance = distance;
    }
    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public double calculateTravelCosts() {
        return distance * vehicle.getPricePerKilometer();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return "Journey ----\n" +
                "Start location: " + startLocation + "\n" +
                "Destination: " + destination + "\n" +
                "Distance: " + distance + " km\n" +
                "Vehicle type: " + vehicle.getType() + "\n" +
                "Travel costs: " + calculateTravelCosts();
    }
}