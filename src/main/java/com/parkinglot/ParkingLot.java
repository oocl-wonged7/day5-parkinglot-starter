package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;
    public static final String UNRECOGNIZED_PARKING_TICKET_MESSAGE = "Unrecognized parking ticket.";
    public static final String NO_AVAILABLE_POSITION_MESSAGE = "No available position.";

    private Map<Ticket, Car> parkingRecord = new HashMap<Ticket, Car>();
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

    public Ticket park(Car car) throws Exception {
        if (parkingRecord.size() >= capacity) {
            throw new Exception(NO_AVAILABLE_POSITION_MESSAGE);
        }
        Ticket ticket = new Ticket(name);
        parkingRecord.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) throws Exception {
        if (ticket.getIssuedBy() != this.name || ticket.isUsed()) {
            throw new Exception(UNRECOGNIZED_PARKING_TICKET_MESSAGE);
        }
        ticket.setIsUsed();
        return parkingRecord.remove(ticket);
    }
}
