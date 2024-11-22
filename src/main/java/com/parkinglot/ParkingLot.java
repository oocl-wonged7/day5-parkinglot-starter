package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkingRecord = new HashMap<Ticket, Car>();
    private String name;

    ParkingLot(String name) {
        this.name = name;
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket(name);
        parkingRecord.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if (ticket.getIssuedBy() != this.name) {
            return null;
        } else {
            Car car = parkingRecord.get(ticket);
            return car;
        }
    }
}
