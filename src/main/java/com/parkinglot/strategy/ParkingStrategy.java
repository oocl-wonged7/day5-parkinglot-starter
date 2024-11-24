package com.parkinglot.strategy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;

import java.util.Map;

public interface ParkingStrategy {
    Ticket park(Car car, Map<String, ParkingLot> parkingLots);
}
