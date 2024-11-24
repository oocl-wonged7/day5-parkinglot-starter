package com.parkinglot;

import java.util.Map;

public interface ParkingStrategy {
    Ticket park(Car car, Map<String, ParkingLot> parkingLots);
}
