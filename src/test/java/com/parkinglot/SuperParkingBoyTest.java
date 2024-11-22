package com.parkinglot;

import org.junit.jupiter.api.Test;

public class SuperParkingBoyTest {
    @Test
    void should_park_to_parking_lot_with_higher_available_position_rate_when_park_given_2_parking_lot_with_different_position_left() {
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot", 22);
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot", 20);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        superParkingBoy.addParkingLot(firstParkingLot);
        superParkingBoy.addParkingLot(secondParkingLot);
        firstParkingLot.park(new Car());
        Car car = new Car();

        // When
        Ticket ticket = superParkingBoy.park(car);

        // Then
        assert (secondParkingLot.getName().equals(ticket.getIssuedBy()));
    }
}
