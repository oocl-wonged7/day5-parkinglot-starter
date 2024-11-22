package com.parkinglot;

import java.util.*;

public class StandardParkingBoy extends ParkingBoy {
    public StandardParkingBoy() {
        super();
    }

    public StandardParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public Ticket park(Car car) {
        List<ParkingLot> parkingLotList = new ArrayList<>(parkingLots.values());
        Collections.reverse(parkingLotList);
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getCurrentCapacity() < parkingLot.getCapacity()) {
                return parkingLot.park(car);
            }
        }
        throw new NoAvailablePositionException();
    }
}
