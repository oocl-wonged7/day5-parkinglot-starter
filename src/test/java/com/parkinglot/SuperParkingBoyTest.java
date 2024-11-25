package com.parkinglot;

import com.parkinglot.strategy.SuperParkingStrategy;
import org.junit.jupiter.api.Test;

public class SuperParkingBoyTest {
    @Test
    void should_park_to_parking_lot_with_higher_available_position_rate_when_park_given_2_parking_lot_with_different_position_left() {
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot", 22);
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot", 20);
        ParkingBoy superParkingBoy = new ParkingBoy(new SuperParkingStrategy());
        superParkingBoy.addParkingLot(firstParkingLot);
        superParkingBoy.addParkingLot(secondParkingLot);
        firstParkingLot.park(new Car());
        Car car = new Car();

        // When
        Ticket ticket = superParkingBoy.park(car);

        // Then
        assert (secondParkingLot.getName().equals(ticket.getIssuedBy()));
    }

    @Test
    void should_park_to_parking_lot_added_first_when_park_given_2_parking_lot_with_same_available_position_rate() {
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot", 20);
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot", 20);
        ParkingBoy superParkingBoy = new ParkingBoy(new SuperParkingStrategy());
        superParkingBoy.addParkingLot(firstParkingLot);
        superParkingBoy.addParkingLot(secondParkingLot);
        Car car = new Car();

        // When
        Ticket ticket = superParkingBoy.park(car);

        // Then
        assert (firstParkingLot.getName().equals(ticket.getIssuedBy()));
    }
}
