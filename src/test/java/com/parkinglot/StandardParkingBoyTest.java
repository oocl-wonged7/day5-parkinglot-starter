package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_a_car_and_a_parking_lot() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        // When
        Ticket ticket = standardParkingBoy.park(car);

        // Then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_a_ticket_and_a_parking_lot() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        // When
        Car carFetched = standardParkingBoy.fetch(ticket);

        // Then
        assert(carFetched.equals(car));
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_two_ticket_and_a_parking_lot() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car firstCar = new Car();
        Ticket firstTicket = standardParkingBoy.park(firstCar);
        Car secondCar = new Car();
        Ticket secondTicket = standardParkingBoy.park(secondCar);

        // When
        Car carFatchedFirst = standardParkingBoy.fetch(firstTicket);
        Car carFatchedSecond = standardParkingBoy.fetch(secondTicket);

        // Then
        assert (carFatchedFirst.equals(firstCar));
        assert (carFatchedSecond.equals(secondCar));
    }

    @Test
    void should_print_error_message_when_fetch_given_a_wrong_ticket_and_a_parking_lot() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        standardParkingBoy.park(car);
        Ticket wrongTicket = new Ticket("another Parking Lot");

        // When
        Exception exception = assertThrows(Exception.class, () -> standardParkingBoy.fetch(wrongTicket));

        // Then
        String expectedMessage = "Unrecognized parking ticket.";
        String exceptionMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(exceptionMessage));
    }

    @Test
    void should_return_error_message_when_fetch_given_a_used_ticket_and_a_parking_lot() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = standardParkingBoy.park(car);
        standardParkingBoy.fetch(ticket);

        // When
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(ticket));

        // Then
        String expectedMessage = "Unrecognized parking ticket.";
        String exceptionMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(exceptionMessage));
    }

    @Test
    void should_return_error_message_when_park_given_a_parking_lot_and_no_position_left_() {
        // Given
        ParkingLot parkingLot = new ParkingLot("Good Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        for (int i = 0; i < parkingLot.getCapacity(); i++){
            Car car = new Car();
            parkingLot.park(car);
        }
        Car anotherCar = new Car();

        // When
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> standardParkingBoy.park(anotherCar));

        // Then
        String expectedMessage = "No available position.";
        String exceptionMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(exceptionMessage));
    }
}
