package com.parkinglot.strategy;

import com.parkinglot.*;
import com.parkinglot.exception.NoAvailablePositionException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class SmartParkingStrategy implements ParkingStrategy {
    @Override
    public Ticket park(Car car, Map<String, ParkingLot> parkingLots) {
        ParkingLot parkingLotWithMostPosition = parkingLots.values().stream()
                .max(Comparator.comparingInt(ParkingLot::getPosition)
                        .thenComparing(parkingLot -> new ArrayList<>(parkingLots.values()).indexOf(parkingLot)))
                .orElseThrow(NoAvailablePositionException::new);

        return parkingLotWithMostPosition.park(car);
    }
}
