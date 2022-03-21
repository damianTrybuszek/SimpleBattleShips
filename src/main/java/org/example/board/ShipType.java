package org.example.board;

public enum ShipType {
    BATTLESHIP(5), DESTROYER(4);

    private final int shipLength;

    ShipType(int shipLength) {this.shipLength = shipLength;}

    public int getShipLength() {
        return this.shipLength;
    }
}
