package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultipleParkingLotsTest {
    @Test
    void should_park_to_parking_lot_1_when_park_given_both_parking_lot_have_position(){
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot");
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        standardParkingBoy.addParkingLot(firstParkingLot);
        standardParkingBoy.addParkingLot(secondParkingLot);
        Car car = new Car();

        // When
        Ticket ticket = standardParkingBoy.park(car);

        // Then
        assert(ticket.getIssuedBy().equals(firstParkingLot.getName()));
    }

    @Test
    void should_park_to_parking_log_2_when_park_given_parking_lot_1_is_full(){
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot");
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        standardParkingBoy.addParkingLot(firstParkingLot);
        standardParkingBoy.addParkingLot(secondParkingLot);
        for (int i = 0; i < firstParkingLot.getCapacity(); i++){
            Car car = new Car();
            standardParkingBoy.park(car);
        }
        Car anotherCar = new Car();

        // When
        Ticket ticket = standardParkingBoy.park(anotherCar);

        // Then
        assert(ticket.getIssuedBy().equals(secondParkingLot.getName()));
    }

    @Test
    void should_fetch_2_car_in_correct_order_when_fetch_twice_given_fetch_from_both_parking_lot(){
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot");
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        standardParkingBoy.addParkingLot(firstParkingLot);
        standardParkingBoy.addParkingLot(secondParkingLot);
        for (int i = 0; i < firstParkingLot.getCapacity() - 1; i++){
            Car car = new Car();
            standardParkingBoy.park(car);
        }
        Car firstCar = new Car();
        Ticket firstTicket = standardParkingBoy.park(firstCar);
        Car secondCar = new Car();
        Ticket secnodTicket = standardParkingBoy.park(secondCar);

        // When
        Car firstCarFetched = standardParkingBoy.fetch(firstTicket);
        Car secondCarFetched = standardParkingBoy.fetch(secnodTicket);

        // Then
        assert(firstCar.equals(firstCarFetched));
        assert(secondCar.equals(secondCarFetched));
    }

    @Test
    void should_print_error_message_when_fetch_given_a_wrong_ticket_and_a_parking_lot() {
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot");
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        standardParkingBoy.addParkingLot(firstParkingLot);
        standardParkingBoy.addParkingLot(secondParkingLot);
        Car car = new Car();
        standardParkingBoy.park(car);
        Ticket wrongTicket = new Ticket("Third Parking Lot");

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
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot");
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        standardParkingBoy.addParkingLot(firstParkingLot);
        standardParkingBoy.addParkingLot(secondParkingLot);
        Car car = new Car();
        Ticket ticket = standardParkingBoy.park(car);
        standardParkingBoy.fetch(ticket);

        // When
        Exception exception = assertThrows(Exception.class, () -> standardParkingBoy.fetch(ticket));

        // Then
        String expectedMessage = "Unrecognized parking ticket.";
        String exceptionMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(exceptionMessage));
    }

    @Test
    void should_return_error_message_when_park_given_2_parking_lot_and_no_position_left_() {
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot");
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot");
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        standardParkingBoy.addParkingLot(firstParkingLot);
        standardParkingBoy.addParkingLot(secondParkingLot);
        for (int i = 0; i < firstParkingLot.getCapacity(); i++){
            Car car = new Car();
            firstParkingLot.park(car);
        }
        for (int i = 0; i < secondParkingLot.getCapacity(); i++){
            Car car = new Car();
            secondParkingLot.park(car);
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
