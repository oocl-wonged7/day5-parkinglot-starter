package com.parkinglot;

public class Ticket {
    private final String issuedBy;
    private Boolean isUsed = false;

    Ticket(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public Boolean isUsed() {
        return isUsed;
    }

    public void setIsUsed() {
        this.isUsed = true;
    }
}
