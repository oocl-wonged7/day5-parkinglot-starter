package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.LinkedHashMap;
import java.util.Map;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;

    private final Map<Ticket, Car> parkingRecord = new LinkedHashMap<>();
    private final String name;
    private final int capacity;

    ParkingLot(String name) {
        this.name = name;
        this.capacity = DEFAULT_CAPACITY;
    }

    ParkingLot(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
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
        if (ticket.getIssuedBy().equals(this.name) || ticket.isUsed()) {
            throw new UnrecognizedParkingTicketException();
        }
        ticket.setIsUsed();
        return parkingRecord.remove(ticket);
    }

    public int getPosition() {
        return this.capacity - parkingRecord.size();
    }

    public double getPositionRate() {
        return (double) this.getPosition() / this.capacity;
    }

    public boolean isFull() {
        return parkingRecord.size() >= capacity;
    }
}
