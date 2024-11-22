package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;

    private Map<Ticket, Car> parkingRecord = new HashMap<>();
    private String name;
    private int capacity;

    ParkingLot(String name) {
        this.name = name;
        this.capacity = DEFAULT_CAPACITY;
    }

    ParkingLot(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if (parkingRecord.size() >= capacity) {
            throw new NoAvailablePositionException();
        }
        Ticket ticket = new Ticket(name);
        parkingRecord.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if (ticket.getIssuedBy() != this.name || ticket.isUsed()) {
            throw new UnrecognizedParkingTicketException();
        }
        ticket.setIsUsed();
        return parkingRecord.remove(ticket);
    }
}
