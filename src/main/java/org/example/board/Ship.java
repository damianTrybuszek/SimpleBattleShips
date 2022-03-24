package org.example.board;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

@Getter
@Setter
public class Ship {
    protected LinkedList<Square> squaresList;
    private Random random;
    private ShipType shipType;
    private int length;
    private ShipOrientation shipOrientation;
    private int shipStartY;
    private int shipStartX;


    public Ship(ShipType shipType) {
        this.shipType = shipType;
        this.length = this.shipType.getShipLength();
        this.squaresList = new LinkedList<>();
    }
    public void setSquaresList() {
        this.squaresList.clear();
        for (int i = 0; i < this.shipType.getShipLength(); i++) {
            switch (this.shipOrientation) {
                case HORIZONTAL: {
                    this.squaresList.add(
                            new Square(this.shipStartY, this.shipStartX + i, SquareStatus.SHIP));
                    break;
                }
                case VERTICAL: {
                    this.squaresList.add(
                            new Square(this.shipStartY + i, this.shipStartX, SquareStatus.SHIP));
                    break;
                }
            }
        }
    }



}
