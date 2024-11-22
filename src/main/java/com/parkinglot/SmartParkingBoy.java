package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy() {
        super();
    }

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public Ticket park(Car car) {
        ParkingLot parkingLotWithMostPosition = parkingLots.values().stream()
                .max(Comparator.comparingInt(ParkingLot::getPosition)
                        .thenComparing(parkingLot -> new ArrayList<>(parkingLots.values()).indexOf(parkingLot)))
                .orElseThrow(NoAvailablePositionException::new);

        return parkingLotWithMostPosition.park(car);
    }
}
