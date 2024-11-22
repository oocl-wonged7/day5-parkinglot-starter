package com.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy() {
        super();
    }

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public Ticket park(Car car) {
        ParkingLot parkingLotWithMostPosition = parkingLots.values().stream()
                .max(Comparator.comparingInt(ParkingLot::getPosition))
                .orElseThrow(NoAvailablePositionException::new);

        return parkingLotWithMostPosition.park(car);
    }
}
