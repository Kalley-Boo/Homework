package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

import java.util.Locale;

public class TicketImpl implements Ticket {
    private int id;
    private Journey journey;
    private double administrativeCosts;

    public TicketImpl(int id, Journey journey, double administrativeCosts) {
        setId(id);
        setJourney(journey);
        setAdministrativeCosts(administrativeCosts);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return administrativeCosts * journey.calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    @Override
    public String getAsString() {
        return "Ticket ----\n" +
                "Destination: " + journey.getDestination() + "\n" +
                "Price: " + calculatePrice();
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setJourney(Journey journey) {
        this.journey = journey;
    }

    private void setAdministrativeCosts(double administrativeCosts) {
        if (administrativeCosts < 0){
            throw new InvalidUserInputException(String.format(Locale.US,"Value of 'costs' must be a positive number. Actual value: %.2f.", administrativeCosts));
        }
        this.administrativeCosts = administrativeCosts;
    }
}


