package com.parkinglot;

import com.parkinglot.strategy.SmartParkingStrategy;
import org.junit.jupiter.api.Test;

public class SmartParkingBoyTest {
    @Test
    void should_park_to_parking_lot_with_more_position_when_park_given_2_parking_lot_with_different_position_left() {
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot", 1);
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot", 20);
        ParkingBoy smartParkingBoy = new ParkingBoy(new SmartParkingStrategy());
        smartParkingBoy.addParkingLot(firstParkingLot);
        smartParkingBoy.addParkingLot(secondParkingLot);
        Car car = new Car();

        // When
        Ticket ticket = smartParkingBoy.park(car);

        // Then
        assert (secondParkingLot.getName().equals(ticket.getIssuedBy()));
    }

    @Test
    void should_park_to_parking_lot_added_first_when_park_given_2_parking_lot_with_same_position_left() {
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot", 20);
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot", 20);
        ParkingBoy smartParkingBoy = new ParkingBoy(new SmartParkingStrategy());
        smartParkingBoy.addParkingLot(firstParkingLot);
        smartParkingBoy.addParkingLot(secondParkingLot);
        Car car = new Car();

        // When
        Ticket ticket = smartParkingBoy.park(car);

        // Then
        assert (firstParkingLot.getName().equals(ticket.getIssuedBy()));
    }
}
