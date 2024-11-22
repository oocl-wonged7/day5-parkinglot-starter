package com.parkinglot;

import java.util.*;

public abstract class ParkingBoy {
    protected ParkingLot parkingLot;
    protected Map<String, ParkingLot> parkingLots;

    public ParkingBoy() {
        this.parkingLots = new HashMap<>();
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.parkingLots = new HashMap<>();
        parkingLots.put(parkingLot.getName(), parkingLot);
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.put(parkingLot.getName(), parkingLot);
    }

    public abstract Ticket park(Car car);

    public Car fetch(Ticket ticket) {
        if (!parkingLots.containsKey(ticket.getIssuedBy())) {
            throw new UnrecognizedParkingTicketException();
        }
        ParkingLot parkingLot = parkingLots.get(ticket.getIssuedBy());
        return parkingLot.fetch(ticket);
    }
}
