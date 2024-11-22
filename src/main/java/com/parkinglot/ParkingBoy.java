package com.parkinglot;

import java.util.*;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private Map<String, ParkingLot> parkingLots;

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

    public Ticket park(Car car) {
        List<ParkingLot> parkingLotList = new ArrayList<>(parkingLots.values());
        Collections.reverse(parkingLotList);
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getCurrentCapacity() < parkingLot.getCapacity()) {
                return parkingLot.park(car);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

    public Car fetch(Ticket ticket) {
        ParkingLot parkingLot = parkingLots.get(ticket.getIssuedBy());
        return parkingLot.fetch(ticket);
    }
}
