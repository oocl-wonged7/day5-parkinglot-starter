package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_a_car(){
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        Car car = new Car();

        // When
        Ticket ticket = parkingLot.park(car);

        // Then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_a_ticket(){
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        // When
        Car carFetched = parkingLot.fetch(ticket);

        // Then
        assert(carFetched.equals(car));
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_two_ticket(){
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        Car firstCar = new Car();
        Ticket firstTicket = parkingLot.park(firstCar);
        Car secondCar = new Car();
        Ticket secondTicket = parkingLot.park(secondCar);

        // When
        Car carFatchedFirst = parkingLot.fetch(firstTicket);
        Car carFatchedSecond = parkingLot.fetch(secondTicket);

        // Then
        assert (carFatchedFirst.equals(firstCar));
        assert (carFatchedSecond.equals(secondCar));
    }

    @Test
    void should_return_error_when_fetch_car_given_wrong_ticket(){
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Ticket wrongTicket = new Ticket("another Parking Lot");

        // When
        Car carFetched = parkingLot.fetch(wrongTicket);

        // Then
        assertNull(carFetched);
    }

}
