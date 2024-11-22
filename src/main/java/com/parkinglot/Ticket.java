package com.parkinglot;

public class Ticket {
    private String issuedBy;
    private Boolean isUsed = false;

    public String getIssuedBy() {
        return issuedBy;
    }

    public Boolean isUsed() {
        return isUsed;
    }

    public void setIsUsed(){
        this.isUsed = true;
    }

    Ticket(String issuedBy) {
        this.issuedBy = issuedBy;
    }
}
