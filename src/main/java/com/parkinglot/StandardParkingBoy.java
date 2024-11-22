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
        return parkingLotList.stream()
                .filter(parkingLot -> parkingLot.getCurrentCapacity() < parkingLot.getCapacity())
                .findFirst()
                .orElseThrow(NoAvailablePositionException::new)
                .park(car);
    }
}
