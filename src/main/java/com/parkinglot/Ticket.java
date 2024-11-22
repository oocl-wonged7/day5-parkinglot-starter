package com.parkinglot;

public class Ticket {
    private String issuedBy;

    public String getIssuedBy() {
        return issuedBy;
    }

    Ticket(String issuedBy) {
        this.issuedBy = issuedBy;
    }
}
