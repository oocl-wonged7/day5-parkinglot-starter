package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkingRecord = new HashMap<Ticket, Car>();

    public Ticket park(Car car){
        Ticket ticket = new Ticket();
        parkingRecord.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket){
        Car car = parkingRecord.get(ticket);
        return car;
    }
}
