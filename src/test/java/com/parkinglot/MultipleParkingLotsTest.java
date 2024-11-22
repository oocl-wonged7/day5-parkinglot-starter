package com.parkinglot;

import org.junit.jupiter.api.Test;

public class MultipleParkingLotsTest {
    @Test
    void should_park_to_parking_lot_1_when_park_given_both_parking_lot_have_position(){
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot");
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot");
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(firstParkingLot);
        parkingBoy.addParkingLot(secondParkingLot);
        Car car = new Car();

        // When
        Ticket ticket = parkingBoy.park(car);

        // Then
        assert(ticket.getIssuedBy().equals(firstParkingLot.getName()));
    }

    @Test
    void should_park_to_parking_log_2_when_park_given_parking_lot_1_is_full(){
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot");
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot");
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(firstParkingLot);
        parkingBoy.addParkingLot(secondParkingLot);
        for (int i = 0; i < firstParkingLot.getCapacity(); i++){
            Car car = new Car();
            parkingBoy.park(car);
        }
        Car anotherCar = new Car();

        // When
        Ticket ticket = parkingBoy.park(anotherCar);

        // Then
        assert(ticket.getIssuedBy().equals(secondParkingLot.getName()));
    }
}
