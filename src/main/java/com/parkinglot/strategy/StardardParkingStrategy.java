package com.parkinglot.strategy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;
import com.parkinglot.exception.NoAvailablePositionException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StardardParkingStrategy implements ParkingStrategy {
    @Override
    public Ticket park(Car car, Map<String, ParkingLot> parkingLots) {
        List<ParkingLot> parkingLotList = new ArrayList<>(parkingLots.values());
        Collections.reverse(parkingLotList);
        return parkingLotList.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(NoAvailablePositionException::new)
                .park(car);
    }
}
