package com.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_a_car() throws Exception {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        Car car = new Car();

        // When
        Ticket ticket = parkingLot.park(car);

        // Then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_a_ticket() throws Exception {
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
    void should_return_right_car_when_fetch_twice_given_two_ticket() throws Exception {
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
    void should_print_error_message_when_fetch_given_a_wrong_ticket() throws Exception {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        Car car = new Car();
        parkingLot.park(car);
        Ticket wrongTicket = new Ticket("another Parking Lot");

        // When
        Exception exception = assertThrows(Exception.class, () -> parkingLot.fetch(wrongTicket));

        // Then
        String expectedMessage = "Unrecognized parking ticket.";
        String exceptionMessage = exception.getMessage();
        assertTrue(exceptionMessage.contains(expectedMessage));
    }

    @Test
    void should_return_error_message_when_fetch_given_a_used_ticket() throws Exception {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);

        // When
        Exception exception = assertThrows(Exception.class, () -> parkingLot.fetch(ticket));

        // Then
        String expectedMessage = "Unrecognized parking ticket.";
        String exceptionMessage = exception.getMessage();
        assertTrue(exceptionMessage.contains(expectedMessage));
    }

    @Test
    void should_return_error_message_when_park_given_no_space_left() throws Exception {
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
        Exception exception = assertThrows(Exception.class, () -> parkingLot.park(car11));

        // Then
        String expectedMessage = "No available position.";
        String exceptionMessage = exception.getMessage();
        assertTrue(exceptionMessage.contains(expectedMessage));
    }
}
