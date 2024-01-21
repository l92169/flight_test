package com.example.testflights.model.enums;

public enum Location {
    VVO("VVO"),
    TLV("TLV"),
    UFA("UFA"),
    LRN("LRN");
    private final String location;

    Location(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return this.location;
    }
}
