package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_a_car_and_a_parking_lot() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        // When
        Ticket ticket = parkingBoy.park(car);

        // Then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_a_ticket_and_a_parking_lot() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        // When
        Car carFetched = parkingBoy.fetch(ticket);

        // Then
        assert(carFetched.equals(car));
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_two_ticket_and_a_parking_lot() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car firstCar = new Car();
        Ticket firstTicket = parkingBoy.park(firstCar);
        Car secondCar = new Car();
        Ticket secondTicket = parkingBoy.park(secondCar);

        // When
        Car carFatchedFirst = parkingBoy.fetch(firstTicket);
        Car carFatchedSecond = parkingBoy.fetch(secondTicket);

        // Then
        assert (carFatchedFirst.equals(firstCar));
        assert (carFatchedSecond.equals(secondCar));
    }

    @Test
    void should_print_error_message_when_fetch_given_a_wrong_ticket_and_a_parking_lot() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        parkingLot.park(car);
        Ticket wrongTicket = new Ticket("another Parking Lot");

        // When
        Exception exception = assertThrows(Exception.class, () -> parkingBoy.fetch(wrongTicket));

        // Then
        String expectedMessage = "Unrecognized parking ticket.";
        String exceptionMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(exceptionMessage));
    }

    @Test
    void should_return_error_message_when_fetch_given_a_used_ticket_and_a_parking_lot() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);

        // When
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(ticket));

        // Then
        String expectedMessage = "Unrecognized parking ticket.";
        String exceptionMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(exceptionMessage));
    }

    @Test
    void should_return_error_message_when_park_given_a_parking_lot_and_no_position_left_() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for (int i = 0; i < parkingLot.getCapacity(); i++){
            Car car = new Car();
            parkingBoy.park(car);
        }
        Car anotherCar = new Car();

        // When
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingBoy.park(anotherCar));

        // Then
        String expectedMessage = "No available position.";
        String exceptionMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(exceptionMessage));
    }
}
