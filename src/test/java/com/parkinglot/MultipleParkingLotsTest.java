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

    @Test
    void should_fetch_2_car_in_correct_order_when_fetch_twice_given_fetch_from_both_parking_lot(){
        // Given
        ParkingLot firstParkingLot = new ParkingLot("First Parking Lot");
        ParkingLot secondParkingLot = new ParkingLot("Second Parking Lot");
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(firstParkingLot);
        parkingBoy.addParkingLot(secondParkingLot);
        for (int i = 0; i < firstParkingLot.getCapacity() - 1; i++){
            Car car = new Car();
            parkingBoy.park(car);
        }
        Car firstCar = new Car();
        Ticket firstTicket = parkingBoy.park(firstCar);
        Car secondCar = new Car();
        Ticket secnodTicket = parkingBoy.park(secondCar);

        // When
        Car firstCarFetched = parkingBoy.fetch(firstTicket);
        Car secondCarFetched = parkingBoy.fetch(secnodTicket);

        // Then
        assert(firstCar.equals(firstCarFetched));
        assert(secondCar.equals(secondCarFetched));
    }
}
