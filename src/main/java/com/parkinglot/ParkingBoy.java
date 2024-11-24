package com.parkinglot;

import com.parkinglot.strategy.ParkingStrategy;
import com.parkinglot.strategy.StardardParkingStrategy;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {
    private final Map<String, ParkingLot> parkingLots;
    private ParkingStrategy parkingStrategy = new StardardParkingStrategy();

    public ParkingBoy() {
        this.parkingLots = new HashMap<>();
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = new HashMap<>();
        parkingLots.put(parkingLot.getName(), parkingLot);
    }

    public ParkingBoy(ParkingStrategy parkingStrategy) {
        this.parkingLots = new HashMap<>();
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingBoy(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        this.parkingLots = new HashMap<>();
        parkingLots.put(parkingLot.getName(), parkingLot);
        this.parkingStrategy = parkingStrategy;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.put(parkingLot.getName(), parkingLot);
    }

    public Ticket park(Car car) {
        return parkingStrategy.park(car, parkingLots);
    }

    public Car fetch(Ticket ticket) {
        if (!parkingLots.containsKey(ticket.getIssuedBy())) {
            throw new UnrecognizedParkingTicketException();
        }
        ParkingLot parkingLot = parkingLots.get(ticket.getIssuedBy());
        return parkingLot.fetch(ticket);
    }
}
