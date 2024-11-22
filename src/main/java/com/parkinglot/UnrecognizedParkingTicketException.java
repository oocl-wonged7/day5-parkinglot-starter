package com.parkinglot;

public class UnrecognizedParkingTicketException extends RuntimeException {
    public static final String UNRECOGNIZED_PARKING_TICKET_MESSAGE = "Unrecognized parking ticket.";
    public UnrecognizedParkingTicketException() {
        super(UNRECOGNIZED_PARKING_TICKET_MESSAGE);
    }
}
