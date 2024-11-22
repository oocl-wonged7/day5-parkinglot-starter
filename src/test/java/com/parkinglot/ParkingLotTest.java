package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_a_car(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        // When
        Ticket ticket = parkingLot.park(car);

        // Then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_a_ticket(){
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        // When
        Car carFetched = parkingLot.fetch(ticket);

        // Then
        assert(carFetched.equals(car));
    }

}
