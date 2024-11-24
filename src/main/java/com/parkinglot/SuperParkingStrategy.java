package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class SuperParkingStrategy implements ParkingStrategy {
    @Override
    public Ticket park(Car car, Map<String, ParkingLot> parkingLots) {
        ParkingLot parkingLotWithHighestPositionRate = parkingLots.values().stream()
                .max(Comparator.comparingDouble(ParkingLot::getPositionRate)
                        .thenComparing(parkingLot -> new ArrayList<>(parkingLots.values()).indexOf(parkingLot)))
                .orElseThrow(NoAvailablePositionException::new);

        return parkingLotWithHighestPositionRate.park(car);
    }
}
