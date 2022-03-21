package org.example.players;


import lombok.Getter;
import org.example.board.Board;
import org.example.board.Ship;
import org.example.board.ShipType;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Player {

    private String name;
    protected List<Ship> shipList;
    private Board playerBoard = new Board();
    private Board playerPlacementBoard = new Board();
    private Board shootingBoard = new Board();

    public Player(String name) {
        this.name = name;
        this.shipList = List.of(new Ship(ShipType.BATTLESHIP), new Ship(ShipType.DESTROYER), new Ship(ShipType.DESTROYER));
    }

    public boolean isAlive(){
        return !this.shipList.isEmpty();
    }

}
