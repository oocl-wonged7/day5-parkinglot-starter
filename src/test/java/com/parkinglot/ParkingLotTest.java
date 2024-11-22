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
    void should_return_null_when_fetch_car_given_wrong_ticket(){
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        Car car = new Car();
        parkingLot.park(car);
        Ticket wrongTicket = new Ticket("another Parking Lot");

        // When
        Car carFetched = parkingLot.fetch(wrongTicket);

        // Then
        assertNull(carFetched);
    }

    @Test
    void should_return_null_when_fetch_given_a_used_ticket(){
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);

        // When
        Car carFetchedWithUsedTicket = parkingLot.fetch(ticket);

        // Then
        assertNull(carFetchedWithUsedTicket);
    }

    @Test
    void should_return_null_when_park_given_no_space_left(){
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        Car car1 = new Car();
        parkingLot.park(car1);
        Car car2 = new Car();
        parkingLot.park(car2);
        Car car3 = new Car();
        parkingLot.park(car3);
        Car car4 = new Car();
        parkingLot.park(car4);
        Car car5 = new Car();
        parkingLot.park(car5);
        Car car6 = new Car();
        parkingLot.park(car6);
        Car car7 = new Car();
        parkingLot.park(car7);
        Car car8 = new Car();
        parkingLot.park(car8);
        Car car9 = new Car();
        parkingLot.park(car9);
        Car car10 = new Car();
        parkingLot.park(car10);
        Car car11 = new Car();

        // When
        Ticket ticket = parkingLot.park(car11);

        // Then
        assertNull(ticket);
    }

}
