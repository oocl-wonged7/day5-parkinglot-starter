package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;

public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy() {
        super();
    }

    public SuperParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public Ticket park(Car car) {
        ParkingLot parkingLotWithHighestRate = parkingLots.values().stream()
                .max(Comparator.comparingDouble(parkingLot -> (double) ((ParkingLot) parkingLot).getPosition() / ((ParkingLot) parkingLot).getCapacity())
                        .thenComparing(parkingLot -> new ArrayList<>(parkingLots.values()).indexOf(parkingLot)))
                .orElseThrow(NoAvailablePositionException::new);

        return parkingLotWithHighestRate.park(car);
    }
}
